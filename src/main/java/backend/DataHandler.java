package backend;

import backend.parser.ParserFactory;
import backend.parser.IProductParser;

import java.util.List;

public class DataHandler {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public DataHandler() {
        populateProducts(ParserFactory.makeJsonParser());
    }


    public int getSize() {
        return this.products.size();
    }

    private void populateProducts(IProductParser parser) {
        products = parser.getProducts();
    }
}
