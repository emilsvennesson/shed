package shedbolaget.controllers;

import shedbolaget.backend.DataHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class MainViewController {
    @FXML
    private AnchorPane navBarPane;
    @FXML
    private FlowPane newProductsFlowPane;

    @FXML
    public void initialize() {
        navBarPane.getChildren().add(new NavBarController());
        DataHandler dh = new DataHandler();
        for (int i = 0; i < 20; i++)
            newProductsFlowPane.getChildren().add(new BasicProductCardController(dh.getFilteredProducts().get(i)));

    }
}
