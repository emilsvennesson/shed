package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import shedbolaget.model.events.*;
import shedbolaget.model.favorites.Favorites;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.filter.Filter;
import shedbolaget.model.products.pages.Pages;

import java.util.List;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class ProductsPage extends Component {
    static private final int PRODUCTS_PER_PAGE = 20;
    static private final int FUZZY_REQUIRED_HIT_RATE = 90;
    @FXML
    AnchorPane customProductPane;

    @FXML
    private AnchorPane navBarPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private FlowPane productsWrapper;

    private List<Product> filteredProducts;

    private AnchorPane paginationComponent;

    @FXML
    private VBox leftMenuVBox;

    @FXML
    private VBox contentVBox;


    protected ProductsPage() {
        super("ProductsView");
        initProductsWrapper();
        initCustomProductComponent();
        populateView();
        eventManager.registerToEventBus(this);
    }

    private void initProductsWrapper() {
        productsWrapper = new FlowPane();
        productsWrapper.setVgap(8);
    }

    private void populateView() {
        leftMenuVBox.getChildren().add(ComponentFactory.createSorter());
        contentVBox.getChildren().add(ComponentFactory.createBreadCrumbs());
        leftMenuVBox.getChildren().add(ComponentFactory.createCategoryMenu());
        leftMenuVBox.getChildren().add(ComponentFactory.createCustomProductAdd(customProductPane));
        contentVBox.getChildren().add(productsWrapper);
    }

    private void initCustomProductComponent() {
        customProductPane = ComponentFactory.createCustomProductPane();
        this.getPane().getChildren().add(customProductPane);
        customProductPane.toBack();
    }

    private void loadPaginationComponent(Pages pages) {
        contentVBox.getChildren().remove(paginationComponent);
        paginationComponent = new PaginationComponent(pages).getPane();
        contentVBox.getChildren().add(paginationComponent);
    }

    private void loadProducts(List<Product> products, boolean asPages) {
        productsWrapper.getChildren().clear();
        if (asPages) {
            Pages pages = new Pages(products, PRODUCTS_PER_PAGE);
            products = pages.getProductsFromPage(1);
            loadPaginationComponent(pages);
        }
        for (Product product : products)
            productsWrapper.getChildren().add(ComponentFactory.createDetailedProductCard(product));
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    private void actOnCategoryEvent(CategoryEvent event) {
        filteredProducts = Filter.getFilteredProductsByCategory(ProductModel.getInstance().getProducts(), event.getActiveCategories());
        if (!filteredProducts.isEmpty())
            loadProducts(filteredProducts, true);
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    private void actOnSortEvent(SortEvent event) {
        loadProducts(event.getSortedProductList(), true);
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    private void actOnPagesEvent(PagesEvent event) {
        loadProducts(event.getPageProducts(), false);
        scrollPane.setVvalue(0);
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    private void actOnSearchEvent(SearchEvent event) {
        loadProducts(Filter.search(ProductModel.getInstance().getProducts(), event.getSearchString(), FUZZY_REQUIRED_HIT_RATE), true);
    }

    @Subscribe
    public void onNavigationEvent(NavigationEvent event) {
        if (event.getPageToNavigateTo() == NavigationEvent.NAVIGATION.FAVORITES) {
            loadProducts(Favorites.getInstance().getFavoriteProducts(), true);

        }
    }
}
