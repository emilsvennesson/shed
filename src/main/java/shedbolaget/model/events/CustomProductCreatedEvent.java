package shedbolaget.model.events;

import shedbolaget.model.categories.Category;
import shedbolaget.model.products.Product;

import java.util.List;

public class CustomProductCreatedEvent {
    private final Product product;
    public  CustomProductCreatedEvent(Product product){
        this.product = product;
    }

    public Product getProduct(){ return product; }
}

