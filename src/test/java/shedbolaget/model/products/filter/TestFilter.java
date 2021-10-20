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
        products = ProductModel.getInstance().getAllProducts();
    }

    @Test
    public void testGetFilteredProductsLevel2() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Ale", 2));
        categories.add(new Category("Öl", 1)); // using the application always has a category level 1
        List<Product> products = ProductModel.getInstance().getAllProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Ale", p.getCategoryLevel2().getName());
        }
    }

    @Test
    public void testGetFilteredProductsLevel1() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Öl", 1));
        List<Product> products = ProductModel.getInstance().getAllProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Öl", p.getCategoryLevel1().getName());
        }
    }

    @Test
    public void testSearch() {
        for (Product p : Filter.search(ProductModel.getInstance().getAllProducts(), "Fruktigt & Smakrikt vin", 100)) {
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Fruktigt & Smakrikt vin");
        }
        for (Product p : Filter.search(products, "Fruktigt & Smakrikt vin", 100)) {
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Fruktigt & Smakrikt vin");
        }
        for (Product p : Filter.search(products, "Arboga 10,2", 100)) {
            Assert.assertEquals(p.getFullProductName(), "Arboga 10,2");
        }

    }

    @Test
    public void testCategoryCombination() {
        System.out.println("hi");
    }
}


// TODO skapa filter med alla categories i level 2 och jämför med motsvarande level 1 filter (Öl vs Ale/Ljus lager/...)

