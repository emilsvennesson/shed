package shedbolaget.model.products;

import shedbolaget.model.products.parser.ProductsParserFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all products available in the products JSON file.
 *
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class ProductsHolder implements IProductsCollection {
    private final List<Product> allProducts = ProductsParserFactory.getProductsFromJson();
    private static final ProductsHolder instance = new ProductsHolder();

    private ProductsHolder() {
    }

    public static ProductsHolder getInstance() {
        return instance;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(allProducts);
    }

    @Override
    public int getNumberOfProducts() {
        return allProducts.size();
    }
}
