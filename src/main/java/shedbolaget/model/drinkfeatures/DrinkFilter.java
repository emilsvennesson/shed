package shedbolaget.model.drinkfeatures;

import java.util.ArrayList;
import java.util.List;
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


    private List<Drink> drinks;

    DrinkFilter(IDrinkLoader loader){
        this.drinks = loader.load();
    }


    /**
     * <p>Gets drinks based on a list of {@link Ingredient} set in the parameter</p>
     * @param ingredients, the ingredients that need to be in the drinks
     * @return a list of {@link Drink}s
     * @since 1.0.0
     */
    List<Drink> getFilteredDrinks(List<Ingredient> ingredients){

        return drinks.stream()
                .filter(x-> x.hasIngreadients(ingredients)).collect(Collectors.toList());

    }

    public List<Drink> getAllDrinks() {
        return drinks;
    }
}
