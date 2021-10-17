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

    /*"idDrink":"11007",
    "strDrink":"Margarita",
    "strDrinkAlternate":null,
    "strTags":"IBA,
    "strVideo":null,
    "strCategory":"Ordinary Drink",
    "strIBA":"Contemporary Classics",
    "strAlcoholic":"Alcoholic",
    "strGlass":"Cocktail glass",
    "strInstructions":"Rub the rim of the glass with the lime slice to make the salt stick to it.
                        Take care to moisten only the outer rim and sprinkle the salt on it.
                        The salt should present to the lips of the imbiber and never mix into the cocktail.
                        Shake the other ingredients with ice, then carefully pour into the glass.",
   "strDrinkThumb":"https:\/\/www.thecocktaildb.com\/images\/media\/drink\/5noda61589575158.jpg",
   "strIngredient1":"Tequila",
   "strIngredient2":"Triple sec",
   "strIngredient3":"Lime juice",
   "strIngredient4":"Salt",
   "strIngredient5":null,
   "strIngredient6":null,
   "strIngredient7":null,
   "strIngredient8":null,
   "strIngredient9":null,
   "strIngredient10":null,
   "strIngredient11":null,
   "strIngredient12":null,
   "strIngredient13":null,
   "strIngredient14":null,
   "strIngredient15":null,
   "strMeasure1":"1 1\/2 oz ",
   "strMeasure2":"1\/2 oz ",
   "strMeasure3":"1 oz ",
   "strMeasure4":null,
   "strMeasure5":null,
   "strMeasure6":null,
   "strMeasure7":null,
   "strMeasure8":null,
   "strMeasure9":null,
   "strMeasure10":null,
   "strMeasure11":null,
   "strMeasure12":null,
   "strMeasure13":null,
   "strMeasure14":null,
   "strMeasure15":null,
    */
    //Identifiers
    public String idDrink;
    public String strDrink;

    //Ingredients
    public String strIngredient1;
    public String strIngredient2;
    public String strIngredient3;
    public String strIngredient4;
    public String strIngredient5;
    public String strIngredient6;
    public String strIngredient7;
    public String strIngredient8;
    public String strIngredient9;
    public String strIngredient10;
    public String strIngredient11;
    public String strIngredient12;
    public String strIngredient13;
    public String strIngredient14;
    public String strIngredient15;

    //Measures
    public String strMeasure1;
    public String strMeasure2;
    public String strMeasure3;
    public String strMeasure4;
    public String strMeasure5;
    public String strMeasure6;
    public String strMeasure7;
    public String strMeasure8;
    public String strMeasure9;
    public String strMeasure10;
    public String strMeasure11;
    public String strMeasure12;
    public String strMeasure13;
    public String strMeasure14;
    public String strMeasure15;

    //Instructions

    public String strGlass;
    public String strInstructions;

    //Image
    public String strImageSource;

    private List<Ingredient> ingredients = new ArrayList<>();
    private List<String> measures = new ArrayList<>();
    private List<String> steps;



    /**
     * Checks if the drink has a {@link Ingredient}
     * @param ingredient, the ingredient that is checked
     * @return a boolean that is true only if this drink has the ingredient
     * @since 1.0.0
     */
    boolean hasIngreadient(Ingredient ingredient){

        this.ingredients.add(new Ingredient(strIngredient1));
        this.ingredients.add(new Ingredient(strIngredient2));
        this.ingredients.add(new Ingredient(strIngredient3));
        this.ingredients.add(new Ingredient(strIngredient4));
        this.ingredients.add(new Ingredient(strIngredient5));
        this.ingredients.add(new Ingredient(strIngredient6));
        this.ingredients.add(new Ingredient(strIngredient7));
        this.ingredients.add(new Ingredient(strIngredient8));
        this.ingredients.add(new Ingredient(strIngredient9));
        this.ingredients.add(new Ingredient(strIngredient10));
        this.ingredients.add(new Ingredient(strIngredient11));
        this.ingredients.add(new Ingredient(strIngredient12));
        this.ingredients.add(new Ingredient(strIngredient13));
        this.ingredients.add(new Ingredient(strIngredient14));
        this.ingredients.add(new Ingredient(strIngredient15));

        measures.add(strMeasure1);
        measures.add(strMeasure2);
        measures.add(strMeasure3);
        measures.add(strMeasure4);
        measures.add(strMeasure5);
        measures.add(strMeasure6);
        measures.add(strMeasure7);
        measures.add(strMeasure8);
        measures.add(strMeasure9);
        measures.add(strMeasure10);
        measures.add(strMeasure11);
        measures.add(strMeasure12);
        measures.add(strMeasure13);
        measures.add(strMeasure14);
        measures.add(strMeasure15);


        for (Ingredient ing :
                ingredients) {
            if(ing.getIngredient() == null) return false;
            if(ing.getIngredient().equals(ingredient.getIngredient()))
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
        copy.addAll(ingredients);

        return copy;
    }

    public List<String> getSteps() {
        List<String> copy = new ArrayList<>();
        copy.addAll(steps);

        return copy;
    }
}
