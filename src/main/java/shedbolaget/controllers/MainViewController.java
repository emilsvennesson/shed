package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.Pages;

import java.io.IOException;

public class MainViewController {
    @FXML
    private AnchorPane navBarPane;
    @FXML
    private FlowPane newProductsFlowPane;

    @FXML
    public void initialize() throws IOException {
        navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        /*
        for (Product p : productPages.getProductsFromPage(4)) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/BasicProductCardView.fxml"));
            cardLoader.setController(new BasicProductCardController(p));
            newProductsFlowPane.getChildren().add(cardLoader.load());
        }
        
         */
    }
}
