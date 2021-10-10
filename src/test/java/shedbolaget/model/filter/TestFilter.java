package shedbolaget.model.filter;
import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.util.List;
import java.util.Random;

public class TestFilter {
    @Test
    public void testGetLevel1CategoryProducts() {
        Model dh = Model.getInstance();
        dh.clearAllFilters();
        boolean wrongCategory = false;
        String category = "Öl";
        dh.setCategoryLevel1Filter(category);
        for (Product product : dh.getFilteredProducts()) {
            if (!product.getCategoryLevel1().contains(category)) {
                wrongCategory = true;
                break;
            }
        }
        Assert.assertFalse(wrongCategory);
    }

    @Test
    public void testGetLevel2CategoryProducts() {
        Model dh = Model.getInstance();
        dh.clearAllFilters();
        boolean wrongCategory = false;
        String category = "Veteöl";
        dh.addCategoryLevel2Filter(category);
        for (Product product : dh.getFilteredProducts()) {
            if (!product.getCategoryLevel2().contains(category)) {
                wrongCategory = true;
                break;
            }
        }
        Assert.assertFalse(wrongCategory);
    }

    @Test
    public void testAddAndRemoveCategoryLevel2() {
        Model model = Model.getInstance();
        model.clearAllFilters();
        model.addCategoryLevel2Filter("test1");
        model.addCategoryLevel2Filter("test2");
        Assert.assertEquals("test1", model.getActiveLevel2Categories().get(0));
        Assert.assertEquals("test2", model.getActiveLevel2Categories().get(1));
        model.clearCategoryLevel2Filters();
        Assert.assertEquals(0, model.getActiveLevel2Categories().size());
    }

    @Test
    public void testAddAndRemoveCategoryLevel1() {
        Model model = Model.getInstance();
        model.setCategoryLevel1Filter("beer");
        Assert.assertEquals("beer", model.getActiveLevel1Category());
        model.clearCategoryLevel1Filter();
        Assert.assertEquals("", model.getActiveLevel1Category());
    }

    @Test
    public void testGetActiveCategoryLevel1Filter() {
        Model model = Model.getInstance();
        model.setCategoryLevel1Filter("beer");
        String activeCategoryLevel1 = model.getActiveCategoryLevel1Filter();
        Assert.assertEquals(activeCategoryLevel1, "beer");
        model.clearCategoryLevel1Filter();
        Assert.assertTrue(model.getActiveCategoryLevel1Filter().isEmpty());
    }

    @Test
    public void testGetActiveCategoryLevel2Filter() {
        Model model = Model.getInstance();
        Assert.assertTrue(model.getActiveLevel2Categories().isEmpty());
        model.addCategoryLevel2Filter("beer");
        Assert.assertTrue(model.getActiveLevel2Categories().contains("beer"));
    }

    @Test
    public void testRemoveCategoryLevel2Filter() {
        Model model = Model.getInstance();
        model.addCategoryLevel2Filter("beer");
        model.removeCategoryLevel2Filter("beer");
        model.removeCategoryLevel2Filter("skavlan");
        Assert.assertTrue(model.getActiveLevel2Categories().isEmpty());
    }

    @Test
    public void testGetFilteredProductsWithFilterString() {
        Model model = Model.getInstance();
        List<Product> emptyFilter = model.getFilteredProducts("");
        Assert.assertEquals(emptyFilter, model.getAllProducts()); // filtering by nothing should return everything
        Random rng = new Random(20211010);
        for(int i = 0; i < 100; i++) {
            int expected = rng.nextInt(20000);
            Product randomProduct = model.getAllProducts().get(expected);
            List<Product> randomFilter = model.getFilteredProducts(randomProduct.getProductNameBold());
            Assert.assertTrue(randomFilter.contains(randomProduct));
        }
    }
}
