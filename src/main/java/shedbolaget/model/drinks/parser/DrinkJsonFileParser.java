package shedbolaget.model.drinks.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.drinks.Drink;

import java.util.ArrayList;
import java.util.List;

/**
 * Reads all the {@link Drink} information from a json file
 * @author Daniel Rygaard
 */
public class DrinkJsonFileParser implements IDrinkParser {
    @Override
    public List<Drink> load() {

        List<Drink> drinks = null;
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            drinks = mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream("drinksFormatted.json"), new TypeReference<>() {
            });

        } catch (Exception ex) {
            System.out.println("Failed to read data.json file.");
            ex.printStackTrace();
        }

        return drinks;

    }
}
