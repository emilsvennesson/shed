package shedbolaget.model.events;

import shedbolaget.model.Product;

import java.util.List;

public class SortEvent {
    private final List<Product> products;

    public SortEvent(List<Product> products) {
        this.products = products;
    }

    public List<Product> getSortedProductList() {
        return products;
    }

}

