package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import shedbolaget.model.events.EventManager;

import java.io.IOException;

public class CategorySideBarController {
    private final EventManager eventManager = EventManager.getInstance();
    @FXML
    private VBox categoriesvBox;

    @FXML
    public void initialize() throws IOException {
        // TODO: get rid of this stupid class
        FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/CategoryView.fxml"));
        this.categoriesvBox.getChildren().add(cardLoader.load());
        eventManager.registerToEventBus(this);
    }

}
