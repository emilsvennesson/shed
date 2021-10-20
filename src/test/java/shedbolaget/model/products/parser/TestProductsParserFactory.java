package shedbolaget.model.products.parser;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.IProductsCollection;

public class TestProductsParserFactory {
    @Test
    public void testCreateJsonParserFromFileName() {
        IProductsCollection parser = ProductsParserFactory.createJSONParser("data.json");
        Assert.assertEquals(parser.getNumberOfProducts(), 22170); // there should be 22170 products in data.json
    }

    @Test
    public void testCreateJsonParserFromInputStream() {
        IProductsCollection parser = ProductsParserFactory.createJSONParser(ClassLoader.getSystemClassLoader().getResourceAsStream("data.json"));
        Assert.assertEquals(parser.getNumberOfProducts(), 22170);
    }
}
