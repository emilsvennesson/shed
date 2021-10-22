package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.filter.Filter;
import shedbolaget.model.products.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

public class APKLeaderboardPage extends Component {

    @FXML
    private FlowPane contentFlowPane;

    @FXML
    private VBox contentVBox;

    protected APKLeaderboardPage() {
        super("APKLeaderboardView");
        populateView();
        eventManager.registerToEventBus(this);
    }

    private void populateView() {
        contentVBox.getChildren().add(1, ComponentFactory.createAPKTop3());
        initListItems();
    }

    private void initListItems() {
        List<Product> products = Sorter.getProductListSortedByApk(ProductModel.getInstance().getProducts(), true);
        for (Product product : products.subList(3, 100)) {
            contentVBox.getChildren().add(new APKCompactListItemComponent(product, products.indexOf(product) + 1).getPane());
        }
    }
}
