package shedbolaget.controllers.components;

import javafx.scene.layout.AnchorPane;
import shedbolaget.controllers.components.DrinkGenerator.DrinkCardComponent;
import shedbolaget.controllers.components.DrinkGenerator.DrinkGeneratorPage;
import shedbolaget.controllers.components.DrinkGenerator.DrinkListPage;
import shedbolaget.controllers.components.DrinkGenerator.IngredientCardComponent;
import shedbolaget.model.drinks.Drink;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.pages.Pages;

import java.util.HashMap;
import java.util.Map;

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

    /*---------------------------------Drink Generator --------------------------------------------*/
    public static AnchorPane createDrinkGeneratorPage() {
        return new DrinkGeneratorPage().getPane();
    }

    static Map<String, IngredientCardComponent> renderedIngredients = new HashMap<>();

    public static AnchorPane createIngredientCard(Ingredient ingredient, boolean added){
        IngredientCardComponent comp = renderedIngredients.get(ingredient.getProd().getProductId());
        if(comp == null){
            comp = new IngredientCardComponent(ingredient);
            renderedIngredients.put(ingredient.getProd().getProductId(), comp);
        }
        if(added){
            comp.markAsAdded();
        }else
            comp.markAsNotAdded();
        return comp.getPane();
    }

    public static AnchorPane createDrinkListPage() {

        return new DrinkListPage().getPane();
    }

    public static AnchorPane createDrinkCard(Drink drink){
        return new DrinkCardComponent(drink).getPane();
    }


}
