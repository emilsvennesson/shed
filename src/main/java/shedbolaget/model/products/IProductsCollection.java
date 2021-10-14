package shedbolaget.model.products;

import java.util.List;

public interface IProductsCollection {
    List<Product> getProducts();
    int getNumberOfProducts();
}
