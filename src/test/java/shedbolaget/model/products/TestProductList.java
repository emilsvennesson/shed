package shedbolaget.model.products;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestProductList {

    @Test
    public void testGetAllProducts() {
        List<Product> products = ProductList.getInstance().getProducts();
        Assert.assertEquals(products.size(), 22170);
    }
}
