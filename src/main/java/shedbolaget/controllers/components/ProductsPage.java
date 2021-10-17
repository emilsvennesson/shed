package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.PagesEvent;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductsHolder;
import shedbolaget.model.products.filter.Filter;
import shedbolaget.model.products.pages.Pages;

import java.util.List;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class ProductsPage extends Component {
    static private final int PRODUCTS_PER_PAGE = 100;

    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane contentFlowPane;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private FlowPane productsWrapper;

    private List<Product> filteredProducts;

    private AnchorPane paginationComponent;


    protected ProductsPage() {
        super("ProductsView");
        populateView();
        initProductsWrapper();
        eventManager.registerToEventBus(this);
    }

    private void populateView() {
        contentFlowPane.getChildren().add(ComponentFactory.createSorter());
        contentFlowPane.getChildren().add(ComponentFactory.createBreadCrumbs());
        contentFlowPane.getChildren().add(ComponentFactory.createCategoryMenu());
        contentFlowPane.getChildren().add(productsWrapper);
    }

    private void loadPaginationComponent(Pages pages) {
        contentFlowPane.getChildren().remove(paginationComponent);
        paginationComponent = new PaginationComponent(pages).getPane();
        contentFlowPane.getChildren().add(paginationComponent);
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

    private void initProductsWrapper() {
        productsWrapper = new FlowPane();
        productsWrapper.setVgap(8);
    }

    @Subscribe
    public void actOnCategoryEvent(CategoryEvent event) {
        ProductsHolder productsHolder = ProductsHolder.getInstance();
        filteredProducts = Filter.getFilteredProductsByCategory(productsHolder.getAllProducts(), event.getActiveCategories());
        if (!filteredProducts.isEmpty())
            loadProducts(filteredProducts, true);
    }

    @Subscribe
    public void actOnSortEvent(SortEvent event) {
        loadProducts(event.getSortedProductList(), true);
    }

    @Subscribe
    public void actOnPagesEvent(PagesEvent event) {
        loadProducts(event.getPageProducts(), false);
        scrollPane.setVvalue(0);
    }
}

