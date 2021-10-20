package shedbolaget.model.products.pages;

import shedbolaget.model.products.IProductsCollection;
import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a product page.
 *
 * @author Emil Svensson
 * @author Pouya Shirin
 */
record ProductPage(List<Product> products) implements IProductsCollection {

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public int getNumberOfProducts() {
        return products.size();
    }
}
