package shedbolaget.model.events;

import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;

public class PagesEvent {
    private final int currentPage;
    private final List<Product> pageProducts;

    public PagesEvent(int currentPage, List<Product> pageProducts) {
        this.currentPage = currentPage;
        this.pageProducts = pageProducts;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public List<Product> getPageProducts() {
        return new ArrayList<>(pageProducts);
    }

}
