package shedbolaget.model.drinkfeatures;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;

public class DrinkJsonParser implements IDrinkLoader{
    @Override
    public List<Drink> load() {

        List<Drink> drinks = new ArrayList<>();
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            drinks = mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream("drinks.json"), new TypeReference<>() {
            });

        } catch (Exception ex) {
            System.out.println("Failed to read data.json file.");
            ex.printStackTrace();
        }

        return drinks;

    }
}
