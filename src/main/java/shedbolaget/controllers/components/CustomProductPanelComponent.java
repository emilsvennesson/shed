package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import org.w3c.dom.Text;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.PagesEvent;
import shedbolaget.model.events.SearchEvent;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.customproduct.CustomProduct;
import shedbolaget.model.products.filter.Filter;
import shedbolaget.model.products.pages.Pages;

import java.util.List;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class CustomProductPanelComponent extends Component {
    @FXML
    private TextField productNameInput;
    @FXML
    private TextField category1Input;
    @FXML
    private TextField category2Input;
    @FXML
    private TextField tasteInput;
    @FXML
    private TextField countryInput;
    @FXML
    private TextField priceInput;
    @FXML
    private TextField volumeInput;
    @FXML
    private TextField alcoholPercentageInput;


    protected CustomProductPanelComponent() {
        super("CustomProductPanelView");
    }

    @FXML
    private void saveProduct(){
        createCustomProduct();
        this.getPane().toBack();
    }

    private void createCustomProduct(){
        CustomProduct.createProduct(productNameInput.getText(), category1Input.getText(),
                category2Input.getText(), Integer.parseInt(priceInput.getText()), Integer.parseInt(volumeInput.getText()),
                Integer.parseInt(alcoholPercentageInput.getText()));
    }
}

