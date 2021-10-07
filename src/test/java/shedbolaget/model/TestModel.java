package shedbolaget.model;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestModel {

    @Test
    public void testProducts() {
        Model dh = Model.getInstance();
        Assert.assertEquals(22170, dh.getProducts().size());  // we know data should contain 22170 products
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
        Product prod = getRandomUnequeProduct();

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 0);
        dh.addToFavorites(prod);

        Assert.assertEquals(dh.getProductIdsFromFavorites().size(), 1);
    }

    @Test
    public void testRemoveFavorite() {
        Model dh = Model.getInstance();
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
        Model dh = Model.getInstance();
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

    @Test
    public void testGetLevel1CategoryProducts() {
        Model dh = Model.getInstance();
        dh.clearAllFilters();
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
        Model dh = Model.getInstance();
        dh.clearAllFilters();
        boolean wrongCategory = false;
        String category = "Veteöl";
        dh.addCategoryLevel2Filter(category);
        for (Product product : dh.getFilteredProducts()) {
            if (!product.getCategoryLevel2().contains(category))
                wrongCategory = true;
        }
        Assert.assertEquals(false, wrongCategory);
    }

    @Test
    public void testGetProductsById(){
        Model model = Model.getInstance();
        Product testProduct = model.getProducts().get(0);
        int id = Integer.parseInt(testProduct.getProductId());
        Assert.assertEquals(true, Integer.parseInt(model.getProducts(id).get(0).getProductId()) == id);
    }

    @Test
    public void testAddAndRemoveCategoryLevel1(){
        Model model = Model.getInstance();
        model.setCategoryLevel1Filter("beer");
        Assert.assertEquals(true, model.getActiveLevel1Category() == "beer");
        model.clearCategoryLevel1Filter();
        Assert.assertEquals(true, model.getActiveLevel1Category() == "");
    }

    @Test
    public void testAddAndRemoveCategoryLevel2(){
        Model model = Model.getInstance();
        model.clearAllFilters();
        model.addCategoryLevel2Filter("test1");
        model.addCategoryLevel2Filter("test2");
        Assert.assertEquals(true, model.getActiveLevel2Categories().get(0) == "test1");
        Assert.assertEquals(true, model.getActiveLevel2Categories().get(1) == "test2");
        model.clearCategoryLevel2Filters();
        Assert.assertEquals(true, model.getActiveLevel2Categories().size() == 0);
    }

    private static Product getRandomUnequeProduct() {
        Model handler = Model.getInstance();
        Random rand = new Random();
        List<Product> usedProducts = new ArrayList<>();

        Product prod;
        do {
            prod = handler.getProducts().get(rand.nextInt(handler.getSize()));
        } while (usedProducts.contains(prod));

        usedProducts.add(prod);


        return prod;
    }

    @Test
    public void testGetNewProducts() {
        Model model = Model.getInstance();
        ArrayList<Product> products = model.getNewProducts(10);
        Assert.assertEquals(products.size(), 10);
    }

}