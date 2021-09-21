package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Filter {

    public static List<Product> getCategory(List<Product> products, String categoryName){
        List<Product> category = new ArrayList<>();
        for(Product product : products){
            if(product.categoryLevel1.contains(categoryName) ||
                product.categoryLevel2.contains(categoryName))
                category.add(product);
        }
        return  category;
    }

    public static List<Product> getProducts(List<Product> products, String filter){
        List<Product> newProducts = new ArrayList<>();
        for(Product product : products){
            if(product.productNameBold.contains(filter))
                newProducts.add(product);
        }
        return newProducts;
    }
}
