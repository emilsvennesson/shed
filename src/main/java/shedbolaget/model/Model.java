package shedbolaget.model;

import com.google.common.eventbus.EventBus;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.favorites.ProductIdListsIOManager;
import shedbolaget.model.favorites.SavableProductIdList;
import shedbolaget.model.filter.Filter;
import shedbolaget.model.parser.IProductParser;
import shedbolaget.model.parser.ParserFactory;
import shedbolaget.model.sorter.Sorter;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model {
    private static final Model instance = new Model();
    private final Filter filter;
    private final EventBus eventBus;
    private final ProductIdListsIOManager listIOManager;
    private List<Product> products;

    private Model() {
        populateProducts(ParserFactory.getJsonParser());
        filter = new Filter(getProducts());
        listIOManager = ProductIdListsIOManager.getInstance();
        eventBus = new EventBus();
        onStartUp();
        addShutdownHook();
    }

    public static Model getInstance() {
        return instance;
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::onShutDown, "Shutdown-thread"));
    }

    public List<String> getActiveCategoryLevel2Filters() {
        return filter.getActiveCategoryLevel2Filters();
    }

    public String getActiveCategoryLevel1Filter() {
        return filter.getActiveCategoryLevel1Filter();
    }

    public void registerToEventBus(Object o) {
        eventBus.register(o);
    }

    public void unregisterFromEventBus(Object o) {
        eventBus.unregister(o);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    private void populateProducts(IProductParser parser) {
        products = parser.getProducts();
    }

    public void addToFavorites(Product prod) {
        SavableProductIdList favList = listIOManager.getList("Favorites");
        if (favList == null) {
            listIOManager.addList(new SavableProductIdList("Favorites"));
            favList = listIOManager.getList("Favorites");
        }
        favList.addProductId(prod);
    }

    /**
     * <p>Removes a {@link Product} from favorites</p>
     *
     * @param prod the {@link Product} that will be removed
     */
    public void removeFromFavorites(Product prod) {
        SavableProductIdList favList = listIOManager.getList("Favorites");
        if (favList == null) listIOManager.addList(new SavableProductIdList("Favorites"));
        favList.removeProductId(prod);
    }

    /**
     * Returns all the {@link Product} ids from Favorites
     *
     * @return {@link Product} ids as an {@link List} of {@link Integer}s
     */
    public List<Integer> getProductIdsFromFavorites() {
        //TODO Fix so that this return product
        SavableProductIdList favList = listIOManager.getList("Favorites");
        if (favList == null) {
            listIOManager.addList(new SavableProductIdList("Favorites"));
            favList = listIOManager.getList("Favorites");
        }
        return favList.getProductIds();
    }

    /**
     * Gets all favorite products
     *
     * @return a list of {@link Product}
     */
    public List<Product> getFavoritesAsProducts() {
        ArrayList<Product> products = new ArrayList<>();
        for (Integer id : getProductIdsFromFavorites()) {
            List<Product> productsFromId = getProducts(id);
            products.addAll(productsFromId);
        }
        return products;
    }

    /**
     * Removes all the products from favorites
     */
    public void clearFavorites() {
        listIOManager.removeList("Favorites");
    }

    public void onStartUp() {
        listIOManager.loadAllLists();
    }

    public void onShutDown() {
        listIOManager.saveAllLists();
    }

    public int getSize() {
        return this.products.size();
    }

    public void clearAllFilters() {
        filter.clearAllFilters();
    }

    public void setCategoryLevel1Filter(String categoryName) {
        filter.setCategoryLevel1Filter(categoryName);
        eventBus.post(new CategoryEvent());
    }

    public void clearCategoryLevel1Filter() {
        filter.clearCategoryLevel1Filter();
        eventBus.post(new CategoryEvent());
    }

    public void addCategoryLevel2Filter(String categoryName) {
        filter.addCategoryLevel2Filter(categoryName);
        eventBus.post(new CategoryEvent());
    }

    public HashMap<String, List<String>> getCategories() {
        return filter.getCategories();
    }

    public void removeCategoryLevel2Filter(String categoryName) {
        filter.removeCategoryLevel2Filter(categoryName);
        eventBus.post(new CategoryEvent());
    }

    public void clearCategoryLevel2Filters() {
        filter.clearCategoryLevel2Filters();
        eventBus.post(new CategoryEvent());
    }

    public List<Product> getFilteredProducts() {
        return filter.getFilteredProducts();
    }

    public List<Product> getFilteredProducts(String filterString) {
        return filter.getFilteredProducts(filterString);
    }

    /**
     * Sort products double values.
     *
     * @param doubleFunction the double function to compare by
     */
    public void sortProductsDouble(Function<Product, Double> doubleFunction) {
        Sorter.sortProductsDouble(doubleFunction, this.products);
    }

    /**
     * Sort products by boolean values.
     *
     * @param booleanFunction the boolean function to compare by
     */
    public void sortProductsBoolean(Function<Product, Boolean> booleanFunction) {
        Sorter.sortProductsBoolean(booleanFunction, this.products);
    }

    /**
     * Sort products string values.
     *
     * @param stringFunction the string function to compare by
     */
    public void sortProductsString(Function<Product, String> stringFunction) {
        Sorter.sortProductsString(stringFunction, this.products);
    }

    public List<Product> getProducts(int id) {
        return filter.getProducts(id);
    }

    public List<Product> getProducts(String filterString) {
        return filter.getProducts(filterString);
    }

    public String getActiveLevel1Category() {
        return filter.getActiveLevel1Category();
    }

    public ArrayList<String> getActiveLevel2Categories() {
        return filter.getActiveLevel2Categories();
    }

    public String getProductImageUrl(Product product, ImageSize imageSize) {
        String imageUrl;
        String size;
        String productId;
        switch (imageSize) {
            case SMALL:
                size = "20";
                break;
            case MEDIUM:
                size = "100";
                break;
            case LARGE:
                size = "200";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + imageSize);
        }

        try {
            imageUrl = product.getImages().get(0).getImageUrl() + String.format("_%s.png", size);
        } catch (IndexOutOfBoundsException e) {
            //fallback, some products do not have an image in json even though it exists on cdn
            productId = product.getProductId();
            imageUrl = String.format("https://product-cdn.systembolaget.se/productimages/%s/%s_%s.png", productId, productId, size);
        }
        return imageUrl;
    }

    /**
     * Gets a given amount of products and returns them as an ArrayList
     *
     * @param amount    the amount of wanted products
     */
    public List<Product> getNewProducts(int amount) {
        sortProductsBoolean(Product::isNews);
        return products.subList(0,amount);
    }

    /**
     * Returns whether a product is marked as favorite or not
     *
     * @param product a product
     */
    public boolean isFavorite(Product product) {
        return (getFavoritesAsProducts().contains(product));
    }

    public enum ImageSize {
        SMALL,
        MEDIUM,
        LARGE
    }
}
