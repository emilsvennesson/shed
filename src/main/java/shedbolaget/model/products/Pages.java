package shedbolaget.model.products;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of product pages.
 *
 * @author Emil Svensson, Pouya Shirin
 */
public class Pages {
    private final List<IProductsCollection> productPages;
    private final int productsLimitPerPage;
    private final int totalProducts;

    /**
     * Instantiates a Pages object with default page size set to 20.
     *
     * @param products the products list
     */
    public Pages(List<Product> products) {
        this.productsLimitPerPage = 20;  // default page size
        this.totalProducts = products.size();
        this.productPages = splitIntoPages(products);
    }

    /**
     * Instantiates a Pages object.
     *
     * @param products             the products list
     * @param productsLimitPerPage the number of products that should reside in each page
     */
    public Pages(List<Product> products, int productsLimitPerPage) {
        this.productsLimitPerPage = productsLimitPerPage;
        this.totalProducts = products.size();
        this.productPages = splitIntoPages(products);
    }

    /**
     * Gets the total number of products in all pages.
     *
     * @return the total number of products in all the pages
     */
    public int getTotalNumberOfProducts() {
        return totalProducts;
    }

    /**
     * Gets the products limit per page.
     *
     * @return the products limit per page
     */
    public int getProductsLimitPerPage() {
        return productsLimitPerPage;
    }

    private List<IProductsCollection> splitIntoPages(List<Product> products) {
        List<IProductsCollection> newProductPages = new ArrayList<>();
        for (List<Product> splitProducts : Lists.partition(products, productsLimitPerPage))
            newProductPages.add(new ProductPage(splitProducts));
        return newProductPages;
    }

    /**
     * Gets the products from a specified page number.
     *
     * @param pageNumber the page number
     * @return the products from the specified page number
     */
    public List<Product> getProductsFromPage(int pageNumber) {
        return productPages.get(pageNumber - 1).getAllProducts();
    }

    /**
     * Gets the total number of pages.
     *
     * @return the total number of pages
     */
    public int getNumberOfPages() {
        return productPages.size();
    }

    /**
     * Gets the number of products in a page.
     *
     * @param pageNumber the page number
     * @return the number of products in the page
     */
    public int getNumberOfProducts(int pageNumber) {
        // TODO needs boundary checks
        return productPages.get(pageNumber - 1).getNumberOfProducts();
    }
}
