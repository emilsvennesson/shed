package shedbolaget.model.products.parser;

import shedbolaget.model.products.Product;

import java.util.List;

/**
 * The products parser factory.
 *
 * @author Emil Svensson
 */
public enum ProductsParserFactory {
    ;
    private static final ProductsJsonFileParser jsonParser = new ProductsJsonFileParser();

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
