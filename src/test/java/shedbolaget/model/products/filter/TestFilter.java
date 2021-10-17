package shedbolaget.model.products.filter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.categories.Category;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductList;

import java.util.ArrayList;
import java.util.List;

public class TestFilter {
    @Test
    public void testGetFilteredProductsLevel2() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Ale", 2));
        List<Product> products = ProductList.getInstance().getAllProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Ale", p.getCategoryLevel2().getName());
        }
    }

    @Test
    public void testGetFilteredProductsLevel1() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Öl", 1));
        List<Product> products = ProductList.getInstance().getAllProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Öl", p.getCategoryLevel1().getName());
        }
    }

    @Test
    public void testSearch() {
        for (Product p : Filter.search(ProductList.getInstance().getAllProducts(), "Fruktigt & Smakrikt vin", 100)) {
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Fruktigt & Smakrikt vin");
        }
        for (Product p : Filter.search(ProductList.getInstance().getAllProducts(), "Arboga 10,2", 100)) {
            Assert.assertEquals(p.getFullProductName(), "Arboga 10,2");
        }

    }

    // TODO skapa filter med alla categories i level 2 och jämför med motsvarande level 1 filter (Öl vs Ale/Ljus lager/...)
}
