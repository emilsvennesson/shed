package shedbolaget.model.drinkfeatures;

import shedbolaget.model.Product;
import shedbolaget.model.favorites.SavableProductIdList;

import java.util.ArrayList;
import java.util.List;

/**
 * model.drinkfeatures.DrinkModel
 *
 * <p> Acts as a model for all {@link Drink} based features</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public class DrinkModel {


    List<Ingredient> ingredients = new ArrayList<>();


    /**
     * Gets all the {@link Drink}s with the set {@link Ingredient}s
     *
     * @return      a list of {@link Drink}
     */
    public List<Drink> loadDrinks(){


        return null;
    }

    /**
     * Gets all the {@link Drink}s that are available
     *
     * @return      a list of {@link Drink}
     */
    public List<Drink> loadAllDrinks(){
        return null;
    }


    /**
     * Adds an {@link Ingredient} to the drink model, this ingredient will be used when getting the drinks
     *
     * @param ingredient    {@link Ingredient} that will be added
     */
    public void addIngredient(Ingredient ingredient){

    }

    /**
     * Turns the product into an ingredient an the adds it with {@link #addIngredient(Ingredient)}
     *
     * @param product   the product that will be added
     */
    public void addIngredient(Product product){
        Ingredient ing = new Ingredient(product);
        this.addIngredient(ing);


    }

}
