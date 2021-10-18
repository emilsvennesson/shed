package shedbolaget.model.products.customproduct;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.events.CustomProductCreatedEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.parser.ProductsParserFactory;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//TODO Separate -Creating- and -Writing- into two different classes
/**
 * This class creates a custom product and writes the products to the JSON file
 * @author Pouya Shirin
 */
public class CustomProduct {
    public static final String CUSTOM_PRODUCTS_FILENAME = "customproducts.json";

    /**
     * Creates a custom product and writes it to the JSON file.
     * @param name product name
     * @param category1 level 1 category name
     * @param category2 level 2 category name
     * @param price price in SEK
     * @param volume volume in ml
     * @param alcoholPercentage alcoholic percentage without decimals
     */
    public static void createProduct(String name, String category1, String category2, double price, double volume, int alcoholPercentage)
    {
        // create Product object
        List<Product> customProducts = new ArrayList<>();
        Product newCustomProduct = new Product(name, category1, category2, price, volume, alcoholPercentage);
        customProducts.add(newCustomProduct);
        writeProductsToJsonFile(customProducts);
        EventManager.getInstance().fireEvent(new CustomProductCreatedEvent(newCustomProduct));
    }

    private static void writeProductsToJsonFile(List<Product> customProducts){
        try {
            for (Product product: ProductsParserFactory.createJSONParser(CUSTOM_PRODUCTS_FILENAME).getProducts())
                    customProducts.add(product);


            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            // convert book object to JSON file
            mapper.writeValue(Paths.get("src", "main", "resources", CUSTOM_PRODUCTS_FILENAME).toFile(), customProducts);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
