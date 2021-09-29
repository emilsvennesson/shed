package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class ProductsViewController {
    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane contentFlowPane;

    private CategorySideBarController sidebar;

    @FXML
    public void initialize() {
        navBarPane.getChildren().add(new NavBarController());
        sidebar = new CategorySideBarController();
        populateView();
    }

    private void populateView() {
        contentFlowPane.getChildren().add(sidebar);
    }
}
