package shedbolaget.model.drinks;

import me.xdrop.fuzzywuzzy.FuzzySearch;

import java.util.*;
import java.util.stream.Collectors;

/**
 * model.{@link DrinkFilter} .{@link DrinkFilter}
 *
 * <p> {@link DrinkFilter} class compares drinks and singles out different drinks with different properties</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public class DrinkFilter {

    /**
     * <p>Gets drinks based on a list of {@link Ingredient} set in the parameter</p>
     * @param ingredients, the ingredients that need to be in the drinks
     * @param hitRatio, how good of a match the ingredients need to be in order for the drink to be included
     * @return a list of {@link Drink}s
     * @since 1.0.0
     */
    List<Drink> getFilteredDrinks(List<Ingredient> ingredients, int hitRatio){

        Map<Drink, Integer> hitMatch = new HashMap<>();

        for (Drink drink :
                DrinkHolder.getInstance().getDrinks()) {

            int points =  matchPoints(drink, ingredients);
            if(points < hitRatio)
                continue;
            hitMatch.put(drink, points);

        }
        return new ArrayList<>(sortMap(hitMatch).keySet());
    }

    /**
     * Calulate how great of a match the {@link Ingredient}s are
     * @param drink
     * @param ingredients
     * @return
     */
    private Integer matchPoints(Drink drink, List<Ingredient> ingredients) {
        Integer score = 0;

        for (Ingredient ingredient :
                ingredients) {
            for (Ingredient ingredient1:
                 drink.getAlcingredients()) {
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.getName() )*5;
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.getProd().getCategoryLevel1().getName())*1;
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.getProd().getCategoryLevel2().getName())*2;
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.getProd().getCategoryLevel3().getName())*3;
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.getProd().getCustomCategoryTitle())*1;
            }
        }
        if(drink.getAlcingredients().size() == 0 || ingredients.size() == 0) return 0;
        score =score/(drink.getAlcingredients().size()*ingredients.size());

        return score;
    }

    /**
     * Sorts the map from highest to lowest
     * @param pMap
     * @return The same map but sorted
     */
    private static Map<Drink, Integer> sortMap(Map<Drink, Integer> pMap) {
        return pMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                ));
    }
}
