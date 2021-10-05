package shedbolaget.model;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.favorites.ProductIdListsIOManager;
import shedbolaget.model.favorites.SavableProductIdList;
import shedbolaget.model.parser.IProductParser;
import shedbolaget.model.parser.ParserFactory;

import java.util.List;

public class Model {
    private static final Model instance = new Model();
    private List<Product> products;
    private ProductIdListsIOManager listIOManager;
    private final Filter filter;
    private final EventBus eventBus;

    private Model() {
        populateProducts(ParserFactory.getJsonParser());
        filter = new Filter(getProducts());
        listIOManager = ProductIdListsIOManager.getInstance();
        eventBus = new EventBus();
        eventBus.register(this);
    }

    public static Model getInstance() {
        return instance;
    }

    @Subscribe
    public void listen(CategoryEvent event) {
        System.out.println("test");
        System.out.println(event.getCurrentCategoryLevel1());
    }

    public void registerToEventBus(Object o) {
        eventBus.register(o);
    }

    public void unregisterFromEventBus(Object o) {
        eventBus.unregister(o);
    }

    public List<Product> getProducts() {
        return products;
    }

    private void populateProducts(IProductParser parser) {
        products = parser.getProducts();
    }

    /**
     * <p>Adds a {@link Product} to favorites</p>
     *
     * @param prod the {@link Product} that is added
     */
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

    public void setCategoryLevel1Filter(String categoryName) {
        filter.setCategoryLevel1Filter(categoryName);
        eventBus.post(new CategoryEvent(categoryName));
    }

    public void clearCategoryLevel1Filter() {
        filter.clearCategoryLevel1Filter();
        eventBus.post(new CategoryEvent(""));
    }

    public void addCategoryLevel2Filter(String categoryName) {
        filter.addCategoryLevel2Filter(categoryName);
    }

    public void removeCategoryLevel2Filter(String categoryName) {
        filter.removeCategoryLevel2Filter(categoryName);
    }

    public void clearCategoryLevel2Filters() {
        filter.clearCategoryLevel2Filters();
    }

    public List<Product> getFilteredProducts() {
        return filter.getFilteredProducts();
    }
}
