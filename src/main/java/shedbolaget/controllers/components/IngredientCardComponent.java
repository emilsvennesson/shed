package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.model.products.Product;

public class IngredientCardComponent extends Component{



    @FXML
    private AnchorPane cardAnchorPane;

    @FXML
    private AnchorPane cardAnchorPane1;

    @FXML
    private ImageView imageView1;

    @FXML
    private VBox nameVBox1;

    @FXML
    private Text nameBoldText1;

    @FXML
    private Text nameThinText1;

    @FXML
    private VBox addButton;

    @FXML
    private Button favoritesButton1;

    @FXML
    private VBox removeButton;

    @FXML
    private Button favoritesButton11;

    protected IngredientCardComponent(Product product) {
        super("IngredientCardView");
    }
    protected IngredientCardComponent() {
        super("IngredientCardView");
    }

    @FXML
    void addButtonOnClick(ActionEvent event) {

    }

    @FXML
    void cardOnClick(MouseEvent event) {

    }

    @FXML
    void removeButtonOnClick(ActionEvent event) {

    }

}
