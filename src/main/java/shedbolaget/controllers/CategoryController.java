package shedbolaget.controllers;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.EventManager;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {
    private final EventManager eventManager = EventManager.getInstance();
    List<CheckBox> checkBoxes;

    @FXML
    private CheckBox categoryLevel1CheckBox;

    @FXML
    private VBox categoryLevel2VBox;

    @FXML
    public void initialize() {
        eventManager.registerToEventBus(this);
        this.categoryLevel1CheckBox.setSelected(true);
        categoryLevel1CheckBox.setOnAction(this::onChecked);
    }

    private void onChecked(ActionEvent actionEvent) {
        categoryLevel1CheckBox.setSelected(true);
    }

    private void initLevel2CheckBoxes(List<Category> categories) {
        Category activeLevel1Category = Categories.getCategoriesByLevel(categories, 1).get(0);
        checkBoxes = new ArrayList<>();
        for (Category level2Category : Categories.getSubCategories(activeLevel1Category)) {
            CheckBox checkBox = new CheckBox(level2Category.getName());
            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    categories.add(level2Category);
                    eventManager.fireEvent(new CategoryEvent(categories));
                } else {
                    categories.remove(level2Category);
                    eventManager.fireEvent(new CategoryEvent(categories));
                }
            });
            categoryLevel2VBox.getChildren().add(checkBox);
        }
    }

    @Subscribe
    public void actOnCategoryEvent(CategoryEvent event) {
        categoryLevel2VBox.getChildren().clear();
        initLevel2CheckBoxes(event.getActiveCategories());
    }
}
