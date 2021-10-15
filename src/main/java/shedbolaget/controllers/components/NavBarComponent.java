package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
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

public class NavBarComponent extends Component {
    private EventManager eventManager;

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

    public NavBarComponent() {
        super("NavBarView");
        eventManager = EventManager.getInstance();
        eventManager.registerToEventBus(this);
    }

    @FXML
    void homeButtonOnClicked(ActionEvent event) {
        List<Category> test = new ArrayList<>();
        test.add(new Category("Öl", 1));
        eventManager.fireEvent(new CategoryEvent(test));
    }


    @FXML
    void favoritesButtonOnClicked(ActionEvent event) {
        System.out.println("favorites button clicked");
    }
}
