package shedbolaget.model.sorter;

import shedbolaget.model.Product;

import java.util.List;

/**
 * Façade for handling logic in ProductListSorter, in order to easily sort lists of products without specifying a Function as parameter.
 * @author Samuel Kajava
 */
public class Sorter {
    private Sorter() {
    }


    public static List<Product> getProductListSortedByPrice(List<Product> productList) {
        return ProductListSorter.getProductsSortedByDouble(Product::getPrice, productList);
    }

    public static List<Product> getProductListSortedByPrice(List<Product> productList, boolean reversed) {
        return ProductListSorter.getProductsSortedByDouble(Product::getPrice, productList, reversed);
    }

    public static List<Product> getProductListSortedByApk(List<Product> productList) {
        return ProductListSorter.getProductsSortedByDouble(Product::getApk, productList);
    }

    public static List<Product> getProductListSortedByApk(List<Product> productList, boolean reversed) {
        return ProductListSorter.getProductsSortedByDouble(Product::getApk, productList, reversed);
    }

}
