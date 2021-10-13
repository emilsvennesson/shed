package shedbolaget.model.events;

import shedbolaget.model.categories.Category;

import java.util.List;

public class CategoryEvent {
    private final List<Category> activeCategories;

    public CategoryEvent(List<Category> activeCategories) {
        this.activeCategories = activeCategories;
    }

    public List<Category> getActiveCategories() {
        return activeCategories;
    }

    public boolean isCleared() {
        return activeCategories.isEmpty();
    }
}
