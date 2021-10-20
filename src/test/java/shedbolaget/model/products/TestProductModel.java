package shedbolaget.model.products;

import org.junit.Assert;
import org.junit.Test;

public class TestProductModel {
    @Test
    public void testGetProductsById() {
        Assert.assertEquals(ProductModel.getInstance().getProductsById(24583611).get(0).getProductId(), "24583611");
    }

    @Test
    public void testGetNumberOfProducts() {
        int expectedNumberOfProducts = ProductList.getInstance().getNumberOfProducts() + CustomProductList.getInstance().getNumberOfProducts();
        Assert.assertEquals(expectedNumberOfProducts, ProductModel.getInstance().getNumberOfProducts());
    }
}
