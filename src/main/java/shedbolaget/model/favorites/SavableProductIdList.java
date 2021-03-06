package shedbolaget.model.favorites;

import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Favorites.SavableProductList
 *
 * <p> Used as utility for the appropriate data to save a list of productIds</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
public class SavableProductIdList {
    private final String name;
    private final List<Integer> products;

    public SavableProductIdList(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    /**
     * <p>Adds a productId to the list, cannot add an already existing productId</p>
     *
     * @param productId, the productId of the product that is added
     */
    public void addProductId(int productId) {
        if (products.contains(productId))
            return;
        products.add(productId);
    }

    /**
     * <p>Adds a productId from the given {@link Product} to the list, cannot add an already existing productId</p>
     *
     * @param product, {@link Product}
     */
    public void addProductId(Product product) {
        if (products.contains(Integer.parseInt(product.getProductId())))
            return;
        products.add(Integer.parseInt(product.getProductId()));
    }

    /**
     * <p>Removes a productId taken from the given {@link Product} from the list</p>
     *
     * @param product, {@link Product} that is removed
     */
    public void removeProductId(Product product) {
        int removeId = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).toString().equals(product.getProductId()))
                removeId = i;
        }

        if (removeId != -1)
            products.remove(removeId);
    }

    /**
     * <p>Removes the given productId from the list</p>
     *
     * @param productId, productId of the product that is being removed
     */
    public void removeProductId(int productId) {
        int removeId = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == productId)
                removeId = i;
        }

        if (removeId != -1)
            products.remove(removeId);
    }

    /**
     * <p> Returns the name of the list</p>
     *
     * @return name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Gives the amount of productIds that is in the list</p>
     *
     * @return the amount of products as an int
     */
    public int getSize() {
        return this.products.size();
    }

    /**
     * <p>Gives a list of all the productIds from the SavableList</p>
     *
     * @return a generic List of the product ids
     */
    public List<Integer> getProductIds() {

        return new ArrayList<>(this.products);
    }

    public List<Product> getProducts() {
        List<Product> prods = new ArrayList<>();
        for (Integer id : products) {
            prods.add(ProductModel.getInstance().getProductsById(id).get(0));
        }
        return prods;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavableProductIdList that = (SavableProductIdList) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, products);
    }
}
