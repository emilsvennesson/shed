package shedbolaget.model.drinks;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import shedbolaget.model.products.Product;

import java.util.Objects;

/**
 * model.drinkfeatures.Ingredient
 *
 * <p> Used as a utility class and represents a ingredient
 *     The responsibility of this class is to represent a product as an ingredient</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {


    public String name;
    public String measure = "0";


    Product prod;




    public Ingredient(){

    }


    public Ingredient(Product prod){
        //TODO turn the product into ingredient
        this.name = getIngredientName(prod);
        this.prod = prod;


    }

    public String getMeasure() {
        return measure;
    }



    public String getName() {
        return name;
    }

    public String getIngredientName(Product prod){
        if(prod.getProductNameBold().equals("Jameson"))
            System.out.println("hej");
        if(prod.getCategoryLevel1().getName().equals("Sprit")){

            if(prod.getCategoryLevel3().getName() == null)
                return "Sprit";
            if(prod.getCategoryLevel3().getName().equals("Mörk rom")){
                return "Mörk rom";
            }
            if(prod.getCategoryLevel3().getName().equals("Ljus rom")){
                return"Ljus rom";
            }

            if(prod.getCategoryLevel2().getName().equals("Whisky"))
                return "Whisky";

            if(prod.getCategoryLevel2().getName().equals("Vodka")){
                return "Vodka";
            }

            return prod.getCategoryLevel3().getName();



        }
        return prod.getProductNameBold();


    }


    public Product getProd() {
        return prod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
