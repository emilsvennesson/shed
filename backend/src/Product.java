import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    public String getSupplierName() {
        return supplierName;
    }
    private String supplierName;
}
