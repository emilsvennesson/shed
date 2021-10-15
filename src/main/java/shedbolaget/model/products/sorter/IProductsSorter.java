package shedbolaget.model.products.sorter;

import shedbolaget.model.products.Product;

import java.util.List;
import java.util.function.Function;

interface IProductsSorter {
    /**
     * Sort a list based on a given parameter and return the sorted version.
     *
     * @param sortingParameter  function that returns a double which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @return the sorted result of the original list as a new list
     */
    List<Product> getProductsSortedByDouble(Function<Product, Double> sortingParameter, List<Product> productListToSort);

    /**
     * Sort a list based on a given parameter and return the sorted version.
     *
     * @param sortingParameter  function that returns a double which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @param reversed          boolean which determines if the returned list should be in reverse order or not
     * @return the sorted result of the original list as a new list
     */
    List<Product> getProductsSortedByDouble(Function<Product, Double> sortingParameter, List<Product> productListToSort, boolean reversed);

    /**
     * Sort a list based on a given parameter and return the sorted version.
     *
     * @param sortingParameter  function that returns a boolean which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @return the sorted result of the original list as a new list where True values are first
     */
    List<Product> getProductsSortedByBoolean(Function<Product, Boolean> sortingParameter, List<Product> productListToSort);

    /**
     * Sort a list based on a given parameter and return the sorted version.
     *
     * @param sortingParameter  function that returns a boolean which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @param reversed          boolean which determines if the returned list should be in reverse order or not
     * @return the sorted result of the original list as a new list
     */
    List<Product> getProductsSortedByBoolean(Function<Product, Boolean> sortingParameter, List<Product> productListToSort, boolean reversed);

    /**
     * Sort a list based on a given parameter and return the sorted version.
     *
     * @param sortingParameter  function that returns a String which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @return the sorted result of the original list as a new list
     */
    List<Product> getProductsSortedByString(Function<Product, String> sortingParameter, List<Product> productListToSort);

    /**
     * Sort a list based on a given parameter and return the sorted version.
     *
     * @param sortingParameter  function that returns a String which the sorting will be based upon, i.e. a getter.
     * @param productListToSort the list of products to sort
     * @param reversed          boolean which determines if the returned list should be in reverse order or not
     * @return the sorted result of the original list as a new list
     */
    List<Product> getProductsSortedByString(Function<Product, String> sortingParameter, List<Product> productListToSort, boolean reversed);
}

