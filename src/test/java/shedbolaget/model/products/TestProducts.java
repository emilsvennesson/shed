package shedbolaget.model.products;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestProducts {

    @Test
    public void testGetAllProducts() {
        List<Product> products = Products.getInstance().getAllProducts();
        Assert.assertEquals(products.size(), 22170);
    }
}
