package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class ProductsViewController {
    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane contentFlowPane;

    private CategorySideBarController sidebar;

    @FXML
    public void initialize() throws IOException {
        populateView();
    }

    private void populateView() throws IOException {
        navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/FilterView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/BreadCrumbsView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/CategorySideBarView.fxml")).load());
    }
}

