package frontend;

import backend.DataHandler;
import backend.Product;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        DataHandler backend = new DataHandler();
        for (Product product : backend.getCategory("Alkoholfritt")) {
            System.out.println(product.categoryLevel1);
        }
    }
}
