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




    public String getName() {
        return strDrink;
    }

    public List<Ingredient> getAlcoIngredients() {
        return new ArrayList<>(alcingredients);
    }

    public List<Ingredient> getNoingredients(){
        return new ArrayList<>(noingredients);
    }

    public double getAPK(){
        double res = 0;
        if(alcingredients.size() == 0) return 0;
        for (Ingredient alcin :
                alcingredients) {
            res += alcin.getProd().getApk();

        }
        return res/alcingredients.size();
    }
    public int getVolume(){
        int res = 0;

        //TODO fix this
        for (Ingredient alcIn:
             alcingredients) {
           // res += alcIn.getProd().getVolume();

        }
        for (Ingredient noIn:
                noingredients) {
            //res += noIn.getProd().getVolume();

        }
        return res;

    }


}
