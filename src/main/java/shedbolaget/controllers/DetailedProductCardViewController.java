package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
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

    public DetailedProductCardViewController(Product product) {
        this.product = product;
    }

    @FXML
    public void initialize() throws IOException {
        this.nameBoldText.setText(this.product.getProductNameBold());
    }
}
