package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Objects;

public class NavBarController {
    @FXML
    private Button productsButton;

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
    void productsButtonOnClicked(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) productsButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ProductsView.fxml")));
        primaryStage.setScene(new Scene(root));
    }

    @FXML
    void homeButtonOnClicked(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) homeButton.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainView.fxml")));
        primaryStage.setScene(new Scene(root));
    }
}
