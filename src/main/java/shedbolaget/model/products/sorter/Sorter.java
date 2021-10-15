package shedbolaget.model.products.sorter;

import shedbolaget.model.products.Product;

import java.util.List;

/**
 * Façade for handling logic in ProductListSorter, in order to easily sort lists of products without specifying a Function as parameter.
 * @author Samuel Kajava
 */
public enum Sorter {
    ;

    public static List<Product> getProductListSortedByPrice(List<Product> productList) {
        return new ProductListSorter().getProductsSortedByDouble(Product::getPrice, productList);
    }

    public static List<Product> getProductListSortedByPrice(List<Product> productList, boolean reversed) {
        return new ProductListSorter().getProductsSortedByDouble(Product::getPrice, productList, reversed);
    }

    public static List<Product> getProductListSortedByApk(List<Product> productList) {
        return new ProductListSorter().getProductsSortedByDouble(Product::getApk, productList, true);
    }

    public static List<Product> getProductListSortedByApk(List<Product> productList, boolean reversed) {
        return new ProductListSorter().getProductsSortedByDouble(Product::getApk, productList, reversed);
    }

}
