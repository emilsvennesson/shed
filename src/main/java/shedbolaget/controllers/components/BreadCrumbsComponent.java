package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;

import java.util.List;
import java.util.StringJoiner;

public class BreadCrumbsComponent extends Component {

    @FXML
    private Text categoryLevel1Text;

    @FXML
    private Text categoryLevel2Text;

    protected BreadCrumbsComponent() {
        super("BreadCrumbsView");
        categoryLevel2Text.setVisible(false);
    }

    private String getCategoryLevelText(List<Category> categories, int level) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Category c : categories) {
            if (c.getLevel() == level)
                stringJoiner.add(c.getName());
        }
        return stringJoiner.toString();
    }

    @Subscribe
    public void actOnCategoryEvent(CategoryEvent event) {
        // TODO: we need to refactor frontend to avoid this
        if (event.isCleared()) {
            //model.unregisterFromEventBus(this);
            return;
        }
        categoryLevel1Text.setText(getCategoryLevelText(event.getActiveCategories(), 1));
        if (!getCategoryLevelText(event.getActiveCategories(), 1).isEmpty()) {
            categoryLevel2Text.setText(getCategoryLevelText(event.getActiveCategories(), 2));
            categoryLevel2Text.setVisible(true);
        } else
            categoryLevel2Text.setVisible(false);
    }
}