package shedbolaget.model.drinks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shedbolaget.model.drinks.parser.DrinkJsonFileParser;
import shedbolaget.model.drinks.parser.IDrinkParser;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

import java.util.List;
import java.util.Random;

public class TestDrinkModel {








    @Test
    public void testLoadDrinks(){


    }

    int amountOfDrinks = 0;
    @Before
    public void getAllDrinksFromParser(){
        IDrinkParser parser = new DrinkJsonFileParser();
        List<Drink> parsedDrinks = parser.load();

        amountOfDrinks = parsedDrinks.size();
    }
    @Test
    public void loadAllDrinks(){

        List<Drink> drinks = DrinkModel.loadAllDrinks();

        Assert.assertEquals(drinks.size(), amountOfDrinks);

    }

    @Test
    public void testAddIngredient(){
        int ingredients = DrinkModel.getIngredients().size();
        DrinkModel.addIngredient(ProductModel.getInstance().getProducts().get(1));
        ingredients++;

        Assert.assertEquals(ingredients, DrinkModel.getIngredients().size());

    }

    @Test
    public void testAddIngredients(){
        Random rand = new Random(1);
        int ingredients = DrinkModel.getIngredients().size();
        for (int i = 0; i<rand.nextInt(ProductModel.getInstance().getProducts().size()); i++ ){
            DrinkModel.addIngredient(ProductModel.getInstance().getProducts().get(i));
            ingredients++;
        }


        Assert.assertEquals(ingredients, DrinkModel.getIngredients().size());
    }


    @Test
    public void testRemoveIngredients(){
        Random rand = new Random(1);
        int notADrinkAddedIndex = 0;
        for (int i = 0; i<rand.nextInt(ProductModel.getInstance().getProducts().size()); i++ ){
            DrinkModel.addIngredient(ProductModel.getInstance().getProducts().get(i));
            notADrinkAddedIndex = i;
        }


        int ingredients = DrinkModel.getIngredients().size();
        DrinkModel.removeIngredient(new Ingredient(ProductModel.getInstance().getProducts().get(notADrinkAddedIndex+5)));

        Assert.assertEquals(ingredients, DrinkModel.getIngredients().size());


        DrinkModel.removeIngredient(new Ingredient(ProductModel.getInstance().getProducts().get(rand.nextInt(DrinkModel.getIngredients().size()-1))));

        Assert.assertEquals(ingredients, DrinkModel.getIngredients().size());


    }


    @Test
    public void testClearIngredients(){

        Random rand = new Random(1);

        for (int i = 0; i<rand.nextInt(ProductModel.getInstance().getProducts().size()); i++ ){
            DrinkModel.addIngredient(ProductModel.getInstance().getProducts().get(i));
        }

        DrinkModel.clearIngredients();

        Assert.assertEquals(DrinkModel.getIngredients().size(), 0);



    }

    @Test
    public void testLeadFilteredDrinks(){
        DrinkModel.clearIngredients();

        DrinkModel.addIngredient(new Ingredient(ProductModel.getInstance().getProducts().get(0)));
        List<Drink> drinks = DrinkModel.loadFilteredDrinks(400);
        Assert.assertNotNull(drinks);
        for (Drink drink :
                drinks) {
            Assert.assertNotNull(drink);
        }

    }


}
