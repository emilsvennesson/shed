package shedbolaget.model;

import com.google.common.eventbus.EventBus;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.favorites.ProductIdListsIOManager;
import shedbolaget.model.favorites.SavableProductIdList;
import shedbolaget.model.parser.IProductParser;
import shedbolaget.model.parser.ParserFactory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static final Model instance = new Model();
    private final Filter filter;
    private final EventBus eventBus;
    private List<Product> products;
    private final ProductIdListsIOManager listIOManager;

    private Model() {
        populateProducts(ParserFactory.getJsonParser());
        filter = new Filter(getProducts());
        listIOManager = ProductIdListsIOManager.getInstance();
        eventBus = new EventBus();
        eventBus.register(this);
    }

    public List<String> getActiveCategoryLevel2Filters() {
        return filter.getActiveCategoryLevel2Filters();
    }

    public String getActiveCategoryLevel1Filter() {
        return filter.getActiveCategoryLevel1Filter();
    }

    public static Model getInstance() {
        return instance;
    }

    public void registerToEventBus(Object o) {
        eventBus.register(o);
    }

    public void unregisterFromEventBus(Object o) {
        eventBus.unregister(o);
    }

    public List<Product> getProducts() {
        return products.stream().collect(Collectors.toList());
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
     * <p>Adds a {@link Product} to favorites</p>
     *
     * @param prod the {@link Product} that is added
     */

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

    public void sortProductsByVariable(String variableName, boolean lowestToHighest) {
        filter.sortProductsByVariable(variableName, lowestToHighest);
    }

    public void sortProductsByVariable(String variableName) {
        filter.sortProductsByVariable(variableName, true);
    }

    public Product getProduct(int id) {
        return filter.getProduct(id);
    }

    public String getProductImageUrl(Product product, ImageSize imageSize) {
        String imageUrl;
        String size;
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
            imageUrl = product.getImages().get(0).getImageUrl();
        } catch (IndexOutOfBoundsException e) {
            return "https://i.ibb.co/LdVhq7m/skavlan.png";
        }

        return imageUrl + String.format("_%s.png", size);
    }

    public enum ImageSize {
        SMALL,
        MEDIUM,
        LARGE
    }


}
