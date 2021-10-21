package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.pages.Pages;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 */
public class MainPage extends Component {
    @FXML
    private AnchorPane navBarPane;

    @FXML
    private FlowPane newProductsFlowPane;

    @FXML
    private Text welcomeText;

    protected MainPage() {
        super("MainView");
        initNewProducts();

        welcomeText.setText("Sök och sortera bland "
                + ProductModel.getInstance().getNumberOfProducts()
                + " produkter.");
    }

    private void initNewProducts() {
        Pages pages = new Pages(ProductModel.getInstance().getProducts());
        for (Product product : pages.getProductsFromPage(1)) // replace with actual new products?
            newProductsFlowPane.getChildren().add(ComponentFactory.createBasicProductCard(product));
    }


}


