package shedbolaget.model.products.parser;

import shedbolaget.model.products.Product;

import java.util.List;

/**
 * A common interface for parsing of Product objects to a list.
 *
 * @author Emil Svensson
 */
public interface IProductsParser {
    /**
     * Gets Product objects and puts them in a List.
     *
     * @return the Product objects as a List.
     * @see shedbolaget.model.products.Product
     */
    List<Product> getProducts();
}
