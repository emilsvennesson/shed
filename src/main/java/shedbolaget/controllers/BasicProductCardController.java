package shedbolaget.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.io.IOException;
import java.text.DecimalFormat;

public class BasicProductCardController {
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

    private final Product product;
    private boolean isFavorite;
    private Model model;

    public BasicProductCardController(Product product) {
        this.product = product;
        this.model = Model.getInstance();
    }

    @FXML
    public void initialize() throws IOException {
        isFavorite = model.isFavorite(product);
        Image productImage = new Image(model.getProductImageUrl(product, Model.ImageSize.MEDIUM), 0, 0, false, false, true);
        imageView.setImage(productImage);
        nameBoldText.setText(product.getProductNameBold());
        nameThinLabel.setText(product.getProductNameThin());
        priceText.setText(String.format("%.2f:-",product.getPrice()));
        favoriteButton.setText(getFavoriteButtonText());
    }

    @FXML
    void favoriteButtonOnClick(ActionEvent event) {
        if(isFavorite) {
            model.removeFromFavorites(product);
        } else {
            model.addToFavorites(product);
        }
        isFavorite = !isFavorite;
        favoriteButton.setText(getFavoriteButtonText());
    }

    private String getFavoriteButtonText() {
        return isFavorite ? "</3" : "<3";
    }
}
