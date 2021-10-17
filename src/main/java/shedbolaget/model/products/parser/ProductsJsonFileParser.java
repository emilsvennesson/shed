package shedbolaget.model.products.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson
 */
class ProductsJsonFileParser implements IProductsParser {
    @Override
    public List<Product> getProducts(String fileName) {
        List<Product> products = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            // use jackson to parse the JSON file into a products list
            products = mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream(fileName), new TypeReference<>() {
            });

        } catch (Exception ex) {
            System.out.println("Failed to read " + fileName + " file.");
            ex.printStackTrace();
        }

        return products;
    }
}




