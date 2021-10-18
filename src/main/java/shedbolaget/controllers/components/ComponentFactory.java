package shedbolaget.controllers.components;

import javafx.scene.layout.AnchorPane;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.pages.Pages;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 * @author OOPsie project :-)
 */
public class ComponentFactory {
    public static AnchorPane createNavBar() {
        return new NavBarComponent().getPane();
    }

    public static AnchorPane createMainPage() {
        return new MainPage().getPane();
    }

    public static AnchorPane createProductsPage() {
        return new ProductsPage().getPane();
    }

    public static AnchorPane createFavoritesPage() {
        return new FavoritesPage().getPane();
    }

    public static AnchorPane createAPKLeaderboard() { return new APKTop3Component().getPane(); }

    public static AnchorPane createDetailedProductCard(Product product) {
        return new DetailedProductCardComponent(product).getPane();
    }

    public static AnchorPane createBasicProductCard(Product product) {
        return new BasicProductCardComponent(product).getPane();
    }

    public static AnchorPane createBreadCrumbs() {
        return new BreadCrumbsComponent().getPane();
    }

    public static AnchorPane createSorter() {
        return new SorterComponent().getPane();
    }

    public static AnchorPane createCategoryMenu() {
        return new CategoryComponent().getPane();
    }

    public static AnchorPane createPagination(Pages pages) {
        return new PaginationComponent(pages).getPane();
    }

    public static AnchorPane createAPKTop3() {return new APKTop3Component().getPane();}
}
