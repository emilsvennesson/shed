package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class CategoryController {
    String level1Category;
    List<String> level2Categories;

    @FXML
    private CheckBox categoryLevel1CheckBox;

    @FXML
    private VBox categoryLevel2VBox;

    @FXML
    public void initialize() {
        this.categoryLevel1CheckBox.setText(level1Category);
        initLevel2CheckBoxes();
    }

    CategoryController(String level1Category, List<String> level2Categories) {
        this.level1Category = level1Category;
        this.level2Categories = level2Categories;
    }

    private void initLevel2CheckBoxes() {
        CheckBox checkBox;
        for (String level2Category : level2Categories) {
            checkBox = new CategoryCheckBoxController(level2Category);
            categoryLevel2VBox.getChildren().add(checkBox);
        }
    }

}

