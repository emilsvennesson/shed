package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import shedbolaget.model.Model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategorySideBarController {
    @FXML
    private VBox categoriesvBox;

    @FXML
    public void initialize() throws IOException {
        HashMap<String, List<String>> categories = Model.getInstance().getCategories();
        for (Map.Entry<String, List<String>> item : categories.entrySet()) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/fxml/CategoryView.fxml"));
            cardLoader.setController(new CategoryController(item.getKey(), item.getValue()));
            this.categoriesvBox.getChildren().add(cardLoader.load());
        }
    }


    // Styles the checkbox based on its category level


}
