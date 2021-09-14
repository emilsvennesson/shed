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

}