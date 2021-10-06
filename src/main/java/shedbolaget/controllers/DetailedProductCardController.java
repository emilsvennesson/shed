package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.io.IOException;

public class DetailedProductCardController {
    @FXML
    private AnchorPane cardAnchorPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Text nameBoldText;

    @FXML
    private Text alcoholPercentageText;

    @FXML
    private Text volumeText;

    @FXML
    private Text apkText;

    @FXML
    private Text categoryLevel2Text;

    @FXML
    private Text countryText;

    @FXML
    private HBox expandedHBox;

    @FXML
    private Text descriptionText;

    @FXML
    private Text colorText;

    @FXML
    private Text tasteText;

    @FXML
    private Text suitsText;

    @FXML
    private Text priceText;

    @FXML
    private Button favoritesButton;

    @FXML
    private VBox descriptionVBox;

    private final Product product;
    private Model model;

    private boolean expanded;

    public DetailedProductCardController(Product product) {
        // temporary, wont pass a datahandler later on
        this.product = product;
        this.model = Model.getInstance();
        this.expanded = false;
    }

    @FXML
    public void initialize() throws IOException {
        nameBoldText.setText(this.product.getProductNameBold());
        //Image productImage = new Image(model.getProductImageUrl(product, Model.ImageSize.MEDIUM), 0, 0, false, false);
        //imageView.setImage(productImage);
        alcoholPercentageText.setText(String.format("Alkoholhalt: %.1f %%", product.getAlcoholPercentage()));
        volumeText.setText(String.format("%.0f ml", product.getVolume()));
        apkText.setText(String.format("APK: %.2f", product.getApk()));
        categoryLevel2Text.setText(product.getCategoryLevel2());
        countryText.setText(product.getCountry());
        priceText.setText(String.format("%.2f:-", product.getPrice()));
        closeProductCard();
    }

    @FXML
    void cardOnClick(MouseEvent event) throws IOException {
        if(!expanded)
            expandProductCard();
        else
            closeProductCard();
    }

    private void expandProductCard() {
        if(!descriptionVBox.getChildren().contains(expandedHBox)) {
            descriptionVBox.getChildren().add(expandedHBox);
            expanded = true;
        }
    }

    private void closeProductCard() {
        descriptionVBox.getChildren().remove(expandedHBox);
        expanded = false;
    }
}
