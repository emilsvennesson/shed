package shedbolaget.model.products.pages;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.ProductList;

public class TestPages {

    @Test
    public void testNumberOfPages() {
        Pages pages = new Pages(ProductList.getInstance().getAllProducts());
        Assert.assertEquals(pages.getNumberOfPages(), (int) Math.ceil((double) pages.getTotalNumberOfProducts() / (double) pages.getProductsLimitPerPage()));
    }
}
