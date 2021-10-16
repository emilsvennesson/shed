package shedbolaget.model.products.filter;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductsHolder;

import java.util.List;
import java.util.function.Function;

public class TestFuzzyWuzzy {

    @Test
    public void TestSearch() {

    }

    @Test
    public void testExtractFromMethod() {
        List<Product> products = ProductsHolder.getInstance().getAllProducts();
        Function<Product, String> stringFunction = Product::getFullProductName;
        List<String> names = ProductsSearch.extractFromMethod(stringFunction, products);
        for (int i = 0; i < products.size(); i++)
            Assert.assertEquals(names.get(i), products.get(i).getFullProductName());

    }

}
