package shedbolaget.controllers.components.DrinkGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.controllers.components.Component;
import shedbolaget.model.drinks.Drink;

public class DrinkCardComponent extends Component {
    Drink drink;
    protected DrinkCardComponent(Drink drink) {
        super("DrinkCardView");
        this.drink = drink;
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
    private Button favoritesButton;

    @FXML
    void cardOnClick(MouseEvent event) {

    }

    @FXML
    void favoritesButtonOnClick(ActionEvent event) {

    }

    /*----------------------------------- Private methods -----------------------------------*/
    private void initFields(){
        nameBoldText.setText(drink.getName());
        nameThinText.setText(drink.strGlass);

        IngredientsCount.setText("Ingredients: " + drink.getAlcoIngredients().size());
        apkText.setText("APK: " + drink.getAPK());
        volumeText.setText("Volume: "+drink.getVolume());

    }


}
