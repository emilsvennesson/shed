package shedbolaget.controllers;

import backend.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;

public class BasicProductCardController extends BaseController {
    @FXML
    private ImageView imageView;

    @FXML
    private Label nameBoldLabel;

    @FXML
    private Label nameThinLabel;

    @FXML
    private Label priceLabel;

    private Product product;

    public BasicProductCardController(Product product) {
        super("BasicProductCardView.fxml");
        this.product = product;
        initProduct();
    }

    private void initProduct() {
        DecimalFormat costFormat = new DecimalFormat("#.##");
        nameBoldLabel.setText(product.getProductNameBold());
        nameThinLabel.setText(product.getProductNameThin());
        priceLabel.setText(costFormat.format(product.getPrice()) + " kr");
    }
}
