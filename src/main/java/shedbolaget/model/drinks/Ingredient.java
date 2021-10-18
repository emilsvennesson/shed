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


    @JsonIgnore
    private String cat3;
    @JsonIgnore
    private String altCat;
    @JsonIgnore
    private String productNameBold;
    @JsonIgnore
    private String productNameThin;



    public Ingredient(){

    }


    public Ingredient(Product prod){
        //TODO turn the product into ingredient
        this.name = getIngredientName(prod);
        this.cat3 = prod.getCategoryLevel3().getName();
        this.productNameBold = prod.getProductNameBold();
        this.productNameThin = prod.getProductNameThin();
        this.altCat = prod.getCustomCategoryTitle();

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

    public String getProductNameBold() {
        return productNameBold;
    }

    public String getProductNameThin() {
        return productNameThin;
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
        return prod.getProductNameBold();


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
