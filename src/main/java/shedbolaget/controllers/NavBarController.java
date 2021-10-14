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
import shedbolaget.model.categories.Category;

import java.io.IOException;
import java.util.Objects;

public class NavBarController {
    private final Model model = Model.getInstance();
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
        for (Category category : model.getCategories().keySet()) {
            menuItem = new MenuItem(category.getName());
            menuItem.setOnAction(new EventHandler<>() {
                @Override
                public void handle(ActionEvent e) {
                    model.clearActiveCategories();
                    model.addToActiveCategories(category);
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

    @FXML
    void favoritesButtonOnClicked(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) homeButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/FavoritesView.fxml")));
        primaryStage.setScene(new Scene(root));
    }
}
