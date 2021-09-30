package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class CategorySideBarController {
    @FXML
    private FlowPane categoriesFlowPane;

    @FXML
    public void initialize() throws IOException {
        categoriesFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/CategorySideBarItemView.fxml")).load());
    }
}
