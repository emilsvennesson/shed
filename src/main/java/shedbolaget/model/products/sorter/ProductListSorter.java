package shedbolaget.model.products.sorter;

import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * The Sorter, used for sorting variables of different types in a list of Products.
 *
 * @author Samuel Kajava
 * @see Product
 */
class ProductListSorter implements IProductsSorter {
    @Override
    public List<Product> getProductsSortedByDouble(Function<Product, Double> sortingParameter, List<Product> productListToSort) {
        List<Product> sortedList = new ArrayList<>(productListToSort);
        sortedList.sort(Comparator.comparingDouble(sortingParameter::apply));
        return sortedList;
    }

    @Override
    public List<Product> getProductsSortedByDouble(Function<Product, Double> sortingParameter, List<Product> productListToSort, boolean reversed) {
        List<Product> sortedList = getProductsSortedByDouble(sortingParameter, productListToSort);
        if (reversed)
            Collections.reverse(sortedList);
        return sortedList;
    }

    @Override
    public List<Product> getProductsSortedByBoolean(Function<Product, Boolean> sortingParameter, List<Product> productListToSort) {
        List<Product> sortedList = new ArrayList<>(productListToSort);
        sortedList.sort(Comparator.comparing(sortingParameter));
        Collections.reverse(sortedList); // sort by true first
        return sortedList;
    }

    @Override
    public List<Product> getProductsSortedByBoolean(Function<Product, Boolean> sortingParameter, List<Product> productListToSort, boolean reversed) {
        List<Product> sortedList = getProductsSortedByBoolean(sortingParameter, productListToSort);
        if (reversed)
            Collections.reverse(sortedList);
        return sortedList;
    }

    @Override
    public List<Product> getProductsSortedByString(Function<Product, String> sortingParameter, List<Product> productListToSort) {
        List<Product> sortedList = new ArrayList<>(productListToSort);
        sortedList.sort(Comparator.comparing(sortingParameter));
        return sortedList;
    }

    @Override
    public List<Product> getProductsSortedByString(Function<Product, String> sortingParameter, List<Product> productListToSort, boolean reversed) {
        List<Product> sortedList = getProductsSortedByString(sortingParameter, productListToSort);
        if (reversed)
            Collections.reverse(sortedList);
        return sortedList;
    }
}
