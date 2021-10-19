package shedbolaget.model.drinks;

import shedbolaget.model.products.Product;
import shedbolaget.model.drinks.parser.DrinkJsonFileParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * model.drinkfeatures.DrinkModel
 *
 * <p> Acts as a model for all {@link Drink} based features</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public enum DrinkModel {
    ;



    final static private List<Ingredient> ingredients = new ArrayList<>();

    final static DrinkFilter dFilter = new DrinkFilter();

    /**
     * Gets all the {@link Drink}s with the set {@link Ingredient}s
     *
     * @return      a list of {@link Drink}
     */
    public static List<Drink> loadDrinks(){


        return dFilter.getFilteredDrinks(ingredients);
    }

    /**
     * Gets all the {@link Drink}s that are available
     *
     * @return      a list of {@link Drink}
     */
    public static List<Drink> loadAllDrinks(){
        return DrinkHolder.getInstance().getDrinks();
    }


    /**
     * Adds an {@link Ingredient} to the drink model, this ingredient will be used when getting the drinks
     *
     * @param ingredient    {@link Ingredient} that will be added
     */
    public static void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    /**
     * Turns the product into an ingredient an the adds it with {@link #addIngredient(Ingredient)}
     *
     * @param product   the product that will be added
     */
    public static void addIngredient(Product product){
        Ingredient ing = new Ingredient(product);
        addIngredient(ing);
    }


    /**
     * Removes a {@link Ingredient} from the ingredients list
     * @param product the product that will be removed
     */
    public static void removeIngredient(Product product){
        List<Ingredient> in = ingredients.stream().filter(x -> x.prod.getProductNameBold().equals(product.getProductNameBold())).collect(Collectors.toList());
        ingredients.removeAll(in);
    }



    public static void clear(){
        ingredients.clear();
    }

}
