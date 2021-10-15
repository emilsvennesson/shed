package shedbolaget.model.products;

import shedbolaget.model.parser.ProductParserFactory;

import java.util.List;

/**
 * This class holds all products available in the products JSON file.
 */
public class ProductsHolder implements IProductsCollection {
    private final List<Product> allProducts = ProductParserFactory.getProductsFromJson();
    private static final ProductsHolder instance = new ProductsHolder();

    private ProductsHolder() {
    }

    public static ProductsHolder getInstance() {
        return instance;
    }

    @Override
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Override
    public int getNumberOfProducts() {
        return allProducts.size();
    }
}
