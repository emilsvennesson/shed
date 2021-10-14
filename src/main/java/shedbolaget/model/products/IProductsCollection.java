package shedbolaget.model.products;

import java.util.List;

public interface IProductsCollection {
    List<Product> getAllProducts();

    int getNumberOfProducts();
}
