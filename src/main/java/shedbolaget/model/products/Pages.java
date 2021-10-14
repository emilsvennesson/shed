package shedbolaget.model.products;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson, Pouya Shirin
 */
public class Pages {
    private final List<IProductsCollection> productPages;
    private final int productsPerPage;
    private final int totalProducts;

    public Pages(List<Product> products) {
        this.productsPerPage = 20;  // default page size
        this.totalProducts = products.size();
        this.productPages = splitIntoPages(products);
    }

    public int getTotalNumberOfProducts() {
        return totalProducts;
    }

    public Pages(List<Product> products, int productsPerPage) {
        this.productsPerPage = productsPerPage;
        this.totalProducts = products.size();
        this.productPages = splitIntoPages(products);
    }

    public int getProductsPerPage() {
        return productsPerPage;
    }

    private List<IProductsCollection> splitIntoPages(List<Product> products) {
        List<IProductsCollection> newProductPages = new ArrayList<>();
        for (List<Product> splitProducts : Lists.partition(products, productsPerPage))
            newProductPages.add(new ProductPage(splitProducts));
        return newProductPages;
    }

    public List<Product> getProductsFromPage(int pageNumber) {
        return productPages.get(pageNumber - 1).getAllProducts();
    }

    public int getNumberOfPages() {
        return productPages.size();
    }

    public int getNumberOfProducts(int pageNumber) {
        // TODO needs boundary checks
        return productPages.get(pageNumber - 1).getNumberOfProducts();
    }
}
