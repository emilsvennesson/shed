package shedbolaget.controllers.components.DrinkGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import shedbolaget.controllers.components.Component;
import shedbolaget.controllers.components.ComponentFactory;
import shedbolaget.controllers.components.DrinkGenerator.IngredientCardComponent;
import shedbolaget.model.categories.Category;
import shedbolaget.model.drinks.DrinkModel;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.filter.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


        searchAndDisplay("Likör");




    }
    private void renderIngredient(Ingredient ingredient){


        IngredientFlowPane.getChildren().add(ComponentFactory.createIngredientCard(ingredient, false));



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

            // if the product is already in as an ingredient, don't show it
            int finalI = i;
            List<Ingredient> hasProductList = DrinkModel.getIngredients().stream().filter(
                    x-> x.getProd().getProductId() == products.get(finalI).getProductId()
            ).collect(Collectors.toList());
            if(hasProductList.size() != 0){
               continue;
            }

            // Show the product
            ingredients.add(new Ingredient(products.get(i)));
        }



        renderIngredients(ingredients);

    }

    List<Product> products;

    @FXML
    void searchForIngredients(ActionEvent event) {

        String searchQuery = SearchTextField.getText();
        searchAndDisplay(searchQuery);




    }

    void searchAndDisplay(String searchQuery){
        products = Filter.search(ProductModel.getInstance().getAllProducts(), searchQuery, 80);

        renderProductsAsIngredients(products, 30);
    }


    void update(){
        renderProductsAsIngredients(products, 30);
    }

}
