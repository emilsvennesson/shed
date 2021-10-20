package shedbolaget.model.products;

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
class ProductList implements IProductsCollection {
    private final List<Product> products = ProductsParserFactory.createJSONParser("data.json").getProducts();
    private static final ProductList instance = new ProductList();

    private ProductList() {
    }

    /**
     * @return the single instance of the object
     */
    static ProductList getInstance() {
        return instance;
    }

    /**
     * @return all products
     */
    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }
}
