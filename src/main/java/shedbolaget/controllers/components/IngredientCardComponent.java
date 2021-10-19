package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    boolean added = false;


    Ingredient ingredient;

    protected IngredientCardComponent(Ingredient ingredient) {
        super("IngredientCardView");
        this.ingredient = ingredient;
        populateFields();

    }
    protected IngredientCardComponent() {
        super("IngredientCardView");
    }

    public void markAsAdded(){
        added = true;
    }
    void markAsNotAdded(){
        added = false;
    }


    @FXML
    void cardOnClick(MouseEvent event) {
        if(this.ingredient == null ) return;
        if(!added){

            DrinkModel.addIngredient(ingredient);
            List<Ingredient> ingredientList = DrinkModel.getIngredients();
            EventManager.getInstance().fireEvent(new DrinkGeneratorEvent(ingredientList));
        }else{

            DrinkModel.removeIngredient(ingredient);
            List<Ingredient> ingredientList = DrinkModel.getIngredients();
            EventManager.getInstance().fireEvent(new DrinkGeneratorEvent(ingredientList));
        }


    }


    private void populateFields(){
        if(this.ingredient == null)return;
        this.nameBoldText1.setText(ingredient.getProd().getProductNameBold());
        this.nameThinText1.setText(ingredient.getProd().getProductNameThin());
        Image productImage = new Image(ingredient.getProd().getImageUrl(Product.ImageSize.MEDIUM), 0, 0, false, false, true);
        this.imageView1.setImage(productImage);


    }

}
