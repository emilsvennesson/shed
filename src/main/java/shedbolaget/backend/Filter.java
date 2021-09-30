package shedbolaget.backend;

import java.util.ArrayList;
import java.util.List;
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

}
