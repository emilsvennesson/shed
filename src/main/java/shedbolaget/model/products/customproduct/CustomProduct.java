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
public enum CustomProduct {
    ;
    public static final String CUSTOM_PRODUCTS_FILENAME = "customproducts.json";
    public static final List<Product> customProducts = ProductsParserFactory.createJSONParser(CUSTOM_PRODUCTS_FILENAME).getProducts();

    /**
     * Creates a custom product and writes it to the JSON file.
     * @param name product name
     * @param category1 level 1 category name
     * @param category2 level 2 category name
     * @param price price in SEK
     * @param volume volume in ml
     * @param alcoholPercentage alcoholic percentage without decimals
     */
    public static void createProduct(String name, String category1, String category2, double price, double volume, int alcoholPercentage, String country, String imgUrl)
    {
        // create Product object
        Product newCustomProduct = new Product(name, category1, category2, price, volume, alcoholPercentage, country, imgUrl);
        customProducts.add(newCustomProduct);
        CustomProductWriter.writeProductsToJsonFile(customProducts, CUSTOM_PRODUCTS_FILENAME);
        EventManager.getInstance().fireEvent(new CustomProductCreatedEvent(newCustomProduct));
    }

    public static List<Product> getCustomProducts(){
        return new ArrayList<>(customProducts);
    }
}
