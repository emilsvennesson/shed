package shedbolaget.model.products;

import shedbolaget.model.products.parser.ProductsParserFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all products available in the products JSON file.
 *
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class ProductsHolder implements IProductsCollection {
    private final List<Product> products = ProductsParserFactory.getProductsFromJson();
    private static final ProductsHolder instance = new ProductsHolder();

    private ProductsHolder() {
    }

    public static ProductsHolder getInstance() {
        return instance;
    }

    public List<Product> getProducts(){
        return new ArrayList<>(products);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>(products);
        allProducts.addAll(ProductsParserFactory.getCustomProductsFromJson());
        return allProducts;
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }

    public int getNumberOfCustomProducts(){
        return ProductsParserFactory.getCustomProductsFromJson().size();
    }

    public int getNumberOfAllProducts(){
        return getNumberOfProducts() + getNumberOfCustomProducts();
    }
}
