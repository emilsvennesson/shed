package shedbolaget.model.products;

import java.util.List;

/**
 * A common interface for a products list.
 */
public interface IProductsCollection {
    /**
     * Gets all products in the products list.
     *
     * @return all products in the list
     */
    List<Product> getAllProducts();

    /**
     * Gets the number of products.
     *
     * @return the number of products in the list
     */
    int getNumberOfProducts();
}
