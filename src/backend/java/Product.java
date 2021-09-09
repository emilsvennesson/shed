package backend.java;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String supplierName;


    public String getSupplierName() {
        return supplierName;
    }

}
