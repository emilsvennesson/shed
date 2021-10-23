package shedbolaget.model.drinks.parser;

import shedbolaget.model.drinks.Drink;

import java.util.List;

/**
 * model.drinkfeatures.IDrinkLoader
 *
 * <p> Interface represanting a data reader that is responsible for reading in {@link Drink}s
 *      This Interface will be used as a common interface for classes reading {@link Drink} data from different data storages
 *      The attributes that will be read in are
 *      </p>
 *      <ul>
 *  *       <li>idDrink             String</li>
 *          <li>strDrink            String</li>
 *          <li>strGlass            String</li>
 *          <li>strInstructions     String</li>
 *          <li>strImageSource      String</li>
 *  *       <li>AlcoIngredients     List<Ingredient></li>
 *  *       <li>NoIngredient        List<Ingredient></li>
 *  *   </ul>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public interface IDrinkParser {


    /**
     * Parses information from a set data storage. This method will then instantiate
     * {@link Drink} objects and set that information into them.
     *
     * @return
     */
    List<Drink> load();



}
