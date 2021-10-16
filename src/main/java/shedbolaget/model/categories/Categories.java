package shedbolaget.model.categories;

import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Handles parsing of categories.
 *
 * @author Emil Svensson
 */
public enum Categories {
    ;

    /**
     * Gets level 1 categories from a products list.
     *
     * @param products the products list
     * @return the level 1 categories
     */
    public static List<Category> getLevel1Categories(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products)
            if (!categories.contains(product.getCategoryLevel1()))
                categories.add(product.getCategoryLevel1());
        return categories;
    }

    /**
     * Gets level 2 categories from a products list.
     *
     * @param products the products list
     * @return the level 2 categories
     */
    public static List<Category> getLevel2Categories(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products)
            if (!categories.contains(product.getCategoryLevel2()))
                categories.add(product.getCategoryLevel2());
        return categories;
    }

    /**
     * Gets the associated level 2 categories to the specified level 1 category.
     *
     * @param products       the products list
     * @param categoryLevel1 the category level 1
     * @return the associated level 2 categories
     */
    public static List<Category> getAssociatedLevel2Categories(List<Product> products, Category categoryLevel1) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products) {
            Category productCategoryLevel2 = product.getCategoryLevel2();
            if (categoryLevel1.equals(product.getCategoryLevel1()) && !categories.contains(productCategoryLevel2))
                categories.add(productCategoryLevel2);
        }
        return categories;
    }

    /**
     * Gets categories as a Map.
     *
     * @param products the products list
     * @return the categories as map with the key as the level 1 category and its associated subcategories as values
     */
    public static Map<Category, List<Category>> getCategoriesAsMap(List<Product> products) {
        Map<Category, List<Category>> categories = new HashMap<>();
        for (Category level1Category : getLevel1Categories(products))
            categories.put(level1Category, getAssociatedLevel2Categories(products, level1Category));
        return categories;
    }

    /**
     * Filters out categories based on a specified level.
     *
     * @param categories the categories list
     * @param level      the level to filter out categories from
     * @return all categories that match the specified level
     */
    public static List<Category> getCategoriesByLevel(List<Category> categories, int level) {
        return categories.stream().filter(category -> category.getLevel() == level).collect(Collectors.toList());
    }
}
