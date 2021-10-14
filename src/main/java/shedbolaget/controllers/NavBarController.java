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
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.EventManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NavBarController {
    private final EventManager eventManager = EventManager.getInstance();

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

    private Parent productsView;

    @FXML
    public void initialize() {
        eventManager.registerToEventBus(this);
        initProductsView();
        initLevel1Categories();
    }

    private void initProductsView() {
        try {
            productsView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ProductsView.fxml")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void initLevel1Categories() {
        MenuItem menuItem;
        for (Category category : Categories.getAllCategories().keySet()) {
            menuItem = new MenuItem(category.getName());
            menuItem.setOnAction(e -> {
                List<Category> activeCategories = new ArrayList<>();
                activeCategories.add(category);
                eventManager.fireEvent(new CategoryEvent(activeCategories));
                Stage primaryStage = (Stage) homeButton.getScene().getWindow();
                primaryStage.setScene(new Scene(productsView));
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
