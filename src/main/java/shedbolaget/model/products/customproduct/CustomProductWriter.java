package shedbolaget.model.products.customproduct;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.products.Product;

import java.nio.file.Path;
import java.util.List;

enum CustomProductWriter {
    ;

    public static void writeProductsToJsonFile(List<Product> customProducts, String fileName) {
        // Create object mapper instance & use variables instead of getters
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            mapper.writeValue(Path.of("src", "main", "resources", fileName).toFile(), customProducts);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }
}
