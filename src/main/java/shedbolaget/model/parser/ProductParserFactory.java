package shedbolaget.model.parser;

import shedbolaget.model.products.Product;

import java.util.List;

/**
 * @author Emil Svensson
 */
public final class ProductParserFactory {
    private static final ProductJsonFileParser jsonParser = new ProductJsonFileParser();

    private ProductParserFactory() {
    }

    public static List<Product> getProductsFromJson() {
        return jsonParser.getProducts();
    }
}
