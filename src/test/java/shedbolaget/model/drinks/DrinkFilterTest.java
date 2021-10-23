package shedbolaget.model.drinks;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class DrinkFilterTest {


    @Test
    public void testFilteredDrinks(){
        DrinkFilter filter = new DrinkFilter();

        Product prod = ProductModel.getInstance().getProducts().get(0);

        List<Ingredient> ings = new ArrayList<>();
        ings.add(new Ingredient(prod));
        List<Drink> drinks = filter.getFilteredDrinks(ings, 400);

        Assert.assertNotEquals(0, drinks.size() );

    }




}
