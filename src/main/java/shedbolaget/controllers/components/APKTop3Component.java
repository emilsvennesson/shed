package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.sorter.Sorter;

import java.util.List;

/**
 * @author Samuel Kajava
 */
public class APKTop3Component extends Component {

    @FXML
    private VBox firstPlaceVBox;
    @FXML
    private Text firstPlaceInfoText;
    private Product firstPlaceProduct;

    @FXML
    private VBox secondPlaceVBox;
    @FXML
    private Text secondPlaceInfoText;
    private Product secondPlaceProduct;


    @FXML
    private VBox thirdPlaceVBox;
    @FXML
    private Text thirdPlaceInfoText;
    private Product thirdPlaceProduct;

    protected APKTop3Component() {
        super("APKTop3View");
        List<Product> all = ProductModel.getInstance().getProducts();
        populateTop3(Sorter.getProductListSortedByApk(all, true));
        eventManager.registerToEventBus(this);
    }

    private void populateTop3(List<Product> products) {
        firstPlaceProduct = products.get(0);
        secondPlaceProduct = products.get(1);
        thirdPlaceProduct = products.get(2);

        secondPlaceVBox.getChildren().add(1, ComponentFactory.createBasicProductCard(firstPlaceProduct));
        firstPlaceVBox.getChildren().add(1, ComponentFactory.createBasicProductCard(secondPlaceProduct));
        thirdPlaceVBox.getChildren().add(1, ComponentFactory.createBasicProductCard(thirdPlaceProduct));
        updateInfoText();
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    private void loadTop3(List<Product> products) {
        secondPlaceVBox.getChildren().remove(1);
        firstPlaceVBox.getChildren().remove(1);
        thirdPlaceVBox.getChildren().remove(1);
        populateTop3(products);
    }

    private void updateInfoText() {
        firstPlaceInfoText.setText(String.format("APK: %.2f", firstPlaceProduct.getApk()));
        secondPlaceInfoText.setText(String.format("APK: %.2f", secondPlaceProduct.getApk()));
        thirdPlaceInfoText.setText(String.format("APK: %.2f", thirdPlaceProduct.getApk()));
    }
}

