package shedbolaget.model.favorites;

import shedbolaget.model.Product;

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

    public Favorites getInstance() {
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
            listIOManager.addList(new SavableProductIdList("Favorites"));
            favList = listIOManager.getList("Favorites");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return favList.getProducts();
    }

    public void addToFavorites(Product product) {
        ProductIdListsIOManager listIOManager = ProductIdListsIOManager.getInstance();
        SavableProductIdList favList = listIOManager.getList("Favorites");
        try {
            listIOManager.addList(new SavableProductIdList("Favorites"));
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
        SavableProductIdList favList = listIOManager.getList("Favorites");
        try {
            listIOManager.addList(new SavableProductIdList("Favorites"));
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
        listIOManager.removeList("Favorites");
    }

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
