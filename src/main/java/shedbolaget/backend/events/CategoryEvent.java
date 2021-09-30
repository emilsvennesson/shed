package shedbolaget.backend.events;

public class CategoryEvent {
    private final String currentCategoryLevel1;

    public CategoryEvent(String current) {
        this.currentCategoryLevel1 = current;
    }

    public String getCurrentCategoryLevel1() {
        return currentCategoryLevel1;
    }

}
