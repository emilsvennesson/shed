package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.PagesEvent;
import shedbolaget.model.events.SearchEvent;
import shedbolaget.model.events.SortEvent;
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
    static private final int PRODUCTS_PER_PAGE = 100;

    @FXML
    private AnchorPane navBarPane;

    @FXML AnchorPane customProductPane;

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
        contentFlowPane.getChildren().add(ComponentFactory.createSorter());
        contentFlowPane.getChildren().add(ComponentFactory.createBreadCrumbs());
        contentFlowPane.getChildren().add(ComponentFactory.createCategoryMenu());
        contentFlowPane.getChildren().add(productsWrapper);
        contentFlowPane.getChildren().add(ComponentFactory.createCustomProductAdd(customProductPane));
    }

    private void initCustomProductComponent(){
        customProductPane = ComponentFactory.createCustomProductPane();
        this.getPane().getChildren().add(customProductPane);
        customProductPane.toBack();
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


    @Subscribe
    public void actOnCategoryEvent(CategoryEvent event) {
        filteredProducts = Filter.getFilteredProductsByCategory(ProductModel.getInstance().getAllProducts(), event.getActiveCategories());
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

    @Subscribe
    public void actOnSearchEvent(SearchEvent event) {
        loadProducts(Filter.search(ProductModel.getInstance().getAllProducts(), event.getSearchString(), 80), true);
    }
}

