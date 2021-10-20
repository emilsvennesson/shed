package shedbolaget.model.products.pages;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.ProductModel;

public class TestPages {

    @Test
    public void testNumberOfPages() {
        Pages pages = new Pages(ProductModel.getInstance().getAllProducts());
        Assert.assertEquals(pages.getNumberOfPages(), (int) Math.ceil((double) pages.getTotalNumberOfProducts() / (double) pages.getProductsLimitPerPage()));
    }

    @Test
    public void testSpecifiedNumberOfPages() {
        Pages pages = new Pages(ProductModel.getInstance().getAllProducts(), 100);
        int expectedNumberOfPages = (int) Math.ceil((double) pages.getTotalNumberOfProducts() / (double) 100);
        Assert.assertEquals(expectedNumberOfPages, pages.getNumberOfPages());
    }

    @Test
    public void testPagesBoundaries() {
        Pages pages = new Pages(ProductModel.getInstance().getAllProducts(), 100);
        // expect empty list when we are out of bounds
        Assert.assertEquals(0, pages.getProductsFromPage(pages.getNumberOfPages() + 1).size());
        Assert.assertEquals(0, pages.getProductsFromPage(0).size());
        Assert.assertEquals(0, pages.getNumberOfProducts(-1));
        Assert.assertEquals(0, pages.getNumberOfProducts(pages.getNumberOfPages() + 1));
    }
}
