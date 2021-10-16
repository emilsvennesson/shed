package shedbolaget.model.products.filter;

import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 * @author Pouya Shirin
 */
enum ProductCategoryFilter {
    ;

    static List<Product> getFilteredProducts(List<Product> products, List<Category> categories) {
        categories = categories.stream().distinct().collect(Collectors.toList());  // ensure we have no duplicates
        List<Product> filteredProducts = new ArrayList<>();
        List<Category> level1Categories = Categories.getCategoriesByLevel(categories, 1);
        List<Category> level2Categories = Categories.getCategoriesByLevel(categories, 2);
        for (Category level1Category : level1Categories) {
            for (Category level2Category : level2Categories) {
                List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel2().getName(), level2Category.getName()) && Objects.equals(level1Category.getName(), product.getCategoryLevel1().getName())).collect(Collectors.toList());
                filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
            }
        }
        if (!filteredProducts.isEmpty() && !Categories.getCategoriesByLevel(categories, 1).isEmpty())
            return filteredProducts;
        for (Category level1Category : level1Categories) {
            List<Product> finalFilteredProducts = filteredProducts;
            List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel1().getName(), level1Category.getName()) && !finalFilteredProducts.contains(product)).collect(Collectors.toList());
            filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
        }
        return filteredProducts;
    }
}
