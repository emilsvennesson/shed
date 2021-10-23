package shedbolaget.model.favorites;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFavorites {


    public void testGetInstance(){
        Favorites fav = Favorites.getInstance();
        Assert.assertNotNull(fav);

        Favorites fav2 = Favorites.getInstance();

        Assert.assertEquals(fav, fav2);
    }


    public void TestgetFavoritesProduct(){
        List<Product> favoriteProductList = Favorites.getInstance().getFavoriteProducts();
        Assert.assertNotNull(favoriteProductList);


    }
    @Test
    public void TestAddToFavorites(){
        Random rand = new Random(1);
        List<Product> products = new ArrayList<>();

        ProductModel model = ProductModel.getInstance();
        int max = model.getProducts().size();
        for (int i = 0; i < rand.nextInt(20); i++) {
            Product prod = model.getProducts().get(rand.nextInt(max - 1));
            Favorites.getInstance().addToFavorites(prod);
            products.add(prod);
        }

        for (Product prod :
                Favorites.getInstance().getFavoriteProducts()) {
            Assert.assertTrue(products.contains(prod));
        }





    }

    @Test
    public void TestRemoveFromFavorites(){
        Favorites.getInstance().clearFavorites();
        Assert.assertEquals(0,Favorites.getInstance().getFavoriteProducts().size());
        Product product = ProductModel.getInstance().getProducts().get(0);

        Favorites.getInstance().addToFavorites(product);
        Assert.assertEquals(1,Favorites.getInstance().getFavoriteProducts().size());

        Favorites.getInstance().removeFromFavorites(product);
        Assert.assertEquals(0, Favorites.getInstance().getFavoriteProducts().size());




    }

    @Test
    public void TestIsFavorite(){

        Favorites.getInstance().clearFavorites();
        Product product = ProductModel.getInstance().getProducts().get(0);

        Favorites.getInstance().addToFavorites(product);

        Favorites.getInstance().isFavorite(product);
    }







}
