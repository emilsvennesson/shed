package backend;

import org.junit.Assert;
import org.junit.Test;

public class TestDataHandler {

    @Test
    public void testProducts() {
        DataHandler dh = new DataHandler();
        Assert.assertEquals(22170, dh.getProducts().size());  // we know data should contain 22170 products
    }

    @Test
    public void testGetSize() {
        DataHandler dh = new DataHandler();
        Assert.assertEquals(22170, dh.getSize());
    }

    @Test
    public void testGetAlcoholFreeProducts() {
        DataHandler dh = new DataHandler();
        boolean wrongCategory = false;
        String category = "Alkoholfritt";
        for (Product product : dh.getCategory(category)) {
            if (!product.categoryLevel1.contains(category))
                wrongCategory = true;
        }
        Assert.assertEquals(false, wrongCategory);
    }

    @Test
    public void testSearchNameProducts() {
        DataHandler dh = new DataHandler();
        boolean wrongProduct = false;
        String filter = "Norrland";
        for (Product product : dh.getProducts(filter)) {
            if (!product.productNameBold.contains(filter))
                wrongProduct = true;
        }
        Assert.assertEquals(false, wrongProduct);
    }


}
