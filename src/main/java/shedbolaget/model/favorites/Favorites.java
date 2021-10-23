package shedbolaget.model.favorites;

import shedbolaget.model.products.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade for using the favorites package.
 * @author Daniel Rygaard
 * @author Samuel Kajava
 */

public class Favorites {
    private final static Favorites instance = new Favorites();

    private Favorites() {
        onStartUp();
        Runtime.getRuntime().addShutdownHook(new Thread(this::onShutDown, "Shutdown-thread"));
    }

    public static Favorites getInstance() {
        return instance;
    }

    /**
     * Gets all favorite products
     *
     * @return a list of {@link Product}
     */
    public List<Product> getFavoriteProducts() {
        ProductIdListsIOManager listIOManager = ProductIdListsIOManager.getInstance();
        SavableProductIdList favList;
        try {
            listIOManager.addList(new SavableProductIdList("favorites"));
            favList = listIOManager.getList("favorites");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return favList.getProducts();
    }

    /**
     * Adds a Product to favorites
     * @param product the Product that will be added
     */
    public void addToFavorites(Product product) {
        ProductIdListsIOManager listIOManager = ProductIdListsIOManager.getInstance();
        SavableProductIdList favList = listIOManager.getList("favorites");
        if(favList == null) return;
        try {
            listIOManager.addList(new SavableProductIdList("favorites"));
            favList.addProductId(product);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Removes a {@link Product} from favorites</p>
     *
     * @param product the {@link Product} that will be removed
     */
    public void removeFromFavorites(Product product) {
        ProductIdListsIOManager listIOManager = ProductIdListsIOManager.getInstance();
        SavableProductIdList favList = listIOManager.getList("favorites");
        try {
            listIOManager.addList(new SavableProductIdList("favorites"));
            favList.removeProductId(product);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Removes all the products from favorites
     */
    public void clearFavorites() {
        ProductIdListsIOManager listIOManager = ProductIdListsIOManager.getInstance();
        listIOManager.removeList("favorites");
    }

    /**
     * Returns whether a Product is marked as favorite or not
     * @param product the product which is searched for within the favorites list
     * @return true if it is a favorite, false if not
     */
    public boolean isFavorite(Product product) {
        return getFavoriteProducts().contains(product);
    }

    private void onShutDown() {
        ProductIdListsIOManager listIOManager = ProductIdListsIOManager.getInstance();
        listIOManager.saveAllLists();
    }

    private void onStartUp() {
        ProductIdListsIOManager listIOManager = ProductIdListsIOManager.getInstance();
        listIOManager.loadAllLists();
    }
}
