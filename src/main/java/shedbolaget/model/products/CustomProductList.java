package shedbolaget.model.products;

import shedbolaget.model.products.customproduct.CustomProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds all products available in the products JSON file.
 *
 * @author Pouya Shirin
 */
class CustomProductList implements IProductsCollection {
    private List<Product> products = new ArrayList<>();
    private static final CustomProductList instance = new CustomProductList();

    private CustomProductList() {
    }

    /**
     * @return the single instance of the object
     */
    static CustomProductList getInstance() {
        return instance;
    }

    /**
     * @return all products
     */
    @Override
    public List<Product> getProducts() {
        products = CustomProduct.getCustomProducts();
        return new ArrayList<>(products);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }
}
