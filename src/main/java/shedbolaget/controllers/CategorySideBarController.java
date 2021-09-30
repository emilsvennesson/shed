package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CategorySideBarController {
    @FXML
    private FlowPane categoriesFlowPane;

    @FXML
    private VBox categoriesVBox;

    @FXML
    public void initialize() throws IOException {
        // Gets categories from model
        List<String> categories = Arrays.asList("Öl", "Ale", "Ljus Lager", "Veteöl", "Vin", "Rött", "Vitt", "Mousserande");
        for (String categoryName : categories) {
            this.categoriesVBox.getChildren().add(this.getCategoryCheckBox(categoryName, isCategoryLevel1(categoryName)));
        }
    }

    private CheckBox getCategoryCheckBox(String categoryName, boolean isCategoryLevel1) {
        // Styles the checkbox based on its category level
        CheckBox checkBox = new CheckBox();
        checkBox.setText(categoryName);
        checkBox.getStyleClass().add("black-text");
        checkBox.getStyleClass().add("check-box-general");
        checkBox.setAlignment(Pos.CENTER_LEFT);
        checkBox.setStyle("-fx-font-size: 14px");
        if (isCategoryLevel1) {
            checkBox.setPadding(new Insets(4, 0, 6, 0));
            checkBox.setPrefWidth(176);
        } else {
            checkBox.setPadding(new Insets(0, 11, 4, 8));
            checkBox.getStyleClass().add("check-box-indented");
            checkBox.setPrefWidth(168);
        }
        return checkBox;
    }

    private boolean isCategoryLevel1(String categoryName) {
        List<String> categoryLevel1 = Arrays.asList("Öl", "Vin");
        return categoryLevel1.contains(categoryName);
    }
}
