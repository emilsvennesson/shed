package shedbolaget.model.products.pages;

import shedbolaget.model.products.IProductsCollection;
import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a product page.
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
