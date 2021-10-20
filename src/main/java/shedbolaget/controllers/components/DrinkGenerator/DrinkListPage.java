package shedbolaget.controllers.components.DrinkGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import shedbolaget.controllers.components.Component;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.NavigationEvent;

public class DrinkListPage extends Component {



    @FXML
    private FlowPane DrinkFlowPane;



    public DrinkListPage() {
        super("DrinkListPage");
    }


    @FXML
    void onBackClicked(ActionEvent event) {

        EventManager.getInstance().fireEvent(new NavigationEvent(NavigationEvent.NAVIGATION.DRINKGENERATOR));

    }

}
