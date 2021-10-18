package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

public class DrinkGeneratorPage extends Component{


    @FXML
    private FlowPane IngredientFlowPane;

    DrinkGeneratorPage(){
        super("DrinkGenerator");

        IngredientFlowPane.getChildren().add(ComponentFactory.createIngredientCard(null));

    }


}
