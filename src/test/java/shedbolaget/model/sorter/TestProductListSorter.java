package shedbolaget.model.sorter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.util.List;
import java.util.function.Function;

public class TestProductListSorter {

    @Test
    public void testGetProductsSortedByDouble() {
        Model model = Model.getInstance();
        List<Product> products = model.getAllProducts();
        Product cheapestProduct = products.get(0);
        double cheapestPrice = cheapestProduct.getPrice();
        for(Product p : products) {
            if(cheapestPrice > p.getPrice()) {
                cheapestPrice = p.getPrice();
                cheapestProduct = p;
            }
        }
        List<Product> sortedProducts = ProductListSorter.getProductsSortedByDouble(Product::getPrice, products);
        Assert.assertEquals(cheapestProduct.getProductNameBold(), sortedProducts.get(0).getProductNameBold());
    }

    @Test
    public void testGetProductsSortedByBoolean() {
        Model model = Model.getInstance();
        List<Product> products = model.getAllProducts();
        int len = 0;
        for(Product p : products) {
            if(p.getPrice()<10)
                len++;
        }
        Function<Product, Boolean> func = p -> p.getPrice() < 10;
        List<Product> sorted = ProductListSorter.getProductsSortedByBoolean(func, products);
        sorted.subList(0,len).forEach(p -> Assert.assertTrue(p.getPrice() < 10));
        sorted.subList(len,sorted.size()).forEach(p -> Assert.assertTrue(p.getPrice() >= 10));
    }
}
