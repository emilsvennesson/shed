package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.categories.Category;
import shedbolaget.model.products.filter.Filter;
import shedbolaget.model.products.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class SorterComponent extends Component {
    @FXML
    private FlowPane filterFlowPane;

    @FXML
    private MenuItem sortByPriceMenuItem;

    @FXML
    private MenuItem sortByApkMenuItem;

    @FXML
    private MenuItem sortByNameMenuItem;

    @FXML
    private MenuButton sortMenuButton;

    private List<Category> activeCategories = new ArrayList<>();

    protected SorterComponent() {
        super("SorterView");
        eventManager.registerToEventBus(this);
        sortMenuButton.setText("Pris");
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void onSortByPriceClick(ActionEvent event) {
        sortByPrice();
        sortMenuButton.setText("Pris");
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void onSortByApkClick(ActionEvent event) {
        sortMenuButton.setText("APK");
        sortByApk();
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @FXML
    private void onSortByNameClick(ActionEvent event) {
        // TODO: implement sort by name, right now sorting by APk...
        System.out.println("Sorting by apk instead of name, fix me");
        sortByName();
        sortMenuButton.setText("Namn");
    }

    private void sortByPrice() {
        List<Product> prods = Sorter.getProductListSortedByPrice(Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), activeCategories), false);
        eventManager.fireEvent(new SortEvent(prods));
    }

    private void sortByApk() {
        List<Product> prods = Sorter.getProductListSortedByApk(Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), activeCategories), true);
        eventManager.fireEvent(new SortEvent(prods));
    }

    private void sortByName() {
        List<Product> prods = Sorter.getProductListSortedByApk(Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), activeCategories), true);
        eventManager.fireEvent(new SortEvent(prods));
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    private void actOnCategoryEvent(CategoryEvent event) {
        activeCategories = event.getActiveCategories();
        String activeSortingMethod = sortMenuButton.getText();
        switch (activeSortingMethod) {
            case "Pris" -> sortByPrice();
            case "Namn" -> sortByName();
            case "APK" -> sortByApk();
            default -> {
            }
        }
    }
}