package shedbolaget.model.categories;

import shedbolaget.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class is responsible for filtering out products based on categories.
 *
 * @author Emil Svensson, Samuel Kajava
 */
public class CategoryProductFilter {
    private CategoryProductFilter() {
    }


    /**
     * Gets filtered products.
     *
     * @param products   the products list to filter from
     * @param categories the categories list with filters to apply to the products list
     * @return the filtered products that matches the list of categories specified
     */
    public static List<Product> getFilteredProducts(List<Product> products, List<Category> categories) {
        categories = categories.stream().distinct().collect(Collectors.toList());  // ensure we have no duplicates
        List<Product> filteredProducts = new ArrayList<>();
        List<Category> level1Categories = Categories.getCategories(categories, 1);
        List<Category> level2Categories = Categories.getCategories(categories, 2);
        for (Category level2Category : level2Categories) {
            List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel2().getName(), level2Category.getName())).collect(Collectors.toList());
            filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
        }
        if (!filteredProducts.isEmpty() && !Categories.getCategories(categories, 1).isEmpty())
            return filteredProducts;
        for (Category level1Category : level1Categories) {
            List<Product> finalFilteredProducts = filteredProducts;
            List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel1().getName(), level1Category.getName()) && !finalFilteredProducts.contains(product)).collect(Collectors.toList());
            filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
        }
        return filteredProducts;
    }

}

