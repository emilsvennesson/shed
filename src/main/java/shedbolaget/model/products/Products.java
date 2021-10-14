package shedbolaget.model.products;

import shedbolaget.model.parser.ProductParserFactory;

import java.util.List;

public class Products implements IProductsCollection {
    private final List<Product> allProducts = ProductParserFactory.getProductsFromJson();
    private static final Products instance = new Products();
    private Products() {
    }

    public static Products getInstance() {
        return instance;
    }

    @Override
    public List<Product> getAllProducts() {
        return allProducts;
    }

    @Override
    public int getNumberOfProducts() {
        return allProducts.size();
    }
}
