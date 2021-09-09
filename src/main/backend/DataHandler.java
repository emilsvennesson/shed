package java.backend;

import java.util.List;

public class DataHandler {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public DataHandler() {
        setProducts(new ProductJsonFileParser());
    }

    private void setProducts(IProductParser parser) {
        products = parser.getProducts();
    }
}
