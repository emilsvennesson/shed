package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import shedbolaget.backend.DataHandler;
import shedbolaget.backend.Product;

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
    private DataHandler dh;

    public DetailedProductCardViewController(Product product) {
        // temporary, wont pass a datahandler later on
        this.product = product;
        this.dh = new DataHandler();
    }

    @FXML
    public void initialize() throws IOException {
        nameBoldText.setText(this.product.getProductNameBold());
        Image productImage = new Image(dh.getProductImageUrl(product, DataHandler.ImageSize.MEDIUM), 0, 0, false, false);
        imageView.setImage(productImage);

        //alcoholPercentageText.setText(String.format("Alkoholhalt: %.1f %%", product.));
    }
}
