package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
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
    private SplitPane SplitPaneView;

    private final SearchIngredientPaneComponent SearchComponent = new SearchIngredientPaneComponent();
    private final AddedIngredientsComponent addedIngredientsComponent = new AddedIngredientsComponent();
    DrinkGeneratorPage(){
        super("DrinkGenerator");

        SplitPaneView.getItems().add(SearchComponent.getPane());
        SplitPaneView.getItems().add(addedIngredientsComponent.getPane());


        EventManager.getInstance().registerToEventBus(this);

    }


    private void loadIngredients(List<Ingredient> ingredientList){

        addedIngredientsComponent.renderIngredients(ingredientList);

    }



    @Subscribe
    public void actOnDrinkGeneratorEvent(DrinkGeneratorEvent event){
        loadIngredients(event.getIngredients());
    }



}
