package shedbolaget.model.products.categories;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.ProductModel;

import java.util.List;
import java.util.Map;

public class TestCategories {
    @Test
    public void testLevel1() {
        // check that all keys actually are categories level 1
        Map<Category, List<Category>> categoriesList = Categories.getCategoriesAsMap(ProductModel.getInstance().getProducts());
        for (Category key : categoriesList.keySet()) {
            Assert.assertEquals(1, key.getLevel());
        }
    }

    @Test
    public void testLevel2() {
        // values should be categories level 2
        Map<Category, List<Category>> categoriesList = Categories.getCategoriesAsMap(ProductModel.getInstance().getProducts());
        for (List<Category> value : categoriesList.values()) {
            for (Category c : value) {
                Assert.assertEquals(2, c.getLevel());
            }
        }
    }

    @Test
    public void testGetLevel2Categories() {
        List<Category> categories = Categories.getLevel2Categories(ProductModel.getInstance().getProducts());
        for (Category category : categories)
            Assert.assertEquals(category.getLevel(), 2);

    }

    @Test
    public void testGetCategoriesByLevel() {
        List<Category> categories = Categories.getLevel2Categories(ProductModel.getInstance().getProducts());
        categories.addAll(Categories.getLevel1Categories(ProductModel.getInstance().getProducts()));
        // merge all categories to one list
        for (Category category : Categories.getCategoriesByLevel(categories, 1))
            Assert.assertEquals(category.getLevel(), 1);
        for (Category category : Categories.getCategoriesByLevel(categories, 2))
            Assert.assertEquals(category.getLevel(), 2);
    }

    @Test
    public void testGetCategoriesAsMap() {
        Map<Category, List<Category>> categoriesList = Categories.getCategoriesAsMap(ProductModel.getInstance().getProducts());
        for (Map.Entry<Category, List<Category>> entry : categoriesList.entrySet()) {
            Category key = entry.getKey();
            Assert.assertEquals(key.getLevel(), 1);
            List<Category> value = entry.getValue();
            for (Category category : value)
                Assert.assertEquals(category.getLevel(), 2);
        }
    }

}
