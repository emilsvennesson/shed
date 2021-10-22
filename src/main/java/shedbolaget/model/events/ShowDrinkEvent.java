package shedbolaget.model.events;

import shedbolaget.model.drinks.Drink;

public class ShowDrinkEvent {

    private Drink drink;
    public ShowDrinkEvent(Drink drink){
        this.drink = drink;
    }

    public Drink getDrink() {
        return drink;
    }
}
