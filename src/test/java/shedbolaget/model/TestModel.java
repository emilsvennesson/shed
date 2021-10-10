package shedbolaget.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestModel {

    private static Product getRandomUniqueProduct() {
        Model handler = Model.getInstance();
        Random rand = new Random();
        List<Product> usedProducts = new ArrayList<>();

        Product prod;
        prod = handler.getAllProducts().get(rand.nextInt(handler.getSize()));

        usedProducts.add(prod);

        return prod;
    }

    @Test
    public void testProducts() {
        Model dh = Model.getInstance();
        Assert.assertEquals(22170, dh.getAllProducts().size());  // we know data should contain 22170 products
    }

    @Test
    public void testGetSize() {
        Model dh = Model.getInstance();
        Assert.assertEquals(22170, dh.getSize());
    }

    //TODO Fix tests for favorites
    @Test
    public void testAddFavorite() {
        Model dh = Model.getInstance();
        dh.clearFavorites();
        Product prod = getRandomUniqueProduct();

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 0);
        dh.addToFavorites(prod);

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 1);
    }

    @Test
    public void testRemoveFavorite() {
        Model dh = Model.getInstance();
        dh.clearFavorites();
        Product prod = getRandomUniqueProduct();

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 0);
        dh.addToFavorites(prod);

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 1);
        dh.removeFromFavorites(prod);

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 0);
    }

    @Test
    public void testGetFavorites() {
        Model dh = Model.getInstance();
        List<String> prods = new ArrayList<>();
        dh.clearFavorites();

        for (int i = 0; i < 10; i++) {
            Product prod = getRandomUniqueProduct();
            prods.add(prod.getProductId());
            dh.addToFavorites(prod);
        }

        List<Integer> favProds = dh.getProductIdsFromFavorites();
        for (int i = 0; i < prods.size(); i++) {
            Assert.assertEquals(prods.get(i), favProds.get(i).toString());
        }
    }

    @Test
    public void testGetProductsById() {
        Model model = Model.getInstance();
        Product testProduct = model.getAllProducts().get(0);
        int id = Integer.parseInt(testProduct.getProductId());
        Assert.assertEquals(Integer.parseInt(model.getProducts(id).get(0).getProductId()), id);
    }

    @Test
    public void testGetNewProducts() {
        Model model = Model.getInstance();
        List<Product> emptyProducts = model.getNewProducts(0);
        Assert.assertTrue(emptyProducts.isEmpty());
        Random rng = new Random(1);
        for (int i = 0; i < 100; i++) {
            int expected = rng.nextInt(5000);
            List<Product> ps = model.getNewProducts(expected);
            Assert.assertEquals(ps.size(), expected);
        }
        // try getting 0 or -10 products
    }

}
