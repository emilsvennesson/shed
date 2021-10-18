package shedbolaget.model.drinks;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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


    private String cat3;
    private String altCat;



    public Ingredient(){

    }


    public Ingredient(Product prod){
        //TODO turn the product into ingredient
        this.name = getIngredientName(prod);


    }

    public String getMeasure() {
        return measure;
    }

    public String getCat3() {
        return cat3;
    }

    public String getAltCat() {
        return altCat;
    }

    public String getName() {
        return name;
    }

    public String getIngredientName(Product prod){
        if(prod.getCategoryLevel1().getName().equals("Sprit")){

            if(prod.getCategoryLevel3().getName().equals("Mörk rom")){
                return "Dark rum";
            }
            if(prod.getCategoryLevel3().equals("Ljus rom")){
                return"Light Rum";
            }

            if(prod.getCategoryLevel3().getName().equals("Smaksatt sprit")){
                if(prod.getProductNameBold().equals("Baileys")){
                    return "Baileys";
                }


            }
            return prod.getCategoryLevel3().getName();
            /*
            if(prod.getCategoryLevel2().equals("rom")){
                //TODO test if this equals works

            }

            if(prod.getCategoryLevel2().equals("Vodka")){
                return "Vodka";

            }

            if(prod.getCategoryLevel2().equals("Tequila & Mezcal")){
                return "Tequila";
            }
            if(prod.getCategoryLevel3().getName().equals("Gin")){
                return "Gin";
            }

            if(prod.getCategoryLevel2().equals("likör")){
                if(prod.getCategoryLevel3().equals("Baileys"))
                    return "Baileys Irish Cream";
                if(prod.getCategoryLevel3().equals("Disaronno")){
                    return "Amaretto";
                }


            }


        */


        }


        return null;
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
