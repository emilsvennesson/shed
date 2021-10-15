package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class FavoritesPage extends Component {

    @FXML
    private FlowPane favoritesFlowPane;

    protected FavoritesPage() {
        super("FavoritesView");
    }
}
