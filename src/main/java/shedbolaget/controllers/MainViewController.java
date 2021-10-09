package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.io.IOException;

public class MainViewController {
    @FXML
    private AnchorPane navBarPane;
    @FXML
    private FlowPane newProductsFlowPane;

    @FXML
    public void initialize() throws IOException {
        navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        Model model = Model.getInstance();
        model.sortProductsByVariable("apk", false);
        for (Product p : model.getNewProducts(20)) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/BasicProductCardView.fxml"));
            cardLoader.setController(new BasicProductCardController(p));
            newProductsFlowPane.getChildren().add(cardLoader.load());
        }
    }
}
