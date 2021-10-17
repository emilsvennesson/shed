package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.model.products.Product;

/**
 * @author Samuel Kajava
 */
public class DetailedProductCardComponent extends Component {
    private final Product product;
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
    private Text producerText;
    @FXML
    private Text colorText;
    @FXML
    private Text tasteText;
    @FXML
    private Text usageText;
    @FXML
    private Text priceText;
    @FXML
    private Button favoritesButton;
    @FXML
    private VBox descriptionVBox;

    private boolean expanded;
    private boolean isFavorite;

    public DetailedProductCardComponent(Product product) {
        super("DetailedProductCardView");
        this.product = product;
        this.expanded = false;
        initProductInfo();
        //this.isFavorite = model.isFavorite(product);
    }

    public void initProductInfo() {
        nameBoldText.setText(this.product.getFullProductName()); //TODO: split into bold and thin
        Image productImage = new Image(product.getImageUrl(Product.ImageSize.MEDIUM), 0, 0, false, false, true);
        imageView.setImage(productImage);
        alcoholPercentageText.setText(String.format("Alkoholhalt: %.1f %%", product.getAlcoholPercentage()));
        volumeText.setText(String.format("%.0f ml", product.getVolume()));
        apkText.setText(String.format("APK: %.2f", product.getApk()));
        categoryLevel2Text.setText(product.getCategoryLevel2().getName());
        countryText.setText(product.getCountry());
        priceText.setText(String.format("%.2f:-", product.getPrice()));
        producerText.setText(product.getProducerName());
        colorText.setText(product.getColor());
        tasteText.setText(product.getTaste());
        usageText.setText(product.getUsage());
        initFavoriteButton();
        closeProductCard();
    }

    @FXML
    void cardOnClick(MouseEvent event) {
        if (!expanded)
            expandProductCard();
        else
            closeProductCard();
    }

    private void expandProductCard() {
        if (!descriptionVBox.getChildren().contains(expandedHBox)) {
            descriptionVBox.getChildren().add(expandedHBox);
            expanded = true;
        }
    }

    @FXML
    void favoritesButtonOnClick(ActionEvent event) {
        if (isFavorite) {
            //model.removeFromFavorites(product);
        } else {
            //model.addToFavorites(product);
        }
        favoritesButton.getStyleClass().remove(getFavoriteButtonClass());
        isFavorite = !isFavorite;
        favoritesButton.setText(getFavoriteButtonText());
        favoritesButton.getStyleClass().add(getFavoriteButtonClass());
    }

    private void closeProductCard() {
        descriptionVBox.getChildren().remove(expandedHBox);
        expanded = false;
    }

    private String getFavoriteButtonText() {
        return (isFavorite ? "Ta bort favorit" : "Lägg till favorit");
    }

    private String getFavoriteButtonClass() {
        return (isFavorite ? "remove-favorite-btn" : "add-favorite-btn");
    }

    private void initFavoriteButton() {
        favoritesButton.getStyleClass().add(getFavoriteButtonClass());
        favoritesButton.setText(getFavoriteButtonText());
    }
}
