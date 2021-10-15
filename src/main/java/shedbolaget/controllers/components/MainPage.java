package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import shedbolaget.model.products.Pages;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.Products;

import java.io.IOException;

public class MainPage extends Component {
    @FXML
    private AnchorPane navBarPane;
    @FXML
    private FlowPane newProductsFlowPane;
    private Pages productPages;

    protected MainPage() {
        super("MainView");
    }
}


