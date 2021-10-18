package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import shedbolaget.model.products.Product;

/**
 * @author Samuel Kajava
 */
public class BasicProductCardComponent extends Component {
    private final Product product;
    @FXML
    private ImageView imageView;
    @FXML
    private Text nameBoldText;
    @FXML
    private Label nameThinLabel;
    @FXML
    private Text priceText;
    @FXML
    private Button favoriteButton;
    private boolean isFavorite;

    public BasicProductCardComponent(Product product) {
        super("BasicProductCardView");
        this.product = product;
        this.isFavorite = false;
        //isFavorite = model.isFavorite(product);
        Image productImage = new Image(product.getImageUrl(Product.ImageSize.MEDIUM), 0, 0, false, false, true);
        imageView.setImage(productImage);
        nameBoldText.setText(product.getProductNameBold());
        nameThinLabel.setText(product.getProductNameThin());
        priceText.setText(String.format("%.2f:-", product.getPrice()));
        favoriteButton.getStyleClass().add(getFavoriteIconClass());
    }

    @FXML
    void favoriteButtonOnClick(ActionEvent event) {
        /*
        if (isFavorite) {
            model.removeFromFavorites(product);
        } else {
            model.addToFavorites(product);
        }

         */
        favoriteButton.getStyleClass().remove("non-favorite-icon");
        favoriteButton.getStyleClass().remove("favorite-icon");
        isFavorite = !isFavorite;
        favoriteButton.getStyleClass().add(getFavoriteIconClass());
        System.out.println(favoriteButton.getStyleClass().toString());
    }

    private String getFavoriteIconClass() {
        return isFavorite ?  "favorite-icon" : "non-favorite-icon";
    }
}
