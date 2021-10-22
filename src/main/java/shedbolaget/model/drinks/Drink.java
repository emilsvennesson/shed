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


    public String getGlass() {
        return strGlass;
    }


    public String getName() {
        return strDrink;
    }

    public List<Ingredient> getAlcoIngredients() {
        return new ArrayList<>(alcIngredients);
    }

    public List<Ingredient> getNoIngredients() {
        return new ArrayList<>(noIngredients);
    }

    public String getInstructions() {
        return strInstructions;
    }




    public String getImageUrl() {
        return strImageSource;
    }

}
