package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import shedbolaget.controllers.components.ComponentFactory;

public class RootWindow {

    @FXML
    private AnchorPane navBarPane;

    @FXML
    private AnchorPane contentWrapperAnchorPane;
    AnchorPane navBar = ComponentFactory.createNavBar();
    AnchorPane productsPage = ComponentFactory.createProductsPage();
    AnchorPane mainPage = ComponentFactory.createMainPage();

    @FXML
    public void initialize() {
        this.navBarPane.getChildren().add(navBar);
        this.contentWrapperAnchorPane.getChildren().add(productsPage);
    }
}
