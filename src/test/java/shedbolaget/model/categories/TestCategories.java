package shedbolaget.model.categories;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Products;

import java.util.List;
import java.util.Map;

public class TestCategories {
    @Test
    public void testLevel1() {
        // check that all keys actually are categories level 1
        Map<Category, List<Category>> categoriesList = Categories.getCategoriesAsMap(Products.getInstance().getAllProducts());
        for (Category key : categoriesList.keySet()) {
            Assert.assertEquals(1, key.getLevel());
        }
    }

    @Test
    public void testLevel2() {
        // values should be categories level 2
        Map<Category, List<Category>> categoriesList = Categories.getCategoriesAsMap(Products.getInstance().getAllProducts());
        for (List<Category> value : categoriesList.values()) {
            for (Category c : value) {
                Assert.assertEquals(2, c.getLevel());
            }
        }
    }

}
