package shedbolaget.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class Image {
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String productId;
    private String productNumber;
    private String productNameBold;
    private String productNameThin;
    private double price;
    private double volume;
    private double alcoholPercentage;
    private List<Image> images;
    private String country;
    private boolean isNews;
    private String producerName;
    private String color;
    private String taste;
    private String usage;
    private String categoryLevel1;
    private String categoryLevel2;

    public Category getCategoryLevel1() {
        return new Category(categoryLevel1);
    }

    public Category getCategoryLevel2() {
        return new Category(categoryLevel2);
    }

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

    public double getVolume() {
        return volume;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public double getApk() {
        return (volume * alcoholPercentage * 0.01) / price;
    }

    public String getCountry() {
        return country;
    }

    public boolean isNews() {
        return isNews;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getColor() {
        return color;
    }

    public String getTaste() {
        return taste;
    }

    public String getUsage() {
        return usage;
    }

    public String getImageUrl(ImageSize imageSize) {
        String imageUrl;
        String size;
        switch (imageSize) {
            case SMALL:
                size = "20";
                break;
            case MEDIUM:
                size = "100";
                break;
            case LARGE:
                size = "200";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + imageSize);
        }

        try {
            imageUrl = this.getImages().get(0).getImageUrl() + String.format("_%s.png", size);
        } catch (IndexOutOfBoundsException e) {
            // fallback, some products do not have an image in json even though it exists on cdn
            imageUrl = String.format("https://product-cdn.systembolaget.se/productimages/%s/%s_%s.png", this.getProductId(), this.getProductId(), size);
        }
        return imageUrl;
    }

    public enum ImageSize {
        SMALL,
        MEDIUM,
        LARGE
    }
}
