package shedbolaget.model.products;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.sorter.Sorter;

import java.util.List;

public class TestSorter {
    @Test
    public void testGetProductListSortedByPrice() {
        List<Product> products = ProductsHolder.getInstance().getAllProducts();
        Product cheapestProduct = products.get(0);
        double cheapestPrice = cheapestProduct.getPrice();
        for(Product p : products) {
            if(cheapestPrice > p.getPrice()) {
                cheapestPrice = p.getPrice();
                cheapestProduct = p;
            }
        }
        List<Product> sortedProducts = Sorter.getProductListSortedByPrice(products);
        Assert.assertEquals(cheapestProduct.getProductNameBold(), sortedProducts.get(0).getProductNameBold());
    }

    @Test
    public void testGetProductListSortedByApk() {
        List<Product> products = ProductsHolder.getInstance().getAllProducts();
        Product bestProduct = products.get(0);
        double bestApk = bestProduct.getApk();
        for(Product p : products) {
            if(bestApk < p.getApk()) {
                bestApk = p.getApk();
                bestProduct = p;
            }
        }
        List<Product> sortedProducts = Sorter.getProductListSortedByApk(products);
        Assert.assertEquals(bestProduct.getProductNameBold(), sortedProducts.get(0).getProductNameBold());
    }
}
