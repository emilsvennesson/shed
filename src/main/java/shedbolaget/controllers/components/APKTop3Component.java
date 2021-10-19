package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.SortEvent;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductsHolder;
import shedbolaget.model.products.filter.Filter;
import shedbolaget.model.products.sorter.Sorter;

import java.util.List;

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
        List<Product> all = ProductsHolder.getInstance().getAllProducts();
        List<Product> filteredList = Filter.getFilteredProductsByCategory(Sorter.getProductListSortedByApk(all), Categories.getLevel1Categories(all));
        populateTop3(filteredList);
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

    @Subscribe
    private void actOnCategoryEvent(CategoryEvent event) {
        ProductsHolder productsHolder = ProductsHolder.getInstance();
        List<Product> filteredProducts = Sorter.getProductListSortedByApk(Filter.getFilteredProductsByCategory(productsHolder.getAllProducts(), event.getActiveCategories()), true);
        if (!filteredProducts.isEmpty())
            loadTop3(filteredProducts.subList(0, 3));
    }


}

