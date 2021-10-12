package shedbolaget.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson, Pouya Shirin
 */
public class Pages {
    private final List<ProductPage> productPages;

    public Pages(List<Product> products) {
        productPages = splitIntoPages(products);
    }

    private List<ProductPage> splitIntoPages(List<Product> products) {
        List<ProductPage> newProductPages = new ArrayList<>();
        List<List<Product>> test = chopped(products, 20);
        for (List<Product> splitProducts : test)
            newProductPages.add(new ProductPage(splitProducts));

        return newProductPages;
    }

    // chops a list into non-view sublists of length L
    static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }

    public ProductPage getPage(int pageNumber) {
        return productPages.get(pageNumber - 1);
    }

    public int getNumberOfPages() {
        return productPages.size();
    }
}
