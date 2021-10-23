package shedbolaget.model.drinks;

import shedbolaget.model.drinks.parser.DrinkJsonFileParser;

import java.util.ArrayList;
import java.util.List;

public class DrinkHolder {

    private final List<Drink> drinks = new DrinkJsonFileParser().load();

    private static final DrinkHolder instance = new DrinkHolder();

    /**
     * Gives all the drinks that exists in the program
     * @return, a list of {@link Drink}s
     */
    public List<Drink> getDrinks(){
        return new ArrayList<>(drinks);
    }

    private DrinkHolder(){

    }

    public static DrinkHolder getInstance() {
        return instance;
    }
}
