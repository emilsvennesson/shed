package shedbolaget.model.events;

import shedbolaget.model.products.Product;

public class CustomProductCreatedEvent {
    private final Product product;
    public  CustomProductCreatedEvent(Product product){
        this.product = product;
    }

    public Product getProduct(){ return product; }
}

