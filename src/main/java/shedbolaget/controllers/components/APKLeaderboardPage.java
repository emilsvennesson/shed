package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.products.ProductsHolder;
import shedbolaget.model.products.filter.Filter;

import java.util.ArrayList;
import java.util.List;

public class APKLeaderboardPage extends Component {

    @FXML
    private FlowPane contentFlowPane;

    @FXML
    private FlowPane productsWrapper;

    @FXML
    private CheckBox allProductsCheckBox;

    @FXML
    private CheckBox beerCheckBox;

    @FXML
    private CheckBox wineCheckBox;

    @FXML
    private CheckBox liquorCheckBox;

    @FXML
    private CheckBox ciderCheckBox;

    List<Category> activeCategories = new ArrayList<>();


    protected APKLeaderboardPage() {
        super("APKLeaderboardView");
        initProductsWrapper();
        populateView();
        eventManager.registerToEventBus(this);
    }

    private void populateView() {
        contentFlowPane.getChildren().add(productsWrapper);
        productsWrapper.getChildren().add(ComponentFactory.createBreadCrumbs());
        productsWrapper.getChildren().add(ComponentFactory.createAPKTop3());
    }

    private void initProductsWrapper() {
        productsWrapper = new FlowPane();
        productsWrapper.setVgap(8);
    }

    @FXML
    void allProductsOnChecked(ActionEvent event) {
        if (allProductsCheckBox.isSelected() || activeCategories.isEmpty()) {
            activeCategories.addAll(Categories.getLevel1Categories(ProductsHolder.getInstance().getAllProducts()));
            allProductsCheckBox.setSelected(true);
            fireNewCategory();
        }
    }

    @FXML
    void beerOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductsHolder.getInstance().getAllProducts(), List.of(new Category("Öl", 1))));
        if (beerCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
    }

    @FXML
    void ciderOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductsHolder.getInstance().getAllProducts(), List.of(new Category("Cider & blanddrycker", 1))));
        if (ciderCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
    }

    @FXML
    void liquorOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductsHolder.getInstance().getAllProducts(), List.of(new Category("Sprit", 1))));
        if (liquorCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
    }

    @FXML
    void wineOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductsHolder.getInstance().getAllProducts(), List.of(new Category("Vin", 1))));
        if (wineCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
    }

    private void fireNewCategory() {
        eventManager.fireEvent(new CategoryEvent(activeCategories));
    }
}
