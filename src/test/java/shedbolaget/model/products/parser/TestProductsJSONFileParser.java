package shedbolaget.model.products.parser;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.IProductsCollection;

public class TestProductsJSONFileParser {
    @Test
    public void testGetProducts() {
        IProductsCollection parser = new ProductsJSONFileParser(ClassLoader.getSystemClassLoader().getResourceAsStream("data.json"));
        Assert.assertTrue(parser.getProducts().size() > 0);
    }

    @Test
    public void testGetNumberOfProducts() {
        IProductsCollection parser = new ProductsJSONFileParser(ClassLoader.getSystemClassLoader().getResourceAsStream("data.json"));
        Assert.assertEquals(parser.getNumberOfProducts(), 22170); // there should be 22170 products in data.json
    }
}
