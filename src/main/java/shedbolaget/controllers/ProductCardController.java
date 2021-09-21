package shedbolaget.controllers;

import backend.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;

public class ProductCardController extends BaseController {
    public static DecimalFormat costFormat = new DecimalFormat("#.##");
    @FXML
    private ImageView imageView;

    @FXML
    private Label nameBoldLabel;

    @FXML
    private Label nameThinLabel;

    @FXML
    private Label priceLabel;

    private Product product;

    public ProductCardController(Product product) {
        super("ProductCardView.fxml");
        this.product = product;
    }

    private void initProduct() {
        nameBoldLabel.setText(product.productNameBold);
        //productNameThinLabel.setText(product.productNameThin);;
        priceLabel.setText(costFormat.format(product.price) + " " + "kr");
    }
}
