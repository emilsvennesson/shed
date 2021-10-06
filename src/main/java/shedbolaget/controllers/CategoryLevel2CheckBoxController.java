package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import shedbolaget.model.Model;

public class CategoryLevel2CheckBoxController extends CheckBox {
    private final String categoryLevel1;
    private final String categoryLevel2;
    private final Model model = Model.getInstance();

    CategoryLevel2CheckBoxController(String categoryLevel1, String categoryLevel2) {
        this.categoryLevel1 = categoryLevel1;
        this.categoryLevel2 = categoryLevel2;
        this.setText(this.categoryLevel2);
        this.setOnAction(this::onChecked);
        model.registerToEventBus(this);
    }

    private void onChecked(ActionEvent actionEvent) {
        if (this.isSelected())
            model.addCategoryLevel2Filter(categoryLevel2);
        else
            model.removeCategoryLevel2Filter(categoryLevel2);
    }

}