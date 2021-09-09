package backend;
import java.util.List;

public class DataHandler {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public DataHandler() {
        setProducts(new ProductJsonFileParser());
    }


    public int getSize() {
        return this.products.size();
    }
  
    private void setProducts(IProductParser parser) {
        products = parser.getProducts();
    }
}
