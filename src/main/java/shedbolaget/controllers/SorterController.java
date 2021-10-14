package shedbolaget.controllers;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.products.Filter;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.Products;
import shedbolaget.model.products.Sorter;

import java.util.List;
import java.util.ArrayList;

public class SorterController {

    @FXML
    private FlowPane filterFlowPane;

    @FXML
    private MenuItem sortByPriceMenuItem;

    @FXML
    private MenuItem sortByApkMenuItem;

    @FXML
    private MenuItem sortByNameMenuItem;

    @FXML
    private MenuButton sortMenuButton;

    private EventManager eventManager;

    private List<Category> activeCategories = new ArrayList<Category>();

    @FXML
    public void initialize() {
        eventManager = EventManager.getInstance();
        eventManager.registerToEventBus(this);
        sortMenuButton.setText("Pris");
    }

    @FXML
    void sortByPrice(ActionEvent event) {
        List<Product> prods = Sorter.getProductListSortedByPrice(Filter.getFilteredProductsByCategory(Products.getInstance().getAllProducts(), activeCategories));
        eventManager.fireEvent(new SortEvent(prods));
        sortMenuButton.setText("Pris");
    }

    @FXML
    void sortByApk(ActionEvent event) {
        List<Product> prods = Sorter.getProductListSortedByApk(Filter.getFilteredProductsByCategory(Products.getInstance().getAllProducts(), activeCategories));
        eventManager.fireEvent(new SortEvent(prods));
        sortMenuButton.setText("APK");
    }

    @FXML
    void sortByName(ActionEvent event) {
        // TODO: implement sort by name, right now sorting by APk...
        System.out.println("Sorting by apk instead of name, fix me");
        List<Product> prods = Sorter.getProductListSortedByApk(Filter.getFilteredProductsByCategory(Products.getInstance().getAllProducts(), activeCategories));
        eventManager.fireEvent(new SortEvent(prods));
        sortMenuButton.setText("Namn");
    }

    @Subscribe
    public void actOnCategoryEvent(CategoryEvent event) {
        System.out.println("acting on event from category");
        activeCategories = event.getActiveCategories();
    }

}