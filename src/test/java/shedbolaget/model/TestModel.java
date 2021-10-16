package shedbolaget.model;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestModel {

    /*
    private static Product getRandomUniqueProduct() {
        Model handler = Model.getInstance();
        Random rand = new Random();
        List<Product> usedProducts = new ArrayList<>();

        Product prod;
        prod = handler.getAllProducts().get(rand.nextInt(handler.getSize()));

        usedProducts.add(prod);

        return prod;
    }



    //TODO Fix tests for favorites
    @Test
    public void testAddFavorite() {
        Model dh = Model.getInstance();
        dh.clearFavorites();
        Product prod = getRandomUniqueProduct();

        Assert.assertEquals(dh.getFavoritesAsProducts().size(), 0);
        dh.addToFavorites(prod);

        Assert.assertEquals(dh.getFavoritesAsProducts().size(), 1);
    }

    @Test
    public void testRemoveFavorite() {
        Model dh = Model.getInstance();
        dh.clearFavorites();
        Product prod = getRandomUniqueProduct();

        Assert.assertEquals(dh.getFavoritesAsProducts().size(), 0);
        dh.addToFavorites(prod);

        Assert.assertEquals(dh.getFavoritesAsProducts().size(), 1);
        dh.removeFromFavorites(prod);

        Assert.assertEquals(dh.getFavoritesAsProducts().size(), 0);
    }

    @Test
    public void testGetFavorites() {
        Model dh = Model.getInstance();
        List<Product> prods = new ArrayList<>();
        dh.clearFavorites();

        List<Product> favProdsTest = dh.getFavoritesAsProducts();

        for (int i = 0; i < 10; i++) {
            Product prod = getRandomUniqueProduct();
            prods.add(prod);
            dh.addToFavorites(prod);
        }

        List<Product> favProds = dh.getFavoritesAsProducts();

        for (int i = 0; i < prods.size(); i++) {
            Assert.assertEquals(prods.get(i).getProductId(), favProds.get(i).getProductId());
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

     */

}
