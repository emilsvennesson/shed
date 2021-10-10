package shedbolaget.controllers;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import shedbolaget.model.Model;
import shedbolaget.model.events.CategoryEvent;

public class BreadCrumbsController {
    private final Model model = Model.getInstance();

    @FXML
    private Text categoryLevel1Text;

    @FXML
    private Text categoryLevel2Text;

    @FXML
    public void initialize() {
        model.registerToEventBus(this);
        categoryLevel1Text.setText(model.getActiveCategoryLevel1Filter());
        categoryLevel2Text.setVisible(false);
    }

    @Subscribe
    public void categoryLevel2EventListener(CategoryEvent event) {
        String level2Categories = String.join(", ", model.getActiveCategoryLevel2Filters());
        if (!level2Categories.equals("")) {
            categoryLevel2Text.setText(level2Categories);
            categoryLevel2Text.setVisible(true);
        } else
            categoryLevel2Text.setVisible(false);
    }
}