package shedbolaget.backend;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Filter {
    private List<Product> products;
    private String activeCategoryLevel1Filter;
    private List<String> activeCategoryLevel2Filters = new ArrayList<>();

    public Filter(List<Product> products) {
        this.products = products;
    }

    public void setCategoryLevel1Filter(String categoryName) {
        activeCategoryLevel1Filter = categoryName;
    }

    public void clearCategoryLevel1Filter() {
        activeCategoryLevel1Filter = "";
    }

    public void addCategoryLevel2Filter(String categoryName) {
        activeCategoryLevel2Filters.add(categoryName);
    }

    public void removeCategoryLevel2Filter(String categoryName) {
        activeCategoryLevel2Filters.remove(categoryName);
    }

    public void clearCategoryLevel2Filters() {
        activeCategoryLevel2Filters.clear();
    }


    public List<Product> getFilteredProducts() {
        return getFilteredLevel2Products(getFilteredLevel1Products());
    }

    //This method filters the whole sortiment on the condition given by "activeCategoryLevel1" string
    private List<Product> getFilteredLevel1Products() {
        try {
            return products.stream()
                    .filter(product -> product.getCategoryLevel1().toLowerCase().contains(activeCategoryLevel1Filter.toLowerCase()))
                    .collect(Collectors.toList());
        } catch (NullPointerException e) {
            return products;
        }
    }

    //Filter the level 2 categories based on level 1 products
    private List<Product> getFilteredLevel2Products(List<Product> filteredLevel1Products) {
        Stream<Product> productsStreamLevel2 = Stream.empty();
        if (activeCategoryLevel2Filters.size() > 0) {
            for (String condition : activeCategoryLevel2Filters) {
                productsStreamLevel2 = Stream.concat(productsStreamLevel2, filteredLevel1Products
                        .stream()
                        .filter(product -> product.getCategoryLevel2().toLowerCase().contains(condition.toLowerCase())));
            }
            return productsStreamLevel2.collect(Collectors.toList());
        } else {
            return filteredLevel1Products;
        }
    }

    public void sortProductsByVariable(String variableName, boolean lowestToHighest) {
        String methodName = "get" + getCapitalizedString(variableName);
        try{
        Method method = Objects.requireNonNull(getMethodByName(methodName));
        sortProducts(method);
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("ERROR: No valid variable in sortProductsByVariable");
        }

        if(!lowestToHighest)
            Collections.reverse(products);
    }
    private void sortProducts(Method method){
        products.sort((product1, product2) -> {
            try {
                return Double.compare((double) method.invoke(product1), (double) method.invoke(product2));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return 0;
            }
        });
    }
    //Detta kanske ska vara en static metod i en utility klass
    private String getCapitalizedString(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    private Method getMethodByName(String methodName) {
        try {
            return Product.class.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Product getProduct(int id){
            return (products.stream().filter(product -> id == Integer.parseInt(product.getProductId()))
                    .findAny()
                    .orElse(new Product()));

    }
}
