package shedbolaget.model.categories;

import shedbolaget.model.products.Product;
import shedbolaget.model.products.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Handles and parses categories from a products list.
 *
 * @author Emil Svensson
 */
public enum Categories {
    ;
    private static final Map<Category, List<Category>> allCategories = getCategoriesByLevel(Products.getInstance().getAllProducts());

    public static List<Category> getCategoriesLevel1(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products)
            if (!categories.contains(product.getCategoryLevel1()))
                categories.add(product.getCategoryLevel1());
        return categories;
    }

    public static List<Category> getCategoriesLevel2(List<Product> products, Category categoryLevel1) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products) {
            Category productCategoryLevel2 = product.getCategoryLevel2();
            if (categoryLevel1.equals(product.getCategoryLevel1()) && !categories.contains(productCategoryLevel2))
                categories.add(productCategoryLevel2);
        }
        return categories;
    }

    /**
     * Gets all available categories in a specified product list.
     *
     * @param products the list of products to retrieve categories from
     * @return the categories in which each key has its associated subcategories as value
     */
    private static Map<Category, List<Category>> getCategoriesByLevel(List<Product> products) {
        Map<Category, List<Category>> categories = new HashMap<>();
        for (Category level1Category : getCategoriesLevel1(products))
            categories.put(level1Category, getCategoriesLevel2(products, level1Category));
        return categories;
    }

    public static List<Category> getCategoriesByLevel(List<Category> categories, int level) {
        return categories.stream().filter(category -> category.getLevel() == level).collect(Collectors.toList());
    }

    public static Map<Category, List<Category>> getAllCategories() {
        return allCategories;
    }

    public static List<Category> getSubCategories(Category category) {
        return Categories.getCategoriesLevel2(Products.getInstance().getAllProducts(), category);
    }
}
