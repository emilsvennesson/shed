package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class MainViewController {
    @FXML
    private AnchorPane navBarPane;

    @FXML
    public void initialize() {
        navBarPane.getChildren().add(new NavBarController("NavBarView.fxml"));
    }
}
