package backend.favorites;

import backend.DataHandler;
import backend.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class TestProductListIO {



    SavableProductIdList list = new SavableProductIdList("Favorites");
    List<SavableProductIdList> listofLists = new ArrayList<SavableProductIdList>();
    IProductListIO io = new ProductListFileIO();

    @Before
    public void testOfFileWriter() {


        for (int i = 0; i < 10; i++) {
            Product prod = getRandomUnequeProduct();
            list.addProductId(prod);
        }

        io.save(list);

        io.close();


    }


    @Test
    public void testOfFileReader() throws IOException {

        listofLists = io.loadAll();


        io.close();

        SavableProductIdList list2 = listofLists.get(0);

        Assert.assertEquals(list2.getName(), list.getName());
        Assert.assertEquals(list.getSize(), list2.getSize());

        for (int i = 0; i < list.getSize(); i++) {
            Assert.assertEquals(list.getProductIds().get(i), list2.getProductIds().get(i));
        }
    }



    static DataHandler handler = new DataHandler();
    static Random rand = new Random() ;
    static List<Product> usedProducts = new ArrayList<>();
    private static Product getRandomUnequeProduct(){


        Product prod;
        do {
            prod= handler.getProducts().get(rand.nextInt(handler.getSize()));
        }while (usedProducts.contains(prod));

        usedProducts.add(prod);


        return prod;
    }


}
