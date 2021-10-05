package shedbolaget.model.parser;

import shedbolaget.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ProductJsonFileParser implements IProductParser {
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            products = mapper.readValue(Paths.get("data.json").toFile(), new TypeReference<List<Product>>() {
            });

        } catch (Exception ex) {
            System.out.println("Failed to read data.json file.");
            ex.printStackTrace();
        }

        return products;
    }
}




