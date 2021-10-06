package shedbolaget.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A filtering class where its use is to return a filtered list of products depending on
 * the given keywords (categories)
 */
class Filter {
    private final List<Product> products;

    public String getActiveCategoryLevel1Filter() {
        return activeCategoryLevel1Filter;
    }

    private String activeCategoryLevel1Filter;
    private final List<String> activeCategoryLevel2Filters = new ArrayList<>();
    private final HashMap<String, List<String>> categories = new HashMap<>();

    /**
     *
     * @param products
     */
    public Filter(List<Product> products) {
        this.products = products;
        initCategories();
    }

    public List<String> getActiveCategoryLevel2Filters() {
        return activeCategoryLevel2Filters;
    }

    /**
     * This method sets the keyword of the first level of filtering.
     * @param categoryName
     */
    public void setCategoryLevel1Filter(String categoryName) {
        activeCategoryLevel1Filter = categoryName;
    }

    /**
     * Clears the level 1 category keyword.
     */
    public void clearCategoryLevel1Filter() {
        activeCategoryLevel1Filter = "";
    }

    /**
     * Adds a keyword to level 2 category filtering.
     * @param categoryName
     */
    public void addCategoryLevel2Filter(String categoryName) {
        activeCategoryLevel2Filters.add(categoryName);
    }

    /**
     * Removes a keyword from the level 2 category filtering.
     * @param categoryName
     */
    public void removeCategoryLevel2Filter(String categoryName) {
        activeCategoryLevel2Filters.remove(categoryName);
    }

    /**
     * Clears all level 2 category filter keywords.
     */
    public void clearCategoryLevel2Filters() {
        activeCategoryLevel2Filters.clear();
    }

    /**
     * Clears both category filters.
     */
    public void clearAllFilters(){
        clearCategoryLevel1Filter();
        clearCategoryLevel2Filters();
    }

    /**
     * Return a list of products, filtered by set keywords from category level 1 and 2.
     * @return a list of products.
     */
    public List<Product> getFilteredProducts() {
        return getFilteredLevel2Products(getFilteredLevel1Products());
    }

    public List<Product> getFilteredProducts(String filterString){
        return (getFilteredProducts().stream().filter(product ->  product.getProductNameBold().toLowerCase().contains(filterString.toLowerCase())
                || product.getCategoryLevel1().toLowerCase().contains(filterString.toLowerCase())
                || product.getCategoryLevel2().toLowerCase().contains(filterString.toLowerCase()))
                .collect(Collectors.toList()));
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

    /**
     * Sort the products with the given variable.
     * @param variableName Variable to sort the products by
     * @param lowestToHighest Option to sort the products from lowest to highest or vice versa.
     */
    public void sortProductsByVariable(String variableName, boolean lowestToHighest) {
        String methodName = "get" + getCapitalizedString(variableName);
        try {
            Method method = Objects.requireNonNull(getMethodByName(methodName));
            sortProducts(method);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("ERROR: No valid variable in sortProductsByVariable");
        }

        if (!lowestToHighest)
            Collections.reverse(products);
    }

    private void sortProducts(Method method) {
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
    private String getCapitalizedString(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private Method getMethodByName(String methodName) {
        try {
            return Product.class.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<String> getCategoriesLevel1() {
        List<String> categories = new ArrayList<>();
        for (Product product : products)
            if (!categories.contains(product.getCategoryLevel1()))
                categories.add(product.getCategoryLevel1());
        return categories;
    }

    private List<String> getCategoriesLevel2(String categoryLevel1) {
        List<String> categories = new ArrayList<>();
        for (Product product : products)
            if (Objects.equals(product.getCategoryLevel1(), categoryLevel1) && !categories.contains(product.getCategoryLevel2()))
                categories.add(product.getCategoryLevel2());
        return categories;
    }


    private void initCategories() {
        for (String level1Category : getCategoriesLevel1()) {
            categories.put(level1Category, getCategoriesLevel2(level1Category));
        }
    }

    public HashMap<String, List<String>> getCategories() {
        return categories;
    }

    /**
     * This method returns products whose id is equal to the given id.
     * @param id
     * @return a list of products
     */
    public List<Product> getProducts(int id){
            return (products.stream().filter(product -> id == Integer.parseInt(product.getProductId()))
                    .collect(Collectors.toList()));

    }

    /**
     * This method returns products that matches with the given string. It looks at 1. product name, 2. category level 1-3
     * @param filterString
     * @return
     */
    public List<Product> getProducts(String filterString){
        return (products.stream().filter(product ->  product.getProductNameBold().toLowerCase().contains(filterString.toLowerCase())
        || product.getCategoryLevel1().toLowerCase().contains(filterString.toLowerCase())
        || product.getCategoryLevel2().toLowerCase().contains(filterString.toLowerCase()))
                .collect(Collectors.toList()));
    }

    public String getActiveLevel1Category(){
        return activeCategoryLevel1Filter;
    }

    public ArrayList<String> getActiveLevel2Categories(){
        return new ArrayList<>(activeCategoryLevel2Filters);
    }
}
