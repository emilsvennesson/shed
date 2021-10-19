package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.drinks.Ingredient;

import java.util.List;

public class AddedIngredientsComponent extends Component{


    @FXML
    private FlowPane IngredientFlowPane;


    protected AddedIngredientsComponent() {
        super("AddedIngredientsPane");
    }

    public void renderIngredients(List<Ingredient> ingredientList) {

        for (Ingredient ingredient :
                ingredientList) {

            IngredientFlowPane.getChildren().add(new IngredientCardComponent(ingredient).getPane());
        }
    }

    public void testAdd(){
        IngredientFlowPane.getChildren().add(new IngredientCardComponent().getPane());
    }

}
