package shedbolaget.model.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson
 */
class ProductJsonFileParser implements IProductParser {
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            // use jackson to parse the JSON file into a products list
            products = mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream("data.json"), new TypeReference<>() {
            });

        } catch (Exception ex) {
            System.out.println("Failed to read data.json file.");
            ex.printStackTrace();
        }

        return products;
    }
}




