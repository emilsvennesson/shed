package shedbolaget.model.products;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestProductsHolder {

    @Test
    public void testGetAllProducts() {
        List<Product> products = ProductsHolder.getInstance().getAllProducts();
        Assert.assertEquals(products.size(), 22170);
    }
}
