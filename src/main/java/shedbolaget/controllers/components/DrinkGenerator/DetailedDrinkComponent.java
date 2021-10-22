package shedbolaget.controllers.components.DrinkGenerator;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import jdk.jfr.Event;
import shedbolaget.controllers.components.Component;
import shedbolaget.model.drinks.Drink;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.ShowDrinkEvent;


public class DetailedDrinkComponent extends Component {

    @FXML
    private Text TitelText;

    @FXML
    private Text GlassText;

    @FXML
    private Text InstructionesText;

    @FXML
    private ImageView DrinkImageView;

    @FXML
    private ListView IngredientsListView;

    public DetailedDrinkComponent() {
        super("DetailedDrinkView");
        EventManager.getInstance().registerToEventBus(this);
    }


    @Subscribe
    public void showDrink(ShowDrinkEvent event){
        TitelText.setText(event.getDrink().getName());
        GlassText.setText(event.getDrink().getGlass());
        InstructionesText.setText(event.getDrink().getInstructions());
        IngredientsListView.getItems().clear();
        for (Ingredient ingredient :
                event.getDrink().getAlcoIngredients()) {
            IngredientsListView.getItems().add(ingredient.getName()+ " : " + ingredient.measure);
        }
        for (Ingredient ingredient :
                event.getDrink().getNoingredients()) {
            IngredientsListView.getItems().add(ingredient.getName()+ " : " + ingredient.measure);
        }
        DrinkImageView.setImage(new Image(event.getDrink().getImageUrl()));
        this.getPane().toFront();

        
    }
    @FXML
    void onClose(MouseEvent event) {
        this.getPane().toBack();
    }
}
