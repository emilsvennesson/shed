package shedbolaget.model.drinks;

import java.util.ArrayList;
import java.util.List;

public class DrinkHolder {

    private final List<Drink> drinks = new ArrayList<>();

    private static final DrinkHolder instance = new DrinkHolder();

    public List<Drink> getDrinks(){
        return new ArrayList<>(drinks);
    }

    private DrinkHolder(){

    }

    public static DrinkHolder getInstance() {
        return instance;
    }
}
