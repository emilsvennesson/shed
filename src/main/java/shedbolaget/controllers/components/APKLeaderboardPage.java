package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.filter.Filter;
import shedbolaget.model.products.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

public class APKLeaderboardPage extends Component {

    @FXML
    private FlowPane contentFlowPane;


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

    @FXML
    private VBox contentVBox;

    List<Category> activeCategories = new ArrayList<>();


    protected APKLeaderboardPage() {
        super("APKLeaderboardView");
        allProductsCheckBox.setSelected(true);
        populateView();
        eventManager.registerToEventBus(this);
    }

    private void populateView() {
        contentVBox.getChildren().add(1, ComponentFactory.createAPKTop3());
        initListItems();
    }

    private void initListItems() {
        List<Product> products = Sorter.getProductListSortedByApk(ProductModel.getInstance().getProducts(), true);
        for (Product product : products.subList(3, 100)) {
            contentVBox.getChildren().add(new APKCompactListItemComponent(product, products.indexOf(product) + 1).getPane());
        }
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    private void actOnCategoryEvent(CategoryEvent event) {
        List<Product> filteredProducts = Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), event.getActiveCategories());
        List<Product> sortedProducts = Sorter.getProductListSortedByApk(filteredProducts, true);
        contentVBox.getChildren().remove(3, contentVBox.getChildren().size());
        for (Product product : sortedProducts.subList(3, 100)) {
            contentVBox.getChildren().add(new APKCompactListItemComponent(product, sortedProducts.indexOf(product) + 1).getPane());
        }
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @FXML
    void allProductsOnChecked(ActionEvent event) {
        if (allProductsCheckBox.isSelected() || activeCategories.isEmpty()) {
            activeCategories.addAll(Categories.getLevel1Categories(ProductModel.getInstance().getProducts()));
            allProductsCheckBox.setSelected(true);
            fireNewCategory();
        }
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @FXML
    void beerOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), List.of(new Category("Öl", 1))));
        if (beerCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
        updateAllProductsCheckBox();
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @FXML
    void ciderOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), List.of(new Category("Cider & blanddrycker", 1))));
        if (ciderCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
        updateAllProductsCheckBox();
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @FXML
    void liquorOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), List.of(new Category("Sprit", 1))));
        if (liquorCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
        updateAllProductsCheckBox();
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @FXML
    void wineOnChecked(ActionEvent event) {
        List<Category> categories = Categories.getLevel1Categories(Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), List.of(new Category("Vin", 1))));
        if (wineCheckBox.isSelected()) {
            activeCategories.addAll(categories);
        } else {
            activeCategories.removeAll(categories);
        }
        fireNewCategory();
        updateAllProductsCheckBox();
    }

    private void fireNewCategory() {
        eventManager.fireEvent(new CategoryEvent(activeCategories));
    }

    private void updateAllProductsCheckBox() {
        boolean someAreSelected = beerCheckBox.isSelected() || wineCheckBox.isSelected() || ciderCheckBox.isSelected() || liquorCheckBox.isSelected();
        boolean allAreSelected = beerCheckBox.isSelected() && wineCheckBox.isSelected() && ciderCheckBox.isSelected() && liquorCheckBox.isSelected();
        allProductsCheckBox.setSelected(!someAreSelected || allAreSelected);
    }
}
