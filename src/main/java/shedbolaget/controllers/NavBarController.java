package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class NavBarController {
    @FXML
    private MenuButton productsButton;

    @FXML
    private Button apkLeaderboardButton;

    @FXML
    private Button drinkGeneratorButton;

    @FXML
    private Button favoritesButton;

    @FXML
    private TextField searchTextField;

    @FXML
    void beerButtonOnClicked(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) productsButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ProductsView.fxml")));
        primaryStage.setScene(new Scene(root));
    }

    @FXML
    void wineButtonOnClicked(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) productsButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainView.fxml")));
        primaryStage.setScene(new Scene(root));
    }
}
