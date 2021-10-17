package shedbolaget.model.products.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import shedbolaget.model.products.Product;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson
 */
class ProductsJSONFileParser implements IProductsParser {
    private List<Product> products;
    private final InputStream streamToParse;

    ProductsJSONFileParser(InputStream streamToParse) {
        this.streamToParse = streamToParse;
        initProducts();
    }

    private void initProducts() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // use jackson to parse the JSON file into a products list
            products = mapper.readValue(streamToParse, new TypeReference<>() {
            });

        } catch (Exception ex) {
            System.out.println("Failed to read stream.");
            ex.printStackTrace();
        }

    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}



