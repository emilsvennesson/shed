package shedbolaget.backend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private double volume;
    private double alcoholPercentage;
    private List<Image> images;

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

    public double getApk(){ return (volume * alcoholPercentage)/price;}


}
