package shedbolaget.model.products.sorter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductList;

import java.util.List;
import java.util.function.Function;

public class TestProductListSorter {

    @Test
    public void testGetProductsSortedByDouble() {
        List<Product> products = ProductList.getInstance().getAllProducts();
        Product cheapestProduct = products.get(0);
        double cheapestPrice = cheapestProduct.getPrice();
        for (Product p : products) {
            if (cheapestPrice > p.getPrice()) {
                cheapestPrice = p.getPrice();
                cheapestProduct = p;
            }
        }
        List<Product> sortedProducts = new ProductListSorter().getProductsSortedByDouble(Product::getPrice, products);
        Assert.assertEquals(cheapestProduct.getProductNameBold(), sortedProducts.get(0).getProductNameBold());
    }

    @Test
    public void testGetProductsSortedByBoolean() {
        List<Product> products = ProductList.getInstance().getAllProducts();
        int len = 0;
        for (Product p : products) {
            if (p.getPrice() < 10)
                len++;
        }
        Function<Product, Boolean> func = p -> p.getPrice() < 10;
        List<Product> sorted = new ProductListSorter().getProductsSortedByBoolean(func, products);
        sorted.subList(0, len).forEach(p -> Assert.assertTrue(p.getPrice() < 10));
        sorted.subList(len, sorted.size()).forEach(p -> Assert.assertTrue(p.getPrice() >= 10));
    }

}
