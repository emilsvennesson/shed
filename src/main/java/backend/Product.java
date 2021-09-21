package backend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

class Image {
    public String imageUrl;
    public Object fileType;
    public Object size;
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String productId;
    private String productNumber;
    private String productNameBold;
    private String productNameThin;
    private double price;
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getProductNameBold() {
        return productNameBold;
    }

    public String getProductNameThin() {
        return productNameThin;
    }

    public double getPrice() {
        return price;
    }


}
