package shedbolaget.model.filter;

import shedbolaget.model.Category;
import shedbolaget.model.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategoryFilter {
    public static List<Product> getFilteredProducts(List<Product> products, List<Category> categories) {
        List<Product> filteredProducts = new ArrayList<>();
        List<Category> level1Categories = categories.stream().filter(category -> category.getLevel() == 1).collect(Collectors.toList());
        List<Category> level2Categories = categories.stream().filter(category -> category.getLevel() == 2).collect(Collectors.toList());
        for (Category level2Category : level2Categories) {
            List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel2().getName(), level2Category.getName())).collect(Collectors.toList());
            filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
        }
        for (Category level1Category : level1Categories) {
            List<Product> finalFilteredProducts = filteredProducts;
            List<Product> prods = products.stream().filter(product -> Objects.equals(product.getCategoryLevel1().getName(), level1Category.getName()) && !finalFilteredProducts.contains(product)).collect(Collectors.toList());
            filteredProducts = Stream.of(filteredProducts, prods).flatMap(Collection::stream).collect(Collectors.toList());
        }
        return filteredProducts;
    }

}

