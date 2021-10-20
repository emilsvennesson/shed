package shedbolaget.controllers.components.DrinkGenerator;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import shedbolaget.controllers.components.Component;
import shedbolaget.controllers.components.ComponentFactory;
import shedbolaget.model.drinks.Drink;
import shedbolaget.model.events.DrinkListEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.NavigationEvent;

import java.util.List;

public class DrinkListPage extends Component {



    @FXML
    private FlowPane DrinkFlowPane;



    public DrinkListPage() {
        super("DrinkListPage");
        EventManager.getInstance().registerToEventBus(this);
    }


    @FXML
    void onBackClicked(ActionEvent event) {

        EventManager.getInstance().fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.DRINKGENERATOR));

    }

    void renderDrink(Drink drink){

        DrinkFlowPane.getChildren().add(ComponentFactory.createDrinkCard(drink));

    }

    void renderDrinks(List<Drink> drinks, int amount){
        DrinkFlowPane.getChildren().clear();
        for(int i = 0; i< amount && i <drinks.size(); i++){
            renderDrink(drinks.get(i));

        }

    }

    @Subscribe
    public void actOnDrinkListEvent(DrinkListEvent event){
        renderDrinks(event.getDrinks(),30);
    }


}
