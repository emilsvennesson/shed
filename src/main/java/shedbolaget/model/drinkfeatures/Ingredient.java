package shedbolaget.model.drinkfeatures;

import shedbolaget.model.Product;
import shedbolaget.model.favorites.SavableProductIdList;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * model.drinkfeatures.Ingredient
 *
 * <p> Used as a utility class and represents a ingredient
 *     The responsibility of this class is to represent a product as an ingredient</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public class Ingredient {


    String ingredient;
    private String ingredient;

    public Ingredient(Product prod){

        //TODO turn the product into ingredient


    }


    public String getIngredient() {
        return ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getIngredient().equals(that.getIngredient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredient());
    }
}
