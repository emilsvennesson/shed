package shedbolaget.model.drinks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * model.drinkfeatures.Drink
 *
 * <p> Used as a utility class to represent the relevant information for a real world drink</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink {
    //Identifiers
    public String idDrink;
    public String strDrink;

    //Ingredients


    //Instructions

    public String strGlass;
    public String strInstructions;

    //Image
    public String strImageSource;

    public List<Ingredient> alcingredients = new ArrayList<>();
    public List<Ingredient> noingredients = new ArrayList<>();



    /**
     * Checks if the drink has a {@link Ingredient}
     * @param ingredient, the ingredient that is checked
     * @return a boolean that is true only if this drink has the ingredient
     * @since 1.0.0
     */
    boolean hasIngreadient(Ingredient ingredient){




        for (Ingredient ing :
                alcingredients) {
            if(ing.getName() == null) return false;
            if(ing.getName().contains(ingredient.getName()))
                return true;
            if(ing.getName().contains(ingredient.getCat3()))
                return true;
            if(ing.getName().contains(ingredient.getAltCat()))
                return true;

        }

        return false;
    }



    /**
     * Checks if this drink has {@link Ingredient}s, this only returns true if all the set {@link Ingredient}s are in this drink
     * @param ings, a list of {@link Ingredient}s that are checked
     * @return a boolean, true if all the ingredients are in this drink
     * @since 1.0.0
     */
    boolean hasIngreadients(List<Ingredient> ings){



        for (Ingredient ing :
                ings) {
            if(this.hasIngreadient(ing)){
                return true;
            }
        }
        return false;
    }


    public String getName() {
        return strDrink;
    }

    public List<Ingredient> getIngredients() {


        List<Ingredient> copy = new ArrayList<>();
        copy.addAll(alcingredients);

        return copy;
    }

    public List<String> getSteps() {
        List<String> copy = new ArrayList<>();


        return copy;
    }
}
