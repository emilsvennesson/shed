package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.products.Filter;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.Products;

import java.io.IOException;
import java.util.List;

public class ProductsPage extends Component {
    private final EventManager eventManager = EventManager.getInstance();

    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane contentFlowPane;

    private FlowPane productsWrapper;

    private List<Product> filteredProducts;

    protected ProductsPage() {
        super("ProductsView");
        initProductsWrapper();
        populateView();
        eventManager.registerToEventBus(this);
    }

    private void populateView() throws IOException {
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/SorterView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/BreadCrumbsView.fxml")).load());
        contentFlowPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/CategorySideBarView.fxml")).load());
        //navBarPane.getChildren().add(new FXMLLoader(getClass().getResource("/fxml/NavBarView.fxml")).load());
        contentFlowPane.getChildren().add(productsWrapper);
    }

    private void loadProducts(List<Product> products) {
        productsWrapper.getChildren().clear();
        products.subList(0,200).forEach(p -> productsWrapper.getChildren().add(ComponentFactory.createDetailedProductCard(p)));

    }

    private void initProductsWrapper() {
        productsWrapper = new FlowPane();
        productsWrapper.setVgap(8);
    }

    @Subscribe
    public void actOnCategoryEvent(CategoryEvent event) {
        Products productsHolder = Products.getInstance();
        filteredProducts = Filter.getFilteredProductsByCategory(productsHolder.getAllProducts(), event.getActiveCategories());
        if (!filteredProducts.isEmpty())
            loadProducts(filteredProducts);
    }

    @Subscribe
    public void actOnSortEvent(SortEvent event) {
        loadProducts(event.getSortedProductList());
    }
}

