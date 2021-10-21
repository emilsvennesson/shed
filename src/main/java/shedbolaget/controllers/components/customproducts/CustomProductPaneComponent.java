package shedbolaget.controllers.components.customproducts;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import shedbolaget.controllers.components.Component;
import shedbolaget.model.products.customproduct.CustomProduct;

/**
 * @author Pouya Shirin
 */
public class CustomProductPaneComponent extends Component {
    @FXML
    private TextField productNameInput;
    @FXML
    private TextField category1Input;
    @FXML
    private TextField category2Input;
    @FXML
    private TextField countryInput;
    @FXML
    private TextField priceInput;
    @FXML
    private TextField volumeInput;
    @FXML
    private TextField alcoholPercentageInput;

    @FXML
    private ImageView productImage;
    @FXML
    private TextField imgURLInput;


    public CustomProductPaneComponent() {
        super("CustomProductPaneView");
    }

    @FXML
    private void saveProduct(){
        createCustomProduct();
        closePane();
    }

    private void createCustomProduct(){
        CustomProduct.createProduct(productNameInput.getText(), category1Input.getText(),
                category2Input.getText(), Integer.parseInt(priceInput.getText()), Integer.parseInt(volumeInput.getText()),
                Integer.parseInt(alcoholPercentageInput.getText()), countryInput.getText(), imgURLInput.getText());
    }

    private void closePane(){
        this.getPane().toBack();
        clearFields();
    }

    @FXML
    private void onClose(){
        closePane();
    }

    private void clearFields()
    {
        productNameInput.clear();
        category1Input.clear();
        category2Input.clear();
        priceInput.clear();
        volumeInput.clear();
        alcoholPercentageInput.clear();
        alcoholPercentageInput.clear();
    }

    @FXML
    private void onImageURLEdit(){

    }
}

