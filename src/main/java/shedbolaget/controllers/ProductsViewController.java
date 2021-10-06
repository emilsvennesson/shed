package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.Model;

import java.io.IOException;

public class ProductsViewController {
    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane contentFlowPane;

    private FlowPane productsWrapper;

    private CategorySideBarController sidebar;

    @FXML
    public void initialize() throws IOException {
        initProductsWrapper();
        populateView();
    }

    private void populateView() throws IOException {
        navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/FilterView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/BreadCrumbsView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/CategorySideBarView.fxml")).load());
        contentFlowPane.getChildren().add(productsWrapper);
        for (int i = 0; i < 20; i++) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/DetailedProductCardView.fxml"));
            cardLoader.setController(new DetailedProductCardController(Model.getInstance().getProducts().get(i)));
            productsWrapper.getChildren().add(cardLoader.load());
        }
    }

    private void initProductsWrapper() {
        productsWrapper = new FlowPane();
        productsWrapper.setVgap(8);
    }
}

