package shedbolaget.model.products.filter;

import shedbolaget.model.products.Product;
import shedbolaget.model.products.categories.Categories;
import shedbolaget.model.products.categories.Category;

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
enum ProductsCategoryFilter {
    ;

    static List<Product> getFilteredProducts(List<Product> products, List<Category> categories) {
        categories = categories.stream().distinct().collect(Collectors.toList());  // ensure we have no duplicates
        List<Product> filteredProducts = new ArrayList<>();
        List<Category> level1Categories = Categories.getCategoriesByLevel(categories, 1);
        List<Category> level2Categories = Categories.getCategoriesByLevel(categories, 2);
        if (level1Categories.isEmpty()) {  // check lvl 2 categories and return result
            for (Category level2Category : level2Categories) {
                List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel2().getName(), level2Category.getName())).collect(Collectors.toList());
                return Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
            }
        } else {
            for (Category level1Category : level1Categories) {
                for (Category level2Category : level2Categories) {  // make sure lvl 2 category matches lvl 2 & lvl 1 matches lvl 1
                    List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel2().getName(), level2Category.getName()) && Objects.equals(level1Category.getName(), product.getCategoryLevel1().getName())).collect(Collectors.toList());
                    filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
                }
            }
            if (!filteredProducts.isEmpty() && !Categories.getCategoriesByLevel(categories, 1).isEmpty())
                return filteredProducts;  // we need to return here to avoid duplicate items
            for (Category level1Category : level1Categories) {
                List<Product> finalFilteredProducts = filteredProducts;
                List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel1().getName(), level1Category.getName()) && !finalFilteredProducts.contains(product)).collect(Collectors.toList());
                filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
            }

        }
        return filteredProducts;
    }
}
