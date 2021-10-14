package shedbolaget.model.products;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class
 *
 * @author Emil Svensson, Pouya Shirin
 */
class ProductPage implements IProductsCollection {
    private final List<Product> products;

    public ProductPage(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }
}
