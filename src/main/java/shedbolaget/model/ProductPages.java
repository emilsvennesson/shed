package shedbolaget.model;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson, Pouya Shirin
 */
public class ProductPages {
    private final List<ProductPage> productPages;
    private final int productsPerPage;

    public ProductPages(List<Product> products) {
        this.productsPerPage = 20;  // default page size
        this.productPages = splitIntoPages(products);
    }

    public ProductPages(List<Product> products, int productsPerPage) {
        this.productsPerPage = productsPerPage;
        this.productPages = splitIntoPages(products);
    }

    private List<ProductPage> splitIntoPages(List<Product> products) {
        List<ProductPage> newProductPages = new ArrayList<>();
        for (List<Product> splitProducts : Lists.partition(products, productsPerPage))
            newProductPages.add(new ProductPage(splitProducts));
        return newProductPages;
    }

    public List<Product> getProductsFromPage(int pageNumber) {
        return productPages.get(pageNumber - 1).getProducts();
    }

    public int getNumberOfPages() {
        return productPages.size();
    }

    public int getNumberOfProducts(int pageNumber) {
        // TODO needs boundary checks
        return productPages.get(pageNumber - 1).getNumberOfProducts();
    }
}
