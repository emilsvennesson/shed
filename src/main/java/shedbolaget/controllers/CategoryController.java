package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import shedbolaget.model.categories.Category;
import shedbolaget.model.Model;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    private final Model model = Model.getInstance();
    Category level1Category = model.getActiveCategories(1).get(0);
    List<CheckBox> checkBoxes;

    @FXML
    private CheckBox categoryLevel1CheckBox;

    @FXML
    private VBox categoryLevel2VBox;

    @FXML
    public void initialize() {
        this.categoryLevel1CheckBox.setText(level1Category.getName());
        this.categoryLevel1CheckBox.setSelected(true);
        initLevel2CheckBoxes();
        categoryLevel1CheckBox.setOnAction(this::onChecked);
        model.registerToEventBus(this);
    }

    private void onChecked(ActionEvent actionEvent) {
        categoryLevel1CheckBox.setSelected(true);
    }

    private void initLevel2CheckBoxes() {
        checkBoxes = new ArrayList<>();
        for (Category level2Category : model.getSubCategories(level1Category)) {
            CheckBox checkBox = new CheckBox(level2Category.getName());
            checkBox.setOnAction(e -> model.addToActiveCategories(level2Category));
            categoryLevel2VBox.getChildren().add(checkBox);
        }
    }
}

