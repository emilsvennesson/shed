package frontend;

import backend.DataHandler;
import backend.Product;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        DataHandler backend = new DataHandler();
        List<Product> products = backend.getProducts();

        for (Product product : products) {
            System.out.println(product.productNameBold);
        }
    }
}
