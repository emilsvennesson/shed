package shedbolaget.model.products.customproduct;

import shedbolaget.model.UserDataManager;
import shedbolaget.model.events.CustomProductCreatedEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.parser.ProductsParserFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a custom product and writes the products to the JSON file.
 * @author Pouya Shirin
 */
public enum CustomProduct {
    ;
    private static final String CUSTOM_PRODUCTS_FILENAME = "customproducts.json";

    private static final List<Product> customProducts = getCustomProductsFromJson();

    /**
     * Creates a custom product and writes it to the JSON file.
     *
     * @param name              product name
     * @param category1         level 1 category name
     * @param category2         level 2 category name
     * @param price             price in SEK
     * @param volume            volume in ml
     * @param alcoholPercentage alcoholic percentage without decimals
     */
    public static Product createProduct(String name, String category1, String category2, double price, double volume, int alcoholPercentage, String country, String imgUrl) {
        // create Product object
        Product newCustomProduct = new Product(ProductModel.getInstance().getAvailableId(), name, category1, category2, price, volume, alcoholPercentage, country, imgUrl);
        customProducts.add(newCustomProduct);
        fireNewCustomEvent();
        return newCustomProduct;
    }

    /**
     * Gets the Custom Product list.
     * @return custom product list
     */
    public static List<Product> getCustomProducts() {
        return new ArrayList<>(customProducts);
    }

    /**
     * Removes the custom product from the custom product list.
     * @param product product
     */
    static void removeCustomProduct(Product product){
        customProducts.remove(product);
        fireNewCustomEvent();
    }

    /**
     * Each time the custom product list gets changed, update the json data file and fire the events.
     */
    private static void fireNewCustomEvent()
    {
        CustomProductWriter.writeProductsToJsonFile(customProducts, CUSTOM_PRODUCTS_FILENAME);
        EventManager.getInstance().fireEvent(new CustomProductCreatedEvent());
    }

    /**
     * Gets a list of custom products from customproducts.json. If it doesn't exist, return an empty list.
     * @return custom product list
     */
    private static List<Product> getCustomProductsFromJson() {
        InputStream stream;
        try {
            stream = new FileInputStream(Path.of(UserDataManager.getUserDataDirectory(), CUSTOM_PRODUCTS_FILENAME).toFile());
            return ProductsParserFactory.createJSONParser(stream).getProducts();
        } catch (FileNotFoundException e) {  // no custom products exist, return empty list
            return new ArrayList<>();
        }
    }
}
