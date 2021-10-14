package shedbolaget.model.drinkfeatures;

import java.util.ArrayList;
import java.util.List;

/**
 * model.{@link DrinkFilter} .{@link DrinkFilter}
 *
 * <p> {@link DrinkFilter} class compares drinks and singles out different drinks with different properties</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public class DrinkFilter {


    List<Drink> drinks;

    DrinkFilter(IDrinkLoader loader){
        this.drinks = loader.load();
    }


    /**
     * <p>Gets drinks based on a list of {@link Ingredient} set in the parameter</p>
     * @param ingredients, the ingredients that need to be in the drinks
     * @return a list of {@link Drink}s
     */
    List<Drink> generateDrinks(List<Ingredient> ingredients){
        List<Drink> viableDrinks = new ArrayList<>();

        for (Drink d :
                drinks) {
            if(d.hasIngreadients(ingredients))
                viableDrinks.add(d);
        }

        return viableDrinks;
    }

    public List<Drink> getAllDrinks() {
        return drinks;
    }
}
