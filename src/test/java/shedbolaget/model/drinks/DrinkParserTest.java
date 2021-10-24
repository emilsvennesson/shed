package shedbolaget.model.drinks;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.drinks.parser.DrinkJsonFileParser;
import shedbolaget.model.drinks.parser.IDrinkParser;

import java.util.List;

public class DrinkParserTest {

    @Test
    public void parsing(){
        IDrinkParser parser = new DrinkJsonFileParser();
        List<Drink> parsedDrinks = parser.load();

        Assert.assertNotEquals(0, parsedDrinks.size());

        for (Drink drink :
                parsedDrinks) {
            Assert.assertNotNull(drink);

        }

    }

}
