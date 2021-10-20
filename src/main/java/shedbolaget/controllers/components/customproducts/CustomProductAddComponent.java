package shedbolaget.controllers.components.customproducts;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import shedbolaget.controllers.components.Component;

/**
 * @author Pouya Shirin
 */
public class CustomProductAddComponent extends Component {
    private final AnchorPane customProductPanel;
    public CustomProductAddComponent(AnchorPane customProductPanel) {
        super("AddCustomProductView");
        this.customProductPanel = customProductPanel;
    }

    @FXML
    private void onClick(){
        customProductPanel.toFront();
    }
}

