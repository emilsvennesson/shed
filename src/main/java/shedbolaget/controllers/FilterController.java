package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.Model;

public class FilterController {

    @FXML
    private FlowPane filterFlowPane;

    @FXML
    private MenuItem sortByPriceMenuItem;

    @FXML
    private MenuItem sortByApkMenuItem;

    @FXML
    private MenuItem sortByNameMenuItem;

    @FXML
    private MenuButton sortMenuButton;

    private Model model;

    @FXML
    public void initialize() {
        model = Model.getInstance();
        sortMenuButton.setText("Pris");
    }

    @FXML
    void sortByPrice(ActionEvent event) {
        model.sortByPrice();
        sortMenuButton.setText("Pris");
    }

    @FXML
    void sortByApk(ActionEvent event) {
        model.sortByApk();
        sortMenuButton.setText("APK");
    }

    @FXML
    void sortByName(ActionEvent event) {
        model.sortByName();
        sortMenuButton.setText("Namn");
    }

}