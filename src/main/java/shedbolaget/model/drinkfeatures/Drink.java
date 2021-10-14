package shedbolaget.model.drinkfeatures;

import shedbolaget.model.favorites.SavableProductIdList;

import java.util.List;

/**
 * model.drinkfeatures.Drink
 *
 * <p> Used as a utility class to represent the relevant information for a real world drink</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public class Drink {

    String name;
    List<Ingredient> ingredients;
    List<String> steps;


    /**
     * Checks if the drink has a {@link Ingredient}
     * @param ingredient, the ingredient that is checked
     * @return a boolean that is true only if this drink has the ingredient
     */
    boolean hasIngreadient(Ingredient ingredient){

        for (Ingredient ing :
                ingredients) {
            if(ing.equals(ingredient))
                return true;
            
        }

        return false;
    }

    /**
     * Checks if this drink has {@link Ingredient}s, this only returns true if all the set {@link Ingredient}s are in this drink
     * @param ings, a list of {@link Ingredient}s that are checked
     * @return a boolean, true if all the ingredients are in this drink
     */
    boolean hasIngreadients(List<Ingredient> ings){

        for (Ingredient ing :
                ings) {
            if (!this.hasIngreadient(ing))
                return false;
        }
        return true;
    }


    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }
}
