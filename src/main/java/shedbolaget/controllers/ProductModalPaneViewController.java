package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import shedbolaget.model.Model;
import shedbolaget.model.Product;

public class ProductModalPaneViewController {
    @FXML
    private Text productNameText;

    @FXML
    private Text categoryLevel2Text;

    @FXML
    private Text countryText;

    @FXML
    private Text descriptionText;

    @FXML
    private ImageView productImageView;

    @FXML
    private Text priceText;

    @FXML
    private Text apkText;

    @FXML
    private Text volumeText;

    @FXML
    private Text alcoholPercentageText;

    private final Product product;

    public ProductModalPaneViewController(Product product) {
        this.product = product;
    }

    @FXML
    public void initialize() {
        productImageView.setImage(new Image(Model.getInstance().getProductImageUrl(product, Model.ImageSize.LARGE)));
        productNameText.setText(product.getProductNameBold());
        categoryLevel2Text.setText(product.getCategoryLevel2());
        countryText.setText(product.getCountry());
        descriptionText.setText("TODO: add description, lorem ipsum dolor sit amet i want to go home");
        priceText.setText(String.format("%.3f:-", product.getPrice()));
        volumeText.setText(String.format("%.0f ml", product.getVolume()));
        alcoholPercentageText.setText(String.format("%.1f %%", product.getAlcoholPercentage()));
    }

}

