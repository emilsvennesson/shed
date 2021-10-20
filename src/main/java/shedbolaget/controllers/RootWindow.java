package shedbolaget.controllers;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import shedbolaget.controllers.components.ComponentFactory;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.NavigationEvent;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class RootWindow {

    AnchorPane navBar = ComponentFactory.createNavBar();
    AnchorPane productsPage = ComponentFactory.createProductsPage();
    AnchorPane mainPage = ComponentFactory.createMainPage();
    AnchorPane apkLeaderboardPage = ComponentFactory.createAPKLeaderboard();
    AnchorPane drinkGeneratorPage = ComponentFactory.createDrinkGeneratorPage();
    AnchorPane drinkListPage = ComponentFactory.createDrinkListPage();
    @FXML
    private AnchorPane navBarPane;
    @FXML
    private AnchorPane contentWrapperAnchorPane;

    @FXML
    public void initialize() {
        EventManager.getInstance().registerToEventBus(this);
        this.navBarPane.getChildren().add(navBar);
        this.contentWrapperAnchorPane.getChildren().add(mainPage);
    }

    public void openProductsPage() {
        contentWrapperAnchorPane.getChildren().clear();
        contentWrapperAnchorPane.getChildren().add(productsPage);
    }

    public void openMainPage() {
        contentWrapperAnchorPane.getChildren().clear();
        contentWrapperAnchorPane.getChildren().add(mainPage);
    }
    public void openDrinkGenerator(){
        contentWrapperAnchorPane.getChildren().clear();
        contentWrapperAnchorPane.getChildren().add(drinkGeneratorPage);
    }

    public void openDrinkList(){
        contentWrapperAnchorPane.getChildren().clear();
        contentWrapperAnchorPane.getChildren().add(drinkListPage);
    }

    public void openAPKLeaderboardPage() {
        contentWrapperAnchorPane.getChildren().clear();
        contentWrapperAnchorPane.getChildren().add(apkLeaderboardPage);
    }

    @Subscribe
    public void onNavigationEvent(NavigationEvent event) {
        switch (event.getPageToNavigateTo()) {
            case PRODUCTS -> openProductsPage();
            case MAIN -> openMainPage();
            case APK -> openAPKLeaderboardPage();
            case DRINKGENERATOR -> openDrinkGenerator();
            case DRINKlIST -> openDrinkList();
        }
    }
}