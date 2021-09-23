package shedbolaget.controllers;

import backend.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class BasicProductCardController extends BaseController {
    @FXML
    private ImageView imageView;

    @FXML
    private Text nameBoldText;

    @FXML
    private Label nameThinLabel;

    @FXML
    private Text priceText;

    private Product product;

    public BasicProductCardController(Product product) {
        super("BasicProductCardView.fxml");
        this.product = product;
        initProduct();
    }

    private void initProduct() {
        DecimalFormat costFormat = new DecimalFormat("#.##");
        nameBoldText.setText(product.getProductNameBold());
        nameThinLabel.setText(product.getProductNameThin());
        priceText.setText(costFormat.format(product.getPrice()) + " kr");
    }
}
