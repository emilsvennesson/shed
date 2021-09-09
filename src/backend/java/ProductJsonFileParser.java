package backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class ProductJsonFileParser implements IProductParser {
    private List<Product> products;

    ProductJsonFileParser() {
        products = new ArrayList<>();
        setProducts();
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    private void setProducts() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            products = mapper.readValue(Paths.get("data.json").toFile(), new TypeReference<List<Product>>() {
            });
        } catch (Exception ex) {
            System.out.println("Failed to read data.json file.");
            ex.printStackTrace();
        }

    }
}




