package shedbolaget.model.products.customproduct;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.products.Product;

import java.nio.file.Paths;

/**
 * @author Pouya Shirin
 */
public class CustomProduct {
    public static final String CUSTOM_PRODUCTS_FILENAME = "customproducts.json";
    public static void createProduct(String name, String category1, String category2, double price, double volume, int alcoholPercentage)
    {
        // create Product object
        Product newCustomProduct = new Product(name, category1, category2, price, volume, alcoholPercentage);
        writeProductToJsonFile(newCustomProduct);
    }

    private static void writeProductToJsonFile(Product product){
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            // convert book object to JSON file
            mapper.writeValue(Paths.get("src", "main", "resources", CUSTOM_PRODUCTS_FILENAME).toFile(), product);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
