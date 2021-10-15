package shedbolaget.model.products;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.pages.Pages;

public class TestPages {

    @Test
    public void testNumberOfPages() {
        Pages pages = new Pages(ProductsHolder.getInstance().getAllProducts());
        Assert.assertEquals(pages.getNumberOfPages(), (int) Math.ceil((double) pages.getTotalNumberOfProducts() / (double) pages.getProductsLimitPerPage()));
    }
}
