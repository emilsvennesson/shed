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
public class Drink {
    //Identifiers
    private String idDrink;
    private String strDrink;

    //Instructions

    private String strGlass;
    private String strInstructions;

    //Image
    private String strImageSource;

    //Ingredients
    private List<Ingredient> alcingredients;
    private List<Ingredient> noingredients;


    public Drink(){}


    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public List<Ingredient> getAlcingredients() {
        return new ArrayList<>(alcingredients);

    }

    public List<Ingredient> getNoingredients() {
        return new ArrayList<>(noingredients);
    }
}
