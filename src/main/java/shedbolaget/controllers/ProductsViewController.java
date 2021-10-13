package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.io.IOException;
import java.util.List;

public class ProductsViewController {
    private final Model model = Model.getInstance();

    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane contentFlowPane;

    private FlowPane productsWrapper;

    private List<Product> filteredProducts;

    @FXML
    public void initialize() throws IOException {
        this.filteredProducts = model.getFilteredProducts(model.getAllProducts(), model.getActiveCategories());
        initProductsWrapper();
        populateView();
        model.registerToEventBus(this);
        loadProducts();
    }

    private void populateView() throws IOException {
        navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/FilterView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/BreadCrumbsView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/CategorySideBarView.fxml")).load());
        contentFlowPane.getChildren().add(productsWrapper);
    }

    private void loadProducts() throws IOException {
        productsWrapper.getChildren().clear();
        for (int i = 0; i < 20; i++) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/DetailedProductCardView.fxml"));
            cardLoader.setController(new DetailedProductCardController(filteredProducts.get(i)));
            productsWrapper.getChildren().add(cardLoader.load());
        }

    }

    private void initProductsWrapper() {
        productsWrapper = new FlowPane();
        productsWrapper.setVgap(8);
    }
}

