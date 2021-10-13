package shedbolaget.model.categories;

import shedbolaget.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class that can be used to parse categories from a products list.
 *
 * @author Emil Svensson
 */
public class Categories {
    private Categories() {
    }

    private static List<Category> getCategoriesLevel1(List<Product> products) {
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
    public static HashMap<Category, List<Category>> getCategories(List<Product> products) {
        HashMap<Category, List<Category>> categories = new HashMap<>();
        for (Category level1Category : getCategoriesLevel1(products))
            categories.put(level1Category, getCategoriesLevel2(products, level1Category));
        return categories;
    }

    public static List<Category> getCategories(List<Category> categories, int level) {
        return categories.stream().filter(category -> category.getLevel() == level).collect(Collectors.toList());
    }
}
