package shedbolaget.model.parser;

import shedbolaget.model.products.Product;

import java.util.List;

/**
 * @author Emil Svensson
 */
public interface IProductParser {
    List<Product> getProducts();
}
