package shedbolaget.model.sorter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSorter {
    @Test
    public void testSortProductsDouble() {
        Model model = Model.getInstance();
        List<Double> productPrices = new ArrayList<>();
        for (Product p : model.getAllProducts())
            productPrices.add(p.getPrice());
        model.sortProductsDouble(Product::getPrice);
        productPrices.sort(Double::compare);
        List<Product> products = model.getAllProducts();
        boolean listsAreEqual = true;
        for (int i = 0; i < productPrices.size(); i++) {
            if (!productPrices.get(i).equals(products.get(i).getPrice())) {
                listsAreEqual = false;
                break;
            }
        }
        Assert.assertTrue(listsAreEqual);
    }

    @Test
    public void testSortProductsString() {
        Model model = Model.getInstance();
        List<String> productNames = new ArrayList<>();
        for (Product p : model.getAllProducts())
            productNames.add(p.getProductNameBold());
        model.sortProductsString(Product::getProductNameBold);
        Collections.sort(productNames);
        List<Product> products = model.getAllProducts();
        boolean listsAreEqual = true;
        for (int i = 0; i < productNames.size(); i++) {
            if (!productNames.get(i).equals(products.get(i).getProductNameBold())) {
                listsAreEqual = false;
                break;
            }
        }
        Assert.assertTrue(listsAreEqual);
    }

    @Test
    public void testSortProductsBoolean() {
        Model model = Model.getInstance();
        List<Boolean> productIsNews = new ArrayList<>();
        for (Product p : model.getNewProducts(model.getSize()))
            productIsNews.add(p.isNews());
        model.sortProductsBoolean(Product::isNews);
        Collections.sort(productIsNews);
        List<Product> products = model.getAllProducts();
        boolean listsAreEqual = true;
        for (int i = 0; i < productIsNews.size(); i++) {
            if (!productIsNews.get(i).equals(products.get(i).isNews())) {
                listsAreEqual = false;
                break;
            }
        }
        Assert.assertTrue(listsAreEqual);
    }
}
