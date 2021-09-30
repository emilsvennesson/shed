package shedbolaget.backend;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataHandler {

    @Test
    public void testProducts() {
        DataHandler dh = DataHandler.getInstance();
        Assert.assertEquals(22170, dh.getProducts().size());  // we know data should contain 22170 products
    }

    @Test
    public void testGetSize() {
        DataHandler dh = DataHandler.getInstance();
        Assert.assertEquals(22170, dh.getSize());
    }


    //TODO Fix tests for favorites
    @Test
    public void testAddFavorite() {


        DataHandler dh = DataHandler.getInstance();
        dh.clearFavorites();
        Product prod = getRandomUnequeProduct();

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 0);
        dh.addToFavorites(prod);

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 1);


    }

    @Test
    public void testRemoveFavorite() {

        DataHandler dh = DataHandler.getInstance();
        dh.clearFavorites();
        Product prod = getRandomUnequeProduct();

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 0);
        dh.addToFavorites(prod);

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 1);
        dh.removeFromFavorites(prod);

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 0);
    }

    @Test

    public void testGetFavorites() {

        DataHandler dh = DataHandler.getInstance();
        List<String> prods = new ArrayList<>();
        dh.clearFavorites();

        for (int i = 0; i < 10; i++) {
            Product prod = getRandomUnequeProduct();
            prods.add(prod.getProductId());
            dh.addToFavorites(prod);
        }

        List<Integer> favProds = dh.getProductIdsFromFavorites();

        for (int i = 0; i < prods.size(); i++) {
            Assert.assertEquals(prods.get(i), favProds.get(i).toString());
        }


    }


    public void testGetLevel1CategoryProducts() {
        DataHandler dh = DataHandler.getInstance();

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
        DataHandler dh = DataHandler.getInstance();

        boolean wrongCategory = false;
        String category = "Veteöl";
        dh.addCategoryLevel2Filter(category);
        for (Product product : dh.getFilteredProducts()) {
            if (!product.getCategoryLevel2().contains(category))
                wrongCategory = true;
        }
        Assert.assertEquals(false, wrongCategory);
    }


    private static Product getRandomUnequeProduct() {
        DataHandler handler = DataHandler.getInstance();
        Random rand = new Random();
        List<Product> usedProducts = new ArrayList<>();

        Product prod;
        do {
            prod = handler.getProducts().get(rand.nextInt(handler.getSize()));
        } while (usedProducts.contains(prod));

        usedProducts.add(prod);


        return prod;
    }


}
