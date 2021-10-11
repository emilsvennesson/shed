package shedbolaget.model.filter;

import shedbolaget.model.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A filtering class where its use is to return a filtered list of products depending on
 * the given keywords (categories)
 *
 * @author Pouya Shirin, Samuel Kajava, Emil Svensson
 */
public class Filter {
    private final List<Product> products;

    public String getActiveCategoryLevel1Filter() {
        return activeCategoryLevel1Filter;
    }

    private String activeCategoryLevel1Filter;
    private final List<String> activeCategoryLevel2Filters = new ArrayList<>();
    private final HashMap<String, List<String>> categories = new HashMap<>();

    /**
     * Represents a filter for a list of products
     * @param products a List of Products
     */
    public Filter(List<Product> products) {
        this.products = products;
        initCategories();
    }

    /**
     * @return a list of active category level 2 filters
     */
    public List<String> getActiveCategoryLevel2Filters() {
        return activeCategoryLevel2Filters;
    }

    /**
     * This method sets the keyword of the first level of filtering.
     * @param categoryName name of the category to set as level 1
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
     * @param categoryName name of the category to set as level 2
     */
    public void addCategoryLevel2Filter(String categoryName) {
        activeCategoryLevel2Filters.add(categoryName);
    }

    /**
     * Removes a keyword from the level 2 category filtering.
     * @param categoryName name of the level 2 category to remove
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

    /**
     * Return a list of products, filtered by set keywords from category level 1, 2 and string keyword.
     * Parameter filters by product name and product categories.
     * @param filterString a string to filter the products with.
     * @return a list of products.
     */
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


    //Detta kanske ska vara en static metod i en utility klass
    private String getCapitalizedString(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1);
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

    /**
     * Gets all the filter's categories
     * @return a HashMap containing all categories with their respective sub-categories
     */
    public HashMap<String, List<String>> getCategories() {
        return new HashMap<>(categories);
    }

    /**
     * This method returns products whose id is equal to the given id.
     * @param id    the product ID to get
     * @return a list of products sharing the given ID
     */
    public List<Product> getProducts(int id){
        return (products.stream().filter(product -> id == Integer.parseInt(product.getProductId()))
                .collect(Collectors.toList()));
    }

    /**
     * This method returns products that matches with the given string. It looks at 1. product name, 2. category level 1-3
     * @param filterString a string to match with a product's name or categories 1-2
     * @return a List of products matching the given filterString
     */
    public List<Product> getProducts(String filterString){
        return (products.stream().filter(product ->  product.getProductNameBold().toLowerCase().contains(filterString.toLowerCase())
        || product.getCategoryLevel1().toLowerCase().contains(filterString.toLowerCase())
        || product.getCategoryLevel2().toLowerCase().contains(filterString.toLowerCase()))
                .collect(Collectors.toList()));
    }
    /**
     *
     * @return active level 1 category
     */
    public String getActiveLevel1Category(){
        return activeCategoryLevel1Filter;
    }

    /**
     *
     * @return active level 2 categories
     */
    public ArrayList<String> getActiveLevel2Categories(){
        return new ArrayList<>(activeCategoryLevel2Filters);
    }
}
