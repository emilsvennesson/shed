package shedbolaget.model.parser;

import shedbolaget.model.products.Product;

import java.util.List;

/**
 * The products parser factory.
 *
 * @author Emil Svensson
 */
public enum ProductParserFactory {
    ;
    private static final ProductJsonFileParser jsonParser = new ProductJsonFileParser();

    /**
     * Gets products from the JSON resource file.
     *
     * @return the products from the JSON resource file in a List.
     * @see Product
     */
    public static List<Product> getProductsFromJson() {
        return jsonParser.getProducts();
    }
}
