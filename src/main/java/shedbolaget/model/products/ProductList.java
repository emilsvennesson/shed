package shedbolaget.model.products;

import shedbolaget.model.products.customproduct.CustomProduct;
import shedbolaget.model.products.parser.ProductsParserFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all products available in the products JSON file.
 *
 * @author Emil Svensson
 * @author Samuel Kajava
 * @author Pouya Shirin
 */
public class ProductList implements IProductsCollection {
    private final List<Product> products = ProductsParserFactory.createJSONParser("data.json").getProducts();
    private static final ProductList instance = new ProductList();

    private ProductList() {
    }

    /**
     *
     * @return the single instance of the object
     */
    public static ProductList getInstance() {
        return instance;
    }

    /**
     *
     * @return all products
     */
    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>(products);
        allProducts.addAll(ProductsParserFactory.createJSONParser(CustomProduct.CUSTOM_PRODUCTS_FILENAME).getProducts());
        return new ArrayList<>(allProducts);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }

    public int getNumberOfCustomProducts() {
        return ProductsParserFactory.createJSONParser(CustomProduct.CUSTOM_PRODUCTS_FILENAME).getProducts().size();
    }

    public int getNumberOfAllProducts(){
        return getNumberOfProducts() + getNumberOfCustomProducts();
    }
}
