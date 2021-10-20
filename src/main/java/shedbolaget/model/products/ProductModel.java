package shedbolaget.model.products;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all products available in the products JSON file.
 *
 * @author Emil Svensson
 * @author Samuel Kajava
 * @author Pouya Shirin
 */
public class ProductModel {
    private final List<IProductsCollection> collections = new ArrayList<>();
    private static final ProductModel instance = new ProductModel();
    private List<Product> products;

    private ProductModel() {
        collections.add(ProductList.getInstance());
        collections.add(CustomProductList.getInstance());
    }

    /**
     * @return the single instance of the object
     */
    public static ProductModel getInstance() {
        return instance;
    }

    /**
     * @return all products
     */
    public List<Product> getAllProducts() {
        products = new ArrayList<>();
        for (IProductsCollection collection : collections)
            products.addAll(collection.getProducts());
        return products;
    }

    public int getNumberOfProducts() {
        return getAllProducts().size();
    }

    public List<Product> getProductsById(int id) {
        List<Product> matches = new ArrayList<>();
        for (Product p : getAllProducts()) {
            if (Integer.parseInt(p.getProductId()) == id)
                matches.add(p);
        }
        return matches;
    }
}
