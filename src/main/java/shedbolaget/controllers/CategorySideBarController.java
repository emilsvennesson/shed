package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import shedbolaget.model.Model;

import java.io.IOException;

public class CategorySideBarController {
    private final Model model = Model.getInstance();
    @FXML
    private VBox categoriesvBox;

    @FXML
    public void initialize() throws IOException {
        FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/CategoryView.fxml"));
        this.categoriesvBox.getChildren().add(cardLoader.load());

    }

}
