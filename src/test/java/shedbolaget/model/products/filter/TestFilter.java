package shedbolaget.model.products.filter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shedbolaget.model.categories.Category;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class TestFilter {
    private List<Product> products;

    @Before
    public void initProducts() {
        products = ProductModel.getInstance().getProducts();
    }

    @Test
    public void testCombinedFilteredProductsLevel2() {
        // we expect the filter to return the products in "Ale" in this scenario
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Ale", 2));
        categories.add(new Category("Öl", 1));
        List<Product> products = ProductModel.getInstance().getProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Ale", p.getCategoryLevel2().getName());
        }
    }

    @Test
    public void testFilteredProductsLevel2() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Ale", 2));
        List<Product> products = ProductModel.getInstance().getProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Ale", p.getCategoryLevel2().getName());
        }
    }

    @Test
    public void testGetFilteredProductsLevel1() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Öl", 1));
        List<Product> products = ProductModel.getInstance().getProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Öl", p.getCategoryLevel1().getName());
        }
    }

    @Test
    public void testSearchWithRatio100() {
        for (Product p : Filter.search(ProductModel.getInstance().getProducts(), "Fruktigt & Smakrikt vin", 100))
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Fruktigt & Smakrikt vin");
        for (Product p : Filter.search(products, "Arboga 10,2", 100))
            Assert.assertEquals(p.getFullProductName(), "Arboga 10,2");
    }

    @Test
    public void testSearchWithRatio95() {
        int fuzzyRatio = 95;
        for (Product p : Filter.search(ProductModel.getInstance().getProducts(), "fruktiGt Smakrikt vin", fuzzyRatio))
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Fruktigt & Smakrikt vin");
        for (Product p : Filter.search(products, "ArbogA 10.2", fuzzyRatio))
            Assert.assertEquals(p.getFullProductName(), "Arboga 10,2");
    }
}


// TODO skapa filter med alla categories i level 2 och jämför med motsvarande level 1 filter (Öl vs Ale/Ljus lager/...)

