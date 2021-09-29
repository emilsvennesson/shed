package shedbolaget.backend;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.backend.DataHandler;
import shedbolaget.backend.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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




    //TODO Fix tests for favorites
    @Test
    public void testAddFavorite() {

        DataHandler dh = new DataHandler();
        List<Product> prods = new ArrayList<>();

        for(int i = 0; i< 100 ; i++){
            Product prod = getRandomUnequeProduct();
            prods.add(prod);
            dh.addToFavorites(prod);
        }

        List<Integer> favProds = dh.getProductIdsFromFavorites();

       for(int i = 0; i< prods.size(); i++){
           Assert.assertEquals(prods.get(i).getProductId(), favProds.get(i).toString());
       }







    }

    @Test
    public void testRemoveFavorite() {

        Product product = new Product();
    }

    @Test

    public void testGetFavorites() {



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



    private static Product getRandomUnequeProduct(){
        DataHandler handler = new DataHandler();
        Random rand = new Random() ;
        List<Product> usedProducts = new ArrayList<>();

        Product prod;
        do {
            prod= handler.getProducts().get(rand.nextInt(handler.getSize()));
        }while (usedProducts.contains(prod));

        usedProducts.add(prod);


        return prod;
    }


}
