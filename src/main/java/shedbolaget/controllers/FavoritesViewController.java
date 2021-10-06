package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.io.IOException;

public class FavoritesViewController {

    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane favoritesFlowPane;

    @FXML
    public void initialize() throws IOException {
        navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        populateFavorites();
    }

    private void populateFavorites() throws IOException {
        Model model = Model.getInstance();
        for(Product p : model.getFavoritesAsProducts()) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/BasicProductCardView.fxml"));
            cardLoader.setController(new BasicProductCardController(p));
            favoritesFlowPane.getChildren().add(cardLoader.load());
        }
    }

}
