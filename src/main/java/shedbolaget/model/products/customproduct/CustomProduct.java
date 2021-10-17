package shedbolaget.model.products.customproduct;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.products.Product;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pouya Shirin
 */
public class CustomProduct {

    public static void createProduct(String name, String category1, String category2, double price, double volume, int alcoholPercentage)
    {

        try {
            // create Product object
            Product newCustomProduct = new Product(name, category1, category2, price, volume, alcoholPercentage);

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            // convert book object to JSON file
            mapper.writeValue(Paths.get("customproducts.json").toFile(), newCustomProduct);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /*
        try {
            // https://attacomsian.com/blog/jackson-write-json-file
            // create a map
            Map<String, Object> map = new HashMap<>();
            map.put("productId", "0");
            map.put("productNameBold", name);
            map.put("productNameThin", "null");
            map.put("volumeText", volume + " ml");
            map.put("volume", volume);
            map.put("price", price);
            map.put("categoryLevel1", category1);
            map.put("categoryLevel2", category2);

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert map to JSON file
            mapper.writeValue(Paths.get("customproducts.json").toFile(), map);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
         */

    }
}
