package backend;

import backend.parser.ParserFactory;
import backend.parser.IProductParser;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
    public List<Product> getProducts(String filter) {
        return Filter.getProducts(products, filter);
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

    public List<Product> getCategory(String category){
        return  Filter.getCategory(products, category);
    }
}
