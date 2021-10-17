package shedbolaget.model.drinkfeatures;

import org.junit.Test;
import shedbolaget.model.drinkfeatures.DrinkModel;

import java.util.List;

public class TestDrinkModel {

    DrinkModel dModel = new DrinkModel();


    @Test
    public void parsing(){
        DrinkJsonParser parser = new DrinkJsonParser();
        List<Drink> hej = parser.load();

        for (Drink d :
                hej) {
            System.out.println(d.getName());
        }

    }

    @Test
    public void removeIngredient(){

    }


    @Test
    public void addIngredient(){



    }




}
