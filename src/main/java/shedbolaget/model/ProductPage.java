package shedbolaget.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class
 *
 * @author Emil Svensson, Pouya Shirin
 */
public class ProductPage {
    private final List<Product> products;

    public ProductPage(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int getNumberOfProducts() {
        return products.size();
    }
}
