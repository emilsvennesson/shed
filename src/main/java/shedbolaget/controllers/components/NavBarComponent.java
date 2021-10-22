package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.CustomProductCreatedEvent;
import shedbolaget.model.events.NavigationEvent;
import shedbolaget.model.events.SearchEvent;
import shedbolaget.model.products.ProductModel;

import java.util.List;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class NavBarComponent extends Component {
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

    public NavBarComponent() {
        super("NavBarView");
        eventManager.registerToEventBus(this);
        initDropdown();
    }

    private void initDropdown() {
        MenuItem menuItem;
        for (Category category : Categories.getLevel1Categories(ProductModel.getInstance().getProducts())) {
            menuItem = new MenuItem(category.getName());
            menuItem.setOnAction(e -> {
                eventManager.fireEvent(new CategoryEvent(List.of(category)));
                eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.PRODUCTS));
            });
            dropDownButton.getItems().add(menuItem);
        }
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @Subscribe
    private void updateDropdown(CustomProductCreatedEvent event) {
        dropDownButton.getItems().clear();
        initDropdown();
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void homeButtonOnClicked(ActionEvent event) {
        eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.MAIN));
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void favoritesButtonOnClicked(ActionEvent event) {
        eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.FAVORITES));
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void drinkGeneratorButtonOnClicked(ActionEvent event) {
        eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.DRINKGENERATOR));
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void searchButtonOnClicked(ActionEvent event) {
        eventManager.fireEvent(new SearchEvent(searchTextField.getText()));
        eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.SEARCH));
        searchTextField.clear();
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void apkLeaderboardButtonOnClicked(ActionEvent event) {
        eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.APK));
    }
}
