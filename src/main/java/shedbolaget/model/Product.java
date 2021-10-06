package shedbolaget.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class Image {
    public String getImageUrl() {
        return imageUrl;
    }

    private String imageUrl;
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
    private boolean isNew;

    private String producerName;
    private String color;
    private String taste;
    private String usage;

    public String getCategoryLevel1() {
        return categoryLevel1;
    }

    public String getCategoryLevel2() {
        return categoryLevel2;
    }

    private String categoryLevel1;
    private String categoryLevel2;

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

    public double getVolume(){ return volume;}

    public double getAlcoholPercentage(){return alcoholPercentage;}

    public double getApk(){ return (volume * alcoholPercentage * 0.01) / price;}

    public String getCountry(){return country;}

    public boolean getIsNew(){return isNew;}

    public boolean isNew() {
        return isNew;
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
}
