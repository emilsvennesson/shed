package shedbolaget.controllers;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.products.Filter;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.Products;

import java.io.IOException;
import java.util.List;

public class ProductsViewController {
    private final EventManager eventManager = EventManager.getInstance();

    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane contentFlowPane;

    private FlowPane productsWrapper;

    private List<Product> filteredProducts;

    @FXML
    public void initialize() throws IOException {
        initProductsWrapper();
        populateView();
        eventManager.registerToEventBus(this);
    }

    private void populateView() throws IOException {
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/SorterView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/BreadCrumbsView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/CategorySideBarView.fxml")).load());
        //navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        contentFlowPane.getChildren().add(productsWrapper);
    }

    private void loadProducts(List<Product> products) {
        productsWrapper.getChildren().clear();
        for (int i = 0; i < 50; i++) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/DetailedProductCardView.fxml"));
            cardLoader.setController(new DetailedProductCardController(products.get(i)));
            try {
                productsWrapper.getChildren().add(cardLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void initProductsWrapper() {
        productsWrapper = new FlowPane();
        productsWrapper.setVgap(8);
    }

    @Subscribe
    public void actOnCategoryEvent(CategoryEvent event) {
        Products productsHolder = Products.getInstance();
        filteredProducts = Filter.getFilteredProductsByCategory(productsHolder.getAllProducts(), event.getActiveCategories());
        if (!filteredProducts.isEmpty())
            loadProducts(filteredProducts);
    }

    @Subscribe
    public void actOnSortEvent(SortEvent event) {
        loadProducts(event.getSortedProductList());
        System.out.println("products view controller got a sorting event");
    }
}

