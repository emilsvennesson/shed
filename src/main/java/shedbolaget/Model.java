package shedbolaget;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import shedbolaget.backend.DataHandler;
import shedbolaget.backend.Product;
import shedbolaget.events.CategoryEvent;
import shedbolaget.events.EventBusFactory;

import java.util.List;

public class Model {
    private static final Model instance = new Model();
    private final DataHandler dh;
    private final EventBus eventBus = EventBusFactory.getEventBus();

    private Model() {
        this.dh = new DataHandler();
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

    public void setCategoryLevel1Filter(String categoryName) {
        dh.setCategoryLevel1Filter(categoryName);
        eventBus.post(new CategoryEvent(categoryName));
    }

    public void clearCategoryLevel1Filter() {
        dh.clearCategoryLevel1Filter();
        eventBus.post(new CategoryEvent(""));
    }

    public void addToFavorites(Product p) {
        dh.addToFavorites(p);
    }

    public void removeFromFavorites(Product p) {
        dh.removeFromFavorites(p);
    }

    public void clearFavorites() {
        dh.clearFavorites();
    }

    public void addCategoryLevel2Filter(String categoryName) {
        dh.addCategoryLevel2Filter(categoryName);
    }

    public void removeCategoryLevel2Filter(String categoryName) {
        dh.removeCategoryLevel2Filter(categoryName);
    }

    public void clearCategoryLevel2Filters() {
        dh.clearCategoryLevel2Filters();
    }

    public List<Product> getFilteredProducts() {
        return dh.getFilteredProducts();
    }
}
