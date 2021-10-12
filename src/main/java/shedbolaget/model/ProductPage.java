package shedbolaget.model;

import java.util.List;

/**
 * This is a class
 *
 * @author Emil Svensson, Pouya Shirin
 */
public class ProductPage<T> {
    private final List<T> products;

    public ProductPage(List<T> products) {
        this.products = products;
    }

    public List<T> getProducts() {
        return products;
    }
}
