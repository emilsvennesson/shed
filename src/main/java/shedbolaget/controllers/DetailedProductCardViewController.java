package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

import java.io.IOException;

public class DetailedProductCardViewController {
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
    private Text priceText;

    @FXML
    private Button favoritesButton;

    private final Product product;
    private Model model;

    public DetailedProductCardViewController(Product product) {
        // temporary, wont pass a datahandler later on
        this.product = product;
        this.model = model.getInstance();
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
    }
}
