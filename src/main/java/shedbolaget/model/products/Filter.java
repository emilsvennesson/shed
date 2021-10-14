package shedbolaget.model.products;

import shedbolaget.model.categories.Category;

import java.util.List;

/**
 * This class is responsible for filtering out products.
 *
 * @author Emil Svensson, Samuel Kajava
 */
public class Filter {
    private Filter() {
    }

    /**
     * Gets filtered products based on categories.
     *
     * @param products   the products list to filter from
     * @param categories the categories list with filters to apply to the products list
     * @return the filtered products that matches the list of categories specified
     */
    public static List<Product> getFilteredProductsByCategory(List<Product> products, List<Category> categories) {
        return ProductCategoryFilter.getFilteredProducts(products, categories);
    }

}

