package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import shedbolaget.model.Model;

public class BreadCrumbsController {
    private final Model model = Model.getInstance();

    @FXML
    private Text categoryLevel1Text;

    @FXML
    private Text categoryLevel2Text;

    @FXML
    public void initialize() {
        model.registerToEventBus(this);
        categoryLevel2Text.setVisible(false);
    }
}