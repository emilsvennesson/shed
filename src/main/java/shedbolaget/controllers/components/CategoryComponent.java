package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import shedbolaget.model.categories.Categories;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.SearchEvent;
import shedbolaget.model.products.ProductModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Emil Svensson
 */
public class CategoryComponent extends Component {
    private Category activeLevel1Category;
    List<CheckBox> checkBoxes;

    @FXML
    private CheckBox categoryLevel1CheckBox;

    @FXML
    private VBox categoryLevel2VBox;

    protected CategoryComponent() {
        super("CategoryView");
        eventManager.registerToEventBus(this);
        this.categoryLevel1CheckBox.setSelected(true);
        categoryLevel1CheckBox.setOnAction(this::onChecked);
    }

    @SuppressWarnings("PMD.UnusedFormalParameter")
    private void onChecked(ActionEvent actionEvent) {
        categoryLevel1CheckBox.setSelected(true);
    }

    private void initLevel2CheckBoxes(List<Category> categories) {
        categoryLevel2VBox.getChildren().clear();
        Category activeLevel1Category = Categories.getCategoriesByLevel(categories, 1).get(0);
        checkBoxes = new ArrayList<>();
        for (Category level2Category : Categories.getAssociatedLevel2Categories(ProductModel.getInstance().getProducts(), activeLevel1Category)) {
            CheckBox checkBox = new CheckBox(level2Category.getName());
            checkBox.setOnAction(event -> {
                if (checkBox.isSelected()) {
                    categories.add(level2Category);
                    eventManager.fireEvent(new CategoryEvent(categories));
                } else {
                    categories.remove(level2Category);
                    eventManager.fireEvent(new CategoryEvent(categories));
                }
            });
            categoryLevel2VBox.getChildren().add(checkBox);
        }
    }

    @SuppressWarnings("PMD.UnusedPrivateMethod")
    @Subscribe
    private void actOnCategoryEvent(CategoryEvent event) {
        this.getPane().setVisible(true);
        Category eventActiveLevel1Category = Categories.getCategoriesByLevel(event.getActiveCategories(), 1).get(0);
        if (eventActiveLevel1Category != activeLevel1Category) {
            activeLevel1Category = eventActiveLevel1Category;
            initLevel2CheckBoxes(event.getActiveCategories());
        }
        categoryLevel1CheckBox.setText(activeLevel1Category.getName());
    }

    @SuppressWarnings({"PMD.UnusedPrivateMethod", "PMD.UnusedFormalParameter"})
    @Subscribe
    private void actOnSearchEvent(SearchEvent event) {
        this.getPane().setVisible(false);
    }
}
