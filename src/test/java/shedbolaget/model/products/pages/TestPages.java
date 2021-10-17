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
}
