package shedbolaget.model.drinks;

import me.xdrop.fuzzywuzzy.FuzzySearch;
import shedbolaget.model.drinks.parser.IDrinkParser;
import shedbolaget.model.products.Product;

import java.util.*;
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
        



        return new ArrayList<>(sortMap(hitMatch).keySet());

    }

    private Integer matchPoints(Drink drink, List<Ingredient> ingredients) {
        Integer score = 0;

        for (Ingredient ingredient :
                ingredients) {
            for (Ingredient ingredient1:
                 drink.getAlcoIngredients()) {
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.name);
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.prod.getCategoryLevel1().getName());
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.prod.getCategoryLevel2().getName());
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.prod.getCategoryLevel3().getName());
                score += FuzzySearch.ratio(ingredient1.getName(), ingredient.prod.getCustomCategoryTitle());
            }
        }
        if(drink.getAlcoIngredients().size() == 0) return 0;
        return score/drink.getAlcoIngredients().size();
    }

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
