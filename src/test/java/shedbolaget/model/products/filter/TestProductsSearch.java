package shedbolaget.model.products.filter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

/**
 * The type Test fuzzy wuzzy.
 */
public class TestProductsSearch {
    @Test
    public void testSearchByCategory() {
        for (Product p : ProductsSearch.searchByCategory(ProductModel.getInstance().getProducts(), "Tequila", 100))
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Tequila");
        for (Product p : ProductsSearch.searchByCategory(ProductModel.getInstance().getProducts(), "tequila", 93)) {
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Tequila");
        }
    }

    @Test
    public void testSearchByName() {
        for (Product p : ProductsSearch.searchByName(ProductModel.getInstance().getProducts(), "Arboga 10,2", 100)) {
            Assert.assertEquals(p.getFullProductName(), "Arboga 10,2");
        }
    }

    @Test
    public void testSearch() {
        for (Product p : ProductsSearch.search(ProductModel.getInstance().getProducts(), "Fruktigt & Smakrikt vin", 100)) {
            Assert.assertEquals(p.getCategoryLevel3().getName(), "Fruktigt & Smakrikt vin");
        }
        for (Product p : ProductsSearch.search(ProductModel.getInstance().getProducts(), "Arboga 10,2", 100)) {
            Assert.assertEquals(p.getFullProductName(), "Arboga 10,2");
        }

    }
}
