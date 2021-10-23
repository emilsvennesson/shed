package shedbolaget.model.products.customproduct;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

/**
 * @author Pouya Shirin
 */
public class TestCustomProduct {
    @Test
    public void testCreateAndRemoveCustomProduct()
    {
        Product product = CustomProduct.createProduct("Test", "Test", "Test",
                50, 50, 50, "Test", "test");
        Assert.assertEquals(1,
                ProductModel.getInstance().getProductsById(Integer.parseInt(product.getProductId())).size());
        CustomProduct.removeCustomProduct(product);
        Assert.assertEquals(0,
                ProductModel.getInstance().getProductsById(Integer.parseInt(product.getProductId())).size());
    }
}
