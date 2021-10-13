package shedbolaget.model.categories;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.Category;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.util.ArrayList;
import java.util.List;

public class TestCategoryProductFilter {
    private Model model = Model.getInstance();

    @Test
    public void testGetFilteredProductsLevel2() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Ale", 2));
        List<Product> products = model.getAllProducts();
        List<Product> filteredProductsList = CategoryProductFilter.getFilteredProducts(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Ale", p.getCategoryLevel2().getName());
        }
    }

    @Test
    public void testGetFilteredProductsLevel1() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Öl", 1));
        List<Product> products = model.getAllProducts();
        List<Product> filteredProductsList = CategoryProductFilter.getFilteredProducts(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertEquals("Öl", p.getCategoryLevel1().getName());
        }
    }

    @Test
    public void testTest() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Öl", 1));
        List<Product> products = model.getFilteredProducts(model.getAllProducts(), categories);
        System.out.println(products.size());

        List<Category> categories2 = new ArrayList<>();
        categories2.add(new Category("Öl", 1));
        categories2.add(new Category("Vin", 1));
        categories2.add(new Category("Ale", 2));
        categories2.add(new Category("Ale", 2));
        List<Product> products2 = model.getFilteredProducts(model.getAllProducts(), categories2);
        System.out.println(products2.size());
    }

    // TODO skapa filter med alla categories i level 2 och jämför med motsvarande level 1 filter (Öl vs Ale/Ljus lager/...)
}
