package shedbolaget.model.events;

import shedbolaget.model.products.categories.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * This event can be fired to notify listeners that a category has been changed.
 *
 * @author Emil Svensson
 * @see Category
 */
public class CategoryEvent {
    private final List<Category> activeCategories;

    /**
     * Instantiates a new Category event.
     *
     * @param activeCategories the active categories
     */
    public CategoryEvent(List<Category> activeCategories) {
        this.activeCategories = activeCategories;
    }

    /**
     * Gets active categories.
     *
     * @return the active categories
     */
    public List<Category> getActiveCategories() {
        return new ArrayList<>(activeCategories);
    }

    /**
     * Checks if active categories list is empty.
     *
     * @return whether the active categories list is empty or not
     */
    public boolean isCleared() {
        return activeCategories.isEmpty();
    }
}
