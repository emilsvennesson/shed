package shedbolaget.model.products.customproduct;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.UserDataManager;
import shedbolaget.model.products.Product;

import java.nio.file.Path;
import java.util.List;
/**
 * This class handles the writing of a list of products.
 * @author Pouya Shirin
 */
enum CustomProductWriter { //TODO This class is best suited to be in JSON productparser package. It does not depend on costum products at all.
    ;

    /**
     * This static method takes a list of products and writes it to the user home file where all user data is stored.
     * @param customProducts a list of products
     * @param fileName the filename to store it to.
     */
    public static void writeProductsToJsonFile(List<Product> customProducts, String fileName) {
        // Create object mapper instance & use variables instead of getters
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try { // Write list of products to userdata home with the given filename
            mapper.writeValue(Path.of(UserDataManager.getUserDataDirectory(), fileName).toFile(), customProducts);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
