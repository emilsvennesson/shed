package shedbolaget.model.products;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all products available in the products JSON file as well as custom made products.
 *
 * @author Emil Svensson
 * @author Samuel Kajava
 * @author Pouya Shirin
 */
public class ProductModel implements IProductsCollection {
    private static final ProductModel instance = new ProductModel();
    private final List<IProductsCollection> collections = new ArrayList<>();

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

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (IProductsCollection collection : collections)
            products.addAll(collection.getProducts());
        return products;
    }

    @Override
    public int getNumberOfProducts() {
        return getProducts().size();
    }

    /**
     * Gets products by specified product ID.
     *
     * @param id the product ID
     * @return a list of products that matches the ID
     */
    public List<Product> getProductsById(int id) {
        List<Product> matches = new ArrayList<>();
        for (Product p : getProducts()) {
            if (Integer.parseInt(p.getProductId()) == id)
                matches.add(p);
        }
        return matches;
    }

    /**
     * Finds the first available id in products.
     * @return id
     */
    public int getAvailableId(){
        List<Integer> idList = new ArrayList<>();
        for (Product product : getProducts())
            idList.add((Integer.parseInt(product.getProductId())));

        int index = 0;
        while(idList.contains(index))
            index++;
        return index;
    }
}
