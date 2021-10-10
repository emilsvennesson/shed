package shedbolaget.model.sorter;

import shedbolaget.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * The Sorter, used for sorting variables of different types in a list of Products.
 * @author samkaj
 */
public final class Sorter {
    /**
     * Sort a list of products based on properties of type double.
     *
     * @param functionToApply the function to apply
     * @param products        the list of products
     */
    public static void sortProductsDouble(Function<Product, Double> functionToApply, List<Product> products) {
        products.sort(Comparator.comparingDouble(functionToApply::apply));
    }

    /**
     * Sort a list of products based on properties of type boolean.
     *
     * @param functionToApply the function to apply
     * @param products        the list of products
     */
    public static void sortProductsBoolean(Function<Product, Boolean> functionToApply, List<Product> products) {
        products.sort(Comparator.comparing(functionToApply).reversed());
    }

    /**
     * Sort a list of products based on properties of type string in alphabetical order.
     *
     * @param functionToApply the function to apply
     * @param products        the list of products
     */
    public static void sortProductsString(Function<Product, String> functionToApply, List<Product> products) {
        products.sort(Comparator.comparing(functionToApply));
    }
}
