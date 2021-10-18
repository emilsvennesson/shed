package shedbolaget.model.drinks;

import shedbolaget.model.drinks.parser.IDrinkParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * model.{@link DrinkFilter} .{@link DrinkFilter}
 *
 * <p> {@link DrinkFilter} class compares drinks and singles out different drinks with different properties</p>
 *
 * @author Daniel Rygaard
 * @version 1.0.0
 */
public class DrinkFilter {



    

    /**
     * <p>Gets drinks based on a list of {@link Ingredient} set in the parameter</p>
     * @param ingredients, the ingredients that need to be in the drinks
     * @return a list of {@link Drink}s
     * @since 1.0.0
     */
    List<Drink> getFilteredDrinks(List<Ingredient> ingredients){
        Map<Drink, Integer> hitMatch = new HashMap<>();

        for (Drink drink :
                DrinkHolder.getInstance().getDrinks()) {
            hitMatch.put(drink, matchPoints(drink, ingredients));
        }
        


        return null;

    }

    private Integer matchPoints(Drink drink, List<Ingredient> ingredients) {
        Integer score = 0;

        for (Ingredient ingredient :
                ingredients) {


        }


        return score;
    }

}
