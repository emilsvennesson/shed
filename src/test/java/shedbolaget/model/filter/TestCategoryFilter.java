package shedbolaget.model.filter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.Category;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestCategoryFilter {
    @Test
    public void testGetFilteredProducts() {
        Model model = Model.getInstance();
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Ale", 2));
        List<Product> products = model.getAllProducts();
        List<Product> filteredProductsList = CategoryFilter.getFilteredProducts(products, categories);
        for (Product p : filteredProductsList) {
            Assert.assertTrue(Objects.equals(p.getCategoryLevel2().getName(), "Ale"));
        }
    }

    // TODO skapa filter med alla categories i level 2 och jämför med motsvarande level 1 filter (Öl vs Ale/Ljus lager/...)
}
