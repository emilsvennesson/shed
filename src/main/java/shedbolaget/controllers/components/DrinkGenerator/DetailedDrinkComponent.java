package shedbolaget.controllers.components.DrinkGenerator;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import shedbolaget.controllers.components.Component;
import shedbolaget.model.drinks.Ingredient;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.ShowDrinkEvent;

import java.util.List;

/**
 * @author Daniel Rygaard
 */
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
        addIngredients(event.getDrink().getAlcoIngredients());
        addIngredients(event.getDrink().getNoingredients());
        DrinkImageView.setImage(new Image(event.getDrink().getImageUrl()));
        this.getPane().toFront();

        
    }
    private void addIngredients(List<Ingredient> ingredientList){
        for (Ingredient ingredient :
                ingredientList) {
            StringBuilder builder = new StringBuilder();
            builder.append(ingredient.getName());

            if(ingredient.measure != null){
                builder.append(" : ");
                builder.append(ingredient.measure);
            }

            IngredientsListView.getItems().add(builder.toString());
        }

    }

    @FXML
    void onClose(MouseEvent event) {
        this.getPane().toBack();
    }
}
