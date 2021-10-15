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

    public static List<Category> getLevel1Categories(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products)
            if (!categories.contains(product.getCategoryLevel1()))
                categories.add(product.getCategoryLevel1());
        return categories;
    }

    public static List<Category> getLevel2Categories(List<Product> products) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products)
            if (!categories.contains(product.getCategoryLevel2()))
                categories.add(product.getCategoryLevel2());
        return categories;
    }

    public static List<Category> getAssociatedLevel2Categories(List<Product> products, Category categoryLevel1) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products) {
            Category productCategoryLevel2 = product.getCategoryLevel2();
            if (categoryLevel1.equals(product.getCategoryLevel1()) && !categories.contains(productCategoryLevel2))
                categories.add(productCategoryLevel2);
        }
        return categories;
    }

    public static Map<Category, List<Category>> getCategoriesAsMap(List<Product> products) {
        Map<Category, List<Category>> categories = new HashMap<>();
        for (Category level1Category : getLevel1Categories(products))
            categories.put(level1Category, getAssociatedLevel2Categories(products, level1Category));
        return categories;
    }

    public static List<Category> getCategoriesByLevel(List<Category> categories, int level) {
        return categories.stream().filter(category -> category.getLevel() == level).collect(Collectors.toList());
    }
}
