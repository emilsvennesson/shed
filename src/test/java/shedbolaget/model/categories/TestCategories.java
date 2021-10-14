package shedbolaget.model.categories;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class TestCategories {
    @Test
    public void testLevel1() {
        // check that all keys actually are categories level 1
        HashMap<Category, List<Category>> categoriesList = Categories.getAllCategories();
        for (Category key : categoriesList.keySet()) {
            Assert.assertEquals(1, key.getLevel());
        }
    }

    @Test
    public void testLevel2() {
        // values should be categories level 2
        HashMap<Category, List<Category>> categoriesList = Categories.getAllCategories();
        for (List<Category> value : categoriesList.values()) {
            for (Category c : value) {
                Assert.assertEquals(2, c.getLevel());
            }
        }
    }

}
