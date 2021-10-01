package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.backend.DataHandler;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;

public class MainViewController {
    @FXML
    private AnchorPane navBarPane;
    @FXML
    private FlowPane newProductsFlowPane;

    @FXML
    public void initialize() throws IOException {
        navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        DataHandler dh = new DataHandler();
        dh.sortProductsByVariable("apk", false);

        for (int i = 0; i < 20; i++) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/BasicProductCardView.fxml"));
            cardLoader.setController(new BasicProductCardController(dh.getProducts().get(i)));
            newProductsFlowPane.getChildren().add(cardLoader.load());

        }
    }
}
