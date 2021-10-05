package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
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

    private final Product product;

    public BasicProductCardController(Product product) {
        this.product = product;
    }

    @FXML
    public void initialize() throws IOException {
        DecimalFormat costFormat = new DecimalFormat("#.##");
        nameBoldText.setText(product.getProductNameBold());
        nameThinLabel.setText(product.getProductNameThin());
        priceText.setText(costFormat.format(product.getPrice()) + " kr");
    }
}
