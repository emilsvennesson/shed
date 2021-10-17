package shedbolaget.model.products.parser;

import shedbolaget.model.products.Product;
import shedbolaget.model.products.customproduct.CustomProduct;

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
        return jsonParser.getProducts("data.json");
    }
    public static List<Product> getCustomProductsFromJson() {
        return jsonParser.getProducts(CustomProduct.CUSTOM_PRODUCTS_FILENAME);
    }

}
