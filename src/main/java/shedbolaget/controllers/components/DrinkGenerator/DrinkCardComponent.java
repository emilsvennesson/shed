package shedbolaget.controllers.components.DrinkGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.controllers.components.Component;
import shedbolaget.model.drinks.Drink;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.ShowDrinkEvent;

/**
 * @author Daniel Rygaard
 */
public class DrinkCardComponent extends Component {
    Drink drink;
    public DrinkCardComponent(Drink drink) {
        super("DrinkCardView");
        this.drink = drink;
        initFields();
    }




    @FXML
    private AnchorPane cardAnchorPane;

    @FXML
    private ImageView imageView;

    @FXML
    private VBox nameVBox;

    @FXML
    private Text nameBoldText;

    @FXML
    private Text nameThinText;

    @FXML
    private Text IngredientsCount;

    @FXML
    private Text volumeText;

    @FXML
    private Text apkText;

    @FXML
    private Text priceText;


    @FXML
    void cardOnClick(MouseEvent event) {
        EventManager.getInstance().fireEvent(new ShowDrinkEvent(this.drink));
    }

    @FXML
    void detailsButtonOnClick(ActionEvent event) {
        EventManager.getInstance().fireEvent(new ShowDrinkEvent(this.drink));

    }

    /*----------------------------------- Private methods -----------------------------------*/
    private void initFields(){
        this.nameBoldText.setText(drink.getName());
        this.nameThinText.setText(drink.getGlass());

        this.IngredientsCount.setText("Ingredients: " + drink.getAlcoIngredients().size());
        //this.apkText.setText("APK: " + drink.getAPK());


        Image productImage = new Image(drink.getImageUrl(), 0, 0, false, false, true);
        this.imageView.setImage(productImage);

    }


}
