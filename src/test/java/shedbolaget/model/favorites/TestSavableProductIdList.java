package shedbolaget.model.favorites;


import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TestSavableProductIdList {


    @Test
    public void testAddProductViaProductObject() {
        SavableProductIdList list = new SavableProductIdList("Favorites");
        Assert.assertEquals(0, list.getSize());

        Product prod = getRandomUniqueProduct();

        list.addProductId(prod);


        Assert.assertEquals(1, list.getSize());

        Product prod2 = getRandomUniqueProduct();

        list.addProductId(prod2);

        Assert.assertEquals(2, list.getSize());


    }

    @Test
    public void testAddProductWithProductId() {
        Product prod = getRandomUniqueProduct();

        SavableProductIdList list = new SavableProductIdList("Test");

        Assert.assertEquals(0, list.getSize());

        list.addProductId(Integer.parseInt(prod.getProductId()));

        Assert.assertEquals(1, list.getSize());


    }

    @Test
    public void addProductWithSameId() {

        SavableProductIdList list = new SavableProductIdList("Favorites");

        Product prod = getRandomUniqueProduct();

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
        Product prod = getRandomUniqueProduct();


        list.addProductId(prod);

        Assert.assertEquals(1, list.getSize());

        list.removeProductId(prod);

        Assert.assertEquals(0, list.getSize());

    }


    @Test
    public void testRemoveProductViaProductId() {


        SavableProductIdList list = new SavableProductIdList("test");

        Product prod = getRandomUniqueProduct();
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

        Product prod = getRandomUniqueProduct();

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


    @Test
    public void testGetProducts(){

        SavableProductIdList list = new SavableProductIdList("TestLista");
        List<Product> prodList = new ArrayList<>();

        Random rand = new Random(1);
        for (int i = 0; i< rand.nextInt(20); i++){
            Product prod = getRandomUniqueProduct();
            list.addProductId(prod);
            prodList.add(prod);
        }


        List<Product> prodList2 = list.getProducts();

        Assert.assertEquals(prodList.size(), prodList2.size());
        for (Product product :
                prodList) {
            Assert.assertTrue(prodList2.contains(product));

        }




    }

    static Random rand = new Random(1);
    static List<Product> usedProducts = new ArrayList<>();

    private static Product getRandomUniqueProduct() {


        Product prod;
        do {
            prod = ProductModel.getInstance().getProducts().get(rand.nextInt(ProductModel.getInstance().getProducts().size()));
        } while (usedProducts.contains(prod));

        usedProducts.add(prod);


        return prod;
    }





}
