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

    @FXML
    private VBox secondPlaceVBox;
    @FXML
    private Text secondPlaceInfoText;


    @FXML
    private VBox thirdPlaceVBox;
    @FXML
    private Text thirdPlaceInfoText;


    protected APKTop3Component() {
        super("APKTop3View");
        List<Product> all = ProductsHolder.getInstance().getAllProducts();
        List<Product> filteredList = Filter.getFilteredProductsByCategory(Sorter.getProductListSortedByApk(all), Categories.getLevel1Categories(all));
        populateTop3(filteredList);
    }

    private void populateTop3(List<Product> products) {
        secondPlaceVBox.getChildren().add(1, ComponentFactory.createBasicProductCard(products.get(0)));
        firstPlaceVBox.getChildren().add(1, ComponentFactory.createBasicProductCard(products.get(1)));
        thirdPlaceVBox.getChildren().add(1, ComponentFactory.createBasicProductCard(products.get(2)));
    }

    private void loadTop3(List<Product> products) {
        secondPlaceVBox.getChildren().remove(1);
        firstPlaceVBox.getChildren().remove(1);
        thirdPlaceVBox.getChildren().remove(1);
        System.out.println(products.get(0).getProductNameBold());
        populateTop3(products);
    }

    @Subscribe
    private void actOnCategoryEvent(CategoryEvent event) {
        ProductsHolder productsHolder = ProductsHolder.getInstance();
        List<Product> filteredProducts = Filter.getFilteredProductsByCategory(productsHolder.getAllProducts(), event.getActiveCategories());
        if (!filteredProducts.isEmpty())
            loadTop3(filteredProducts.subList(0,3));
    }


}

