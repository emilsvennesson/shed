package shedbolaget.controllers.components.DrinkGenerator;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import shedbolaget.controllers.components.Component;
import shedbolaget.model.drinks.DrinkModel;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.events.DrinkGeneratorEvent;
import shedbolaget.model.events.DrinkListEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.NavigationEvent;

import java.util.List;

/**
 * @author Daniel Rygaard
 */
public class DrinkGeneratorPage extends Component {


    private final SearchIngredientPaneComponent SearchComponent = new SearchIngredientPaneComponent();
    private final AddedIngredientsComponent addedIngredientsComponent = new AddedIngredientsComponent();
    @FXML
    private SplitPane SplitPaneView;

    public DrinkGeneratorPage() {
        super("DrinkGenerator");

        SplitPaneView.getItems().add(SearchComponent.getPane());
        SplitPaneView.getItems().add(addedIngredientsComponent.getPane());


        EventManager.getInstance().registerToEventBus(this);

    }


    private void loadIngredients(List<Ingredient> ingredientList) {

        addedIngredientsComponent.renderIngredients(ingredientList);

    }


    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    public void actOnDrinkGeneratorEvent(DrinkGeneratorEvent event) {
        loadIngredients(event.getIngredients());
        SearchComponent.update();
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @FXML
    void onGenerateClicked(ActionEvent event) {
        EventManager.getInstance().fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.DRINKlIST));
        EventManager.getInstance().fireEvent(new DrinkListEvent(DrinkModel.loadFilteredDrinks(470)));

    }


}
