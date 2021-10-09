package shedbolaget.model.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class ProductJsonFileParser implements IProductParser {
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            products = mapper.readValue(ClassLoader.getSystemClassLoader().getResourceAsStream("data.json"), new TypeReference<>() {
            });

        } catch (Exception ex) {
            System.out.println("Failed to read data.json file.");
            ex.printStackTrace();
        }

        return products;
    }
}




