package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import shedbolaget.model.events.CustomProductCreatedEvent;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductModel;
import shedbolaget.model.products.sorter.Sorter;

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

    @Subscribe
    private void onNewCustomEvent(CustomProductCreatedEvent event){
        reloadToplist();
    }

    private void reloadToplist(){
        contentVBox.getChildren().remove(1);
        contentVBox.getChildren().remove(2, contentVBox.getChildren().size());
        populateView();
    }
}
