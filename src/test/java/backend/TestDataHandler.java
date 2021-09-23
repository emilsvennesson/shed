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

    public void testGetFavorites() {
        Product product = new Product();


    }


    //TODO Fix tests for favorites
    @Test
    public void testAddFavorite() {


        Product product = new Product();


    }

    @Test
    public void testRemoveFavorite() {

        Product product = new Product();
    }


    public void testGetLevel1CategoryProducts() {
        DataHandler dh = new DataHandler();

        boolean wrongCategory = false;
        String category = "Öl";
        dh.setCategoryLevel1Filter(category);
        for (Product product : dh.getFilteredProducts()) {
            if (!product.getCategoryLevel1().contains(category))
                wrongCategory = true;
        }
        Assert.assertEquals(false, wrongCategory);
    }


    @Test
    public void testGetLevel2CategoryProducts() {
        DataHandler dh = new DataHandler();

        boolean wrongCategory = false;
        String category = "Veteöl";
        dh.addCategoryLevel2Filter(category);
        for (Product product : dh.getFilteredProducts()) {
            if (!product.getCategoryLevel2().contains(category))
                wrongCategory = true;
        }
        Assert.assertEquals(false, wrongCategory);
    }


}
