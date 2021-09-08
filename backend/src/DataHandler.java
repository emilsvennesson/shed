import java.util.List;

public class DataHandler {
    private IProductParser productParser;

    public List<Product> getProducts() {
        return products;
    }

    private final List<Product> products;

    DataHandler() {
        productParser = new ProductJsonFileParser();
        products = productParser.getProducts();

    }
}
