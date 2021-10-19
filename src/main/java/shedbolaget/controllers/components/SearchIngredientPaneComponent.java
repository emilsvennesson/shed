package shedbolaget.controllers.components;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.categories.Category;
import shedbolaget.model.drinks.DrinkModel;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductsHolder;
import shedbolaget.model.products.filter.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchIngredientPaneComponent extends Component {


    @FXML
    private FlowPane IngredientFlowPane;

    @FXML
    private TextField SearchTextField;

    @FXML
    private Button SearchButton;

    Map<String, IngredientCardComponent> renderedIngredients = new HashMap<>();


    protected SearchIngredientPaneComponent() {
        super("SearchIngredientPane");
        initPage();


    }

    private void initPage() {
        List<Category> list = new ArrayList<>();
        list.add(new Category("Sprit", 1));


        renderProductsAsIngredients(Filter.getFilteredProductsByCategory(ProductsHolder.getInstance().getAllProducts(), list), 30);



    }
    private void renderIngredient(Ingredient ingredient){


        IngredientFlowPane.getChildren().add(ComponentFactory.createIngredientCard(ingredient));



    }

    private void renderIngredients(List<Ingredient> ingredients){
        IngredientFlowPane.getChildren().clear();
        for (Ingredient ingredient :
                ingredients) {
            renderIngredient(ingredient);
        }
    }

    private void renderProductsAsIngredients(List<Product> products, int amount){
        List<Ingredient> ingredients = new ArrayList<>();
        for(int i = 0; i<products.size() && i < amount; i++){
            ingredients.add(new Ingredient(products.get(i)));
        }



        renderIngredients(ingredients);

    }



    @FXML
    void searchForIngredients(ActionEvent event) {

    }
}
