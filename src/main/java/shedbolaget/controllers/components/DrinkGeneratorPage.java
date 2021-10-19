package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.events.DrinkGeneratorEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.products.Product;

import java.util.List;

//TODO add Javadoc

/**
 * @author Daniel Rygaard
 */
public class DrinkGeneratorPage extends Component{


    @FXML
    private FlowPane IngredientFlowPane;

    DrinkGeneratorPage(){
        super("DrinkGenerator");

        IngredientFlowPane.getChildren().add(ComponentFactory.createIngredientCard(null));
        EventManager.getInstance().registerToEventBus(this);

    }


    private void loadIngredients(List<Ingredient> ingredientList){

        for (Ingredient in :
                ingredientList) {
            //IngredientFlowPane.getChildren().add(ComponentFactory.createIngredientCard(in));
        }

    }



    @Subscribe
    public void actOnDrinkGeneratorEvent(DrinkGeneratorEvent event){



    }



}
