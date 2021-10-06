package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import shedbolaget.model.Model;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    private final Model model = Model.getInstance();
    String level1Category;
    List<String> level2Categories;
    List<CheckBox> checkBoxes;

    @FXML
    private CheckBox categoryLevel1CheckBox;

    @FXML
    private VBox categoryLevel2VBox;

    @FXML
    public void initialize() {
        this.categoryLevel1CheckBox.setText(level1Category);
        this.categoryLevel1CheckBox.setSelected(true);
        initLevel2CheckBoxes();
        categoryLevel1CheckBox.setOnAction(this::onChecked);
        model.registerToEventBus(this);
    }


    CategoryController(String level1Category, List<String> level2Categories) {
        this.level1Category = level1Category;
        this.level2Categories = level2Categories;
    }

    private void onChecked(ActionEvent actionEvent) {
        categoryLevel1CheckBox.setSelected(true);
    }

    private void initLevel2CheckBoxes() {
        checkBoxes = new ArrayList<>();
        for (String level2Category : level2Categories)
            categoryLevel2VBox.getChildren().add(new CategoryLevel2CheckBoxController(level1Category, level2Category));
    }
}

