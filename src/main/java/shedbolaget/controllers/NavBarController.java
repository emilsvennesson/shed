package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shedbolaget.model.Model;

import java.io.IOException;
import java.util.Objects;

public class NavBarController {
    @FXML
    private MenuButton dropDownButton;

    @FXML
    private Button apkLeaderboardButton;

    @FXML
    private Button drinkGeneratorButton;

    @FXML
    private Button favoritesButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button homeButton;

    @FXML
    public void initialize() {
        initLevel1Categories();
    }

    private void initLevel1Categories() {
        MenuItem menuItem;
        for (String category : Model.getInstance().getCategories().keySet()) {
            menuItem = new MenuItem(category);
            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    Model.getInstance().clearCategoryLevel2Filters();
                    Model.getInstance().setCategoryLevel1Filter(category);
                    Stage primaryStage = (Stage) homeButton.getScene().getWindow();
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
            dropDownButton.getItems().add(menuItem);
        }
    }

    @FXML
    void homeButtonOnClicked(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) homeButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainView.fxml")));
        primaryStage.setScene(new Scene(root));
    }
}
