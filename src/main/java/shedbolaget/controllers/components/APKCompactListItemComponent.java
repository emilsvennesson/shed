package shedbolaget.controllers.components;


import javafx.fxml.FXML;
import javafx.scene.text.Text;
import shedbolaget.model.products.Product;


public class APKCompactListItemComponent extends Component {

    @FXML
    private Text placeText;

    @FXML
    private Text productNameText;

    @FXML
    private Text apkText;

    @FXML
    private Text priceText;


    protected APKCompactListItemComponent(Product product, int ranking) {
        super("APKCompactListItemView");
        updateTextWithProduct(product, ranking);
    }

    private void updateTextWithProduct(Product product, int ranking) {
        placeText.setText(String.format("%d", ranking));
        productNameText.setText(String.format("%s - %s",product.getFullProductName(), product.getCategoryLevel1().getName()));
        apkText.setText(String.format("%.2f", product.getApk()));
        priceText.setText(String.format("%.2f:-", product.getPrice()));
    }
}

