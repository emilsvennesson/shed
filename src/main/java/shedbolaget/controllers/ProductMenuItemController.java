package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class ProductMenuItemController extends MenuItem {

    public ProductMenuItemController(String categoryLevel1Name) {
        this.setText(categoryLevel1Name);
        setOnClickedEventHandler();
    }

    private void setOnClickedEventHandler() {
        Stage primaryStage = (Stage) this.getParentPopup().getOwnerWindow();
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ProductsView.fxml")));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                assert root != null;
                primaryStage.setScene(new Scene(root));
            }
        });
    }
}
