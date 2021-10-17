package shedbolaget.model.products.filter;

import shedbolaget.model.categories.Category;
import shedbolaget.model.products.Product;

import java.util.List;

/**
 * This class is responsible for filtering out products.
 *
 * @author Emil Svensson
 * @author Samuel Kajava
 * @author Pouya Shirin
 */
public enum Filter {
    ;

    /**
     * Gets filtered products based on categories.
     *
     * @param products   the products list to filter from
     * @param categories the categories list with filters to apply to the products list
     * @return the filtered products that matches the list of categories specified.
     * If
     */
    public static List<Product> getFilteredProductsByCategory(List<Product> products, List<Category> categories) {
        return ProductsCategoryFilter.getFilteredProducts(products, categories);
    }

    public static List<Product> search(List<Product> products, String query, int requiredHitRatio) {
        return ProductsSearch.search(products, query, requiredHitRatio);
    }

}

