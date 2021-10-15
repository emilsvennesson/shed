package shedbolaget.model;

import com.google.common.eventbus.EventBus;
import shedbolaget.model.categories.CategoriesHandler;
import shedbolaget.model.categories.Category;
import shedbolaget.model.categories.CategoryProductFilter;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.favorites.ProductIdListsIOManager;
import shedbolaget.model.favorites.SavableProductIdList;
import shedbolaget.model.parser.IProductParser;
import shedbolaget.model.parser.ParserFactory;
import shedbolaget.model.sorter.Sorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Model {
    private static final Model instance = new Model();
    private final EventBus eventBus;
    private final ProductIdListsIOManager listIOManager;
    private final List<Category> activeCategories = new ArrayList<>();
    HashMap<Category, List<Category>> categories;
    private List<Product> products;

    private Model() {
        populateProducts(ParserFactory.getJsonParser());
        listIOManager = ProductIdListsIOManager.getInstance();
        eventBus = new EventBus();
        categories = CategoriesHandler.getCategories(getAllProducts());
        onStartUp();
        addShutdownHook();
    }

    public static Model getInstance() {
        return instance;
    }

    public List<Category> getActiveCategories() {
        return activeCategories;
    }

    public void addToActiveCategories(Category category) {
        activeCategories.add(category);
        eventBus.post(new CategoryEvent(getActiveCategories()));
    }

    public void removeFromActiveCategories(Category category) {
        activeCategories.remove(category);
        eventBus.post(new CategoryEvent(getActiveCategories()));
    }

    public void clearActiveCategories() {
        activeCategories.clear();
        eventBus.post(new CategoryEvent(getActiveCategories()));
    }

    /**
     * Gets all available categories.
     *
     * @return the categories in which each key has its associated subcategories as value
     */
    public HashMap<Category, List<Category>> getCategories() {
        return categories;
    }

    public List<Category> getActiveCategories(int level) {
        return CategoriesHandler.getCategories(getActiveCategories(), level);
    }

    public List<Category> getSubCategories(Category category) {
        return CategoriesHandler.getCategoriesLevel2(getAllProducts(), category);
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::onShutDown, "Shutdown-thread"));
    }

    public void registerToEventBus(Object o) {
        eventBus.register(o);
    }

    public void unregisterFromEventBus(Object o) {
        eventBus.unregister(o);
    }

    public List<Product> getAllProducts() {
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
     * Gets all favorite products
     *
     * @return a list of {@link Product}
     */
    public List<Product> getFavoritesAsProducts() {


        SavableProductIdList favList = listIOManager.getList("Favorites");
        if (favList == null) {
            listIOManager.addList(new SavableProductIdList("Favorites"));
            favList = listIOManager.getList("Favorites");
        }
        return favList.getProducts();
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

    public List<Product> getFilteredProducts(List<Product> products, List<Category> categories) {
        return CategoryProductFilter.getFilteredProducts(products, categories);
    }

    public List<Product> getProducts(int productId) {
        return getAllProducts().stream().filter(product -> Objects.equals(product.getProductId(), Integer.toString(productId))).collect(Collectors.toList());
    }

    /**
     * Gets a given amount of products and returns them as an ArrayList
     *
     * @param amount the amount of wanted products
     */
    public List<Product> getNewProducts(int amount) {
        Sorter.getProductListSortedByApk(products);
        return products.subList(0, amount);
    }

    /**
     * Returns whether a product is marked as favorite or not
     *
     * @param product a product
     */
    public boolean isFavorite(Product product) {
        return (getFavoritesAsProducts().contains(product));
    }

    public void sortByPrice() {
        List<Product> sortedProducts = Sorter.getProductListSortedByPrice(getFilteredProducts(products, getActiveCategories()));
        eventBus.post(new SortEvent(sortedProducts));
    }

    public void sortByApk() {
        List<Product> sortedProducts = Sorter.getProductListSortedByApk(getFilteredProducts(products, getActiveCategories()));
        eventBus.post(new SortEvent(sortedProducts));
    }

    public void sortByName() {
        System.out.println("Now calling sortedByApk(), replace with sortedByName() when implemented");
        List<Product> sortedProducts = Sorter.getProductListSortedByApk(getFilteredProducts(products, getActiveCategories()));
        eventBus.post(new SortEvent(sortedProducts));
    }

}
