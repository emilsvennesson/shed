package shedbolaget.model.drinks;


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
public class Ingredient {


    private String ingredient;
    private Product product;

    Ingredient(String ing){
        this.ingredient = ing;
    }

    public Ingredient(Product prod){
        this.product = prod;
        //TODO turn the product into ingredient
        this.ingredient = getIngredientName(prod);


    }


    public String getIngredient() {
        return ingredient;
    }

    public String getIngredientName(Product prod){
        if(prod.getCategoryLevel1().getName().equals("Sprit")){

            if(prod.getCategoryLevel3().getName().equals("M\\u00f6rk rom")){
                return "Dark rum";
            }
            if(prod.getCategoryLevel3().equals("Light rum")){
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


    public void saveName(){
        System.out.println(this.product.getProducerName() + " has no ingredient");
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
