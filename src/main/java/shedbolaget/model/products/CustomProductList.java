package shedbolaget.model.products;

import shedbolaget.model.products.customproduct.CustomProduct;
import shedbolaget.model.products.parser.ProductsParserFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all products available in the products JSON file.
 * @author Pouya Shirin
 */
public class CustomProductList implements IProductsCollection {
    private List<Product> products = ProductsParserFactory.createJSONParser(CustomProduct.CUSTOM_PRODUCTS_FILENAME).getProducts();
    private static final CustomProductList instance = new CustomProductList();

    private CustomProductList() {
    }

    /**
     *
     * @return the single instance of the object
     */
    public static CustomProductList getInstance() {
        return instance;
    }

    /**
     *
     * @return all products
     */
    @Override
    public List<Product> getProducts() {
        products = ProductsParserFactory.createJSONParser(CustomProduct.CUSTOM_PRODUCTS_FILENAME).getProducts();
        return new ArrayList<>(products);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }
}
