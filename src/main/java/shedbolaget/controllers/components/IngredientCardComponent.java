package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.model.drinks.DrinkModel;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.events.DrinkGeneratorEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.products.Product;

import java.util.List;


//TODO add Javadoc
public class IngredientCardComponent extends Component{




    @FXML
    private ImageView imageView1;


    @FXML
    private Text nameBoldText1;

    @FXML
    private Text nameThinText1;

    @FXML
    private VBox addButton;



    @FXML
    private VBox removeButton;



    Product product;

    protected IngredientCardComponent(Product product) {
        super("IngredientCardView");
        this.product = product;
        populateFields();

    }
    protected IngredientCardComponent() {
        super("IngredientCardView");
    }

    @FXML
    void addButtonOnClick(ActionEvent event) {
        if(product == null) return;
        DrinkModel.addIngredient(product);
        List<Ingredient> ingredientList = DrinkModel.get;
        EventManager.getInstance().fireEvent(new DrinkGeneratorEvent());
    }

    @FXML
    void cardOnClick(MouseEvent event) {

    }

    @FXML
    void removeButtonOnClick(ActionEvent event) {

    }

    private void populateFields(){
        if(this.product == null)return;
        this.nameBoldText1.setText(product.getProductNameBold());
        this.nameThinText1.setText(product.getProductNameThin());
        Image productImage = new Image(product.getImageUrl(Product.ImageSize.MEDIUM), 0, 0, false, false, true);
        this.imageView1.setImage(productImage);


    }

}
