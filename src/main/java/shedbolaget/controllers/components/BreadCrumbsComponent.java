package shedbolaget.controllers.components;

import com.google.common.eventbus.Subscribe;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import shedbolaget.model.categories.Category;
import shedbolaget.model.events.CategoryEvent;
import shedbolaget.model.events.EventManager;
import shedbolaget.model.events.SearchEvent;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author Emil Svensson
 */
public class BreadCrumbsComponent extends Component {

    @FXML
    private Text categoryLevel1Text;

    @FXML
    private Text categoryLevel2Text;

    protected BreadCrumbsComponent() {
        super("BreadCrumbsView");
        categoryLevel2Text.setVisible(false);
        EventManager.getInstance().registerToEventBus(this);
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
        categoryLevel1Text.setText(getCategoryLevelText(event.getActiveCategories(), 1));
        if (!getCategoryLevelText(event.getActiveCategories(), 1).isEmpty()) {
            categoryLevel2Text.setText(getCategoryLevelText(event.getActiveCategories(), 2));
            categoryLevel2Text.setVisible(true);
        } else
            categoryLevel2Text.setVisible(false);
    }

    @Subscribe
    public void actOnSearchEvent(SearchEvent event) {
        categoryLevel1Text.setText("Sökresultat för " + event.getSearchString());
        categoryLevel2Text.setVisible(false);
    }
}