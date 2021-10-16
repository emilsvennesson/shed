package shedbolaget.model.products.filter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductsHolder;

import java.util.ArrayList;
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
        List<Product> products = new ArrayList<>();
        List<Product> allProducts = ProductsHolder.getInstance().getAllProducts();
        products.add(allProducts.get(0));
        products.add(allProducts.get(10000));
        products.add(allProducts.get(20000));
        products.add(allProducts.get(22000));
        products.add(allProducts.get(7777));
        products.add(allProducts.get(15000));

        for (Product p : products) {
            System.out.println(p.getCategoryLevel3().getName());
        }
        System.out.println();
        List<Product> pTest = ProductsSearch.searchByCategory(products, "mörk ale");
        for (Product p : pTest) {
            System.out.println(p.getCategoryLevel3().getName());
        }
    }


}
