package shedbolaget.model.events;

import shedbolaget.model.drinks.Drink;
import shedbolaget.model.drinks.Ingredient;

import java.util.ArrayList;
import java.util.List;

//TODO add Javadoc

/**
 * @author Daniel Rygaard
 */
public class DrinkListEvent {

    private List<Drink> drinks;


    public DrinkListEvent(List<Drink> drinks){
        this.drinks = drinks;
    }


    public List<Drink> getDrinks() {
        return new ArrayList<>(drinks);
    }
}
