package backend;

import backend.parser.ParserFactory;
import backend.parser.IProductParser;

import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private List<Product> products;
    private Filter filter;

    public List<Product> getProducts() {
        return products;
    }
    public DataHandler() {
        populateProducts(ParserFactory.makeJsonParser());
        filter = new Filter(getProducts());
    }


    public int getSize() {
        return this.products.size();
    }

    private void populateProducts(IProductParser parser) {
        products = parser.getProducts();
    }

    public void setCategoryLevel1Filter(String categoryName){
        filter.setCategoryLevel1Filter(categoryName);
    }

    public void clearCategoryLevel1Filter(){
        filter.clearCategoryLevel1Filter();
    }

    public void addCategoryLevel2Filter(String categoryName){
        filter.addCategoryLevel2Filter(categoryName);
    }

    public void removeCategoryLevel2Filter(String categoryName){
        filter.removeCategoryLevel2Filter(categoryName);
    }

    public void clearCategoryLevel2Filters(){
        filter.clearCategoryLevel2Filters();
    }


    public List<Product> getFilteredProducts(){
        return filter.getFilteredProducts();
    }

}
