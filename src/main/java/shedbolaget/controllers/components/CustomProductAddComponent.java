package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class CustomProductAddComponent extends Component {
    private final AnchorPane customProductPanel;
    protected CustomProductAddComponent(AnchorPane customProductPanel) {
        super("AddCustomProductView");
        this.customProductPanel = customProductPanel;
    }

    @FXML
    private void onClick(){
        customProductPanel.toFront();
    }
}

