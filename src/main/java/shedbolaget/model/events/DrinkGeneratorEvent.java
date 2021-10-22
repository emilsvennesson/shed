package shedbolaget.model.events;

import shedbolaget.model.drinks.Ingredient;

import java.util.ArrayList;
import java.util.List;

//TODO add Javadoc

/**
 * @author Daniel Rygaard
 */
public class DrinkGeneratorEvent {

    private final List<Ingredient> ingredients;


    public DrinkGeneratorEvent(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }


    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }
}
