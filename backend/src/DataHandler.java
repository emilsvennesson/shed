import java.util.List;

public class DataHandler {
    private final IProductParser productParser;
    private final List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    DataHandler() {
        productParser = new ProductJsonFileParser();
        products = productParser.getProducts();

    }
}
