package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.NavigationEvent;
import shedbolaget.model.events.SearchEvent;
import shedbolaget.model.products.ProductsHolder;

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

    private Parent productsView;

    public NavBarComponent() {
        super("NavBarView");
        eventManager.registerToEventBus(this);
        initDropdown();
    }

    private void initDropdown() {
        MenuItem menuItem;
        for (Category category : Categories.getLevel1Categories(ProductsHolder.getInstance().getAllProducts())) {
            menuItem = new MenuItem(category.getName());
            menuItem.setOnAction(e -> {
                eventManager.fireEvent(new CategoryEvent(List.of(category)));
                eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.PRODUCTS));
            });
            dropDownButton.getItems().add(menuItem);
        }
    }

    @FXML
    void homeButtonOnClicked(ActionEvent event) {
        eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.MAIN));
    }

    @FXML
    void favoritesButtonOnClicked(ActionEvent event) {
        System.out.println("favorites button clicked");
    }

    @FXML
    void searchButtonOnClicked(ActionEvent event) {
        eventManager.fireEvent(new SearchEvent(searchTextField.getText()));
        eventManager.fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.PRODUCTS));
        searchTextField.clear();
    }
}
