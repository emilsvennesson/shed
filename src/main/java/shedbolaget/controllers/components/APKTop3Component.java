package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class APKTop3Component extends Component {

    @FXML
    private AnchorPane secondPlaceAnchorPane;

    @FXML
    private AnchorPane firstPlaceAnchorPane;

    @FXML
    private AnchorPane thirdPlaceAnchorPane;

    protected APKTop3Component() {
        super("APKTop3View");
    }

}

