package shedbolaget.model.products.filter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductsHolder;

import java.util.List;
import java.util.function.Function;

/**
 * The type Test fuzzy wuzzy.
 */
public class TestFuzzyWuzzy {

    /**
     * Test search.
     */
    @Test
    public void TestSearch() {

    }

    /**
     * Test extract from method.
     */
    @Test
    public void testExtractFromMethod() {
        List<Product> products = ProductsHolder.getInstance().getAllProducts();
        Function<Product, String> stringFunction = Product::getFullProductName;
        List<String> names = ProductsSearch.extractFromMethod(stringFunction, products);
        for (int i = 0; i < products.size(); i++)
            Assert.assertEquals(names.get(i), products.get(i).getFullProductName());

    }

    /**
     * Test stuff.
     */
    @Test
    public void testStuff() {
        List<Product> products = ProductsHolder.getInstance().getAllProducts().stream().limit(5).toList();
        for (Product p : products) {
            System.out.println(p.getCategoryLevel1().getName());
            System.out.println(p.getCategoryLevel2().getName());
            System.out.println(p.getCategoryLevel3().getName());
            System.out.println();
        }
    }

}
