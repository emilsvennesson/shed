package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CategorySideBarController {
    @FXML
    private VBox categoriesvBox;

    @FXML
    public void initialize() throws IOException {
        FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/CategoryView.fxml"));
        this.categoriesvBox.getChildren().add(cardLoader.load());

    }

}
