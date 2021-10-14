package shedbolaget.model.sorter;

import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.util.*;
import java.util.function.Function;

/**
 * The Sorter, used for sorting variables of different types in a list of Products.
 * @author samkaj
 */
class ProductListSorter {

    /**
     * Sort a list based on a given parameter and return the sorted version.
     * @param sortingParameter  function that returns a double which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @return the sorted result of the original list as a new list
     */
    public static List<Product> getProductsSortedByDouble(Function<Product, Double> sortingParameter, List<Product> productListToSort) {
        List<Product> sortedList = new ArrayList<>(productListToSort);
        sortedList.sort(Comparator.comparingDouble(sortingParameter::apply));
        return sortedList;
    }

    /**
     * Sort a list based on a given parameter and return the sorted version.
     * @param sortingParameter  function that returns a double which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @param reversed          boolean which determines if the returned list should be in reverse order or not
     * @return the sorted result of the original list as a new list
     */
    public static List<Product> getProductsSortedByDouble(Function<Product, Double> sortingParameter, List<Product> productListToSort, boolean reversed) {
        List<Product> sortedList = getProductsSortedByDouble(sortingParameter, productListToSort);
        if(reversed)
            Collections.reverse(sortedList);
        return sortedList;
    }

    /**
     * Sort a list based on a given parameter and return the sorted version.
     * @param sortingParameter  function that returns a boolean which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @return the sorted result of the original list as a new list where True values are first
     */
    public static List<Product> getProductsSortedByBoolean(Function<Product, Boolean> sortingParameter, List<Product> productListToSort) {
        List<Product> sortedList = new ArrayList<>(productListToSort);
        sortedList.sort(Comparator.comparing(sortingParameter));
        Collections.reverse(sortedList); // sort by true first
        return sortedList;
    }

    /**
     * Sort a list based on a given parameter and return the sorted version.
     * @param sortingParameter  function that returns a boolean which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @param reversed          boolean which determines if the returned list should be in reverse order or not
     * @return the sorted result of the original list as a new list
     */
    public static List<Product> getProductsSortedByBoolean(Function<Product, Boolean> sortingParameter, List<Product> productListToSort, boolean reversed) {
        List<Product> sortedList = getProductsSortedByBoolean(sortingParameter, productListToSort);
        if(reversed)
            Collections.reverse(sortedList);
        return sortedList;
    }

    /**
     * Sort a list based on a given parameter and return the sorted version.
     * @param sortingParameter  function that returns a String which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @return the sorted result of the original list as a new list
     */
    public static List<Product> getProductsSortedByString(Function<Product, String> sortingParameter, List<Product> productListToSort) {
        List<Product> sortedList = new ArrayList<>(productListToSort);
        sortedList.sort(Comparator.comparing(sortingParameter));
        return sortedList;
    }

    /**
     * Sort a list based on a given parameter and return the sorted version.
     * @param sortingParameter  function that returns a String which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @param reversed          boolean which determines if the returned list should be in reverse order or not
     * @return the sorted result of the original list as a new list
     */
    public static List<Product> getProductsSortedByString(Function<Product, String> sortingParameter, List<Product> productListToSort, boolean reversed) {
        List<Product> sortedList = getProductsSortedByString(sortingParameter, productListToSort);
        if(reversed)
            Collections.reverse(sortedList);
        return sortedList;
    }
}
