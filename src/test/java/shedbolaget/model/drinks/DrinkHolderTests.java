package shedbolaget.model.drinks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DrinkHolderTests {


    @Test
    public void SingletonInstanceTest(){
        DrinkHolder holder = DrinkHolder.getInstance();
        Assert.assertNotNull(holder);

    }

    @Test
    public void getDrinksNotNullTest(){
        List<Drink> drinks = DrinkHolder.getInstance().getDrinks();

        Assert.assertNotNull(drinks);

        for (Drink drink :
                drinks) {
            Assert.assertNotNull(drink);
        }

    }

    @Test
    public void getDrinksConsistentTest(){
        List<Drink> drinkList1 = DrinkHolder.getInstance().getDrinks();
        List<Drink> drinkList2 = DrinkHolder.getInstance().getDrinks();

        Assert.assertEquals(drinkList1, drinkList2);

    }

}
