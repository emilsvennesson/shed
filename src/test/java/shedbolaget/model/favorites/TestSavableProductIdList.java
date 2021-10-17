package shedbolaget.model.favorites;


import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TestSavableProductIdList {


    @Test
    public void testAddProductViaProductObject() {
        SavableProductIdList list = new SavableProductIdList("Favorites");
        Assert.assertEquals(0, list.getSize());

        Product prod = getRandomUnequeProduct();

        list.addProductId(prod);


        Assert.assertEquals(1, list.getSize());

        Product prod2 = getRandomUnequeProduct();

        list.addProductId(prod2);

        Assert.assertEquals(2, list.getSize());


    }

    @Test
    public void testAddProductWithProductId() {
        Product prod = getRandomUnequeProduct();

        SavableProductIdList list = new SavableProductIdList("Test");

        Assert.assertEquals(0, list.getSize());

        list.addProductId(Integer.parseInt(prod.getProductId()));

        Assert.assertEquals(1, list.getSize());


    }

    @Test
    public void addProductWithSameId() {

        SavableProductIdList list = new SavableProductIdList("Favorites");

        Product prod = getRandomUnequeProduct();

        list.addProductId(prod);

        Assert.assertEquals(list.getProductIds().get(0).toString(), prod.getProductId());


        Assert.assertEquals(1, list.getSize());

        list.addProductId(prod);

        Assert.assertEquals(1, list.getSize());

        list.addProductId(Integer.parseInt(prod.getProductId()));

        Assert.assertEquals(1, list.getSize());

    }


    @Test
    public void testRemoveProductViaProductObject() {
        SavableProductIdList list = new SavableProductIdList("Favorites");
        Assert.assertEquals(0, list.getSize());
        Product prod = getRandomUnequeProduct();


        list.addProductId(prod);

        Assert.assertEquals(1, list.getSize());

        list.removeProductId(prod);

        Assert.assertEquals(0, list.getSize());

    }


    @Test
    public void testRemoveProductViaProductId() {


        SavableProductIdList list = new SavableProductIdList("test");

        Product prod = getRandomUnequeProduct();
        int id = Integer.parseInt(prod.getProductId());

        Assert.assertEquals(0, list.getSize());

        list.addProductId(prod);

        Assert.assertEquals(1, list.getSize());

        list.removeProductId(id);

        Assert.assertEquals(0, list.getSize());

    }

    @Test
    public void testGetSize() {

        SavableProductIdList list = new SavableProductIdList("Favorites");

        Assert.assertEquals(list.getSize(), list.getProductIds().size());

        Product prod = getRandomUnequeProduct();

        Assert.assertEquals(list.getSize(), list.getProductIds().size());


        list.removeProductId(prod);

        Assert.assertEquals(list.getSize(), list.getProductIds().size());

    }

    @Test
    public void testGetName() {
        String name = "Test";

        SavableProductIdList list = new SavableProductIdList(name);

        Assert.assertEquals(name, list.getName());


    }

    static Random rand = new Random();
    static List<Product> usedProducts = new ArrayList<>();

    private static Product getRandomUnequeProduct() {


        Product prod;
        do {
            prod = ProductList.getInstance().getAllProducts().get(rand.nextInt(ProductList.getInstance().getAllProducts().size()));
        } while (usedProducts.contains(prod));

        usedProducts.add(prod);


        return prod;
    }


}
