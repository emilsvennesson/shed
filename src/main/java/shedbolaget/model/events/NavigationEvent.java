package shedbolaget.model.events;

public class NavigationEvent {
    private final NAVIGATION pageToNavigateTo;

    public NavigationEvent(NAVIGATION pageToNavigateTo) {
        this.pageToNavigateTo = pageToNavigateTo;
    }

    public NAVIGATION getPageToNavigateTo() {
        return pageToNavigateTo;
    }

    public enum NAVIGATION {
        MAIN,
        PRODUCTS,
        FAVORITES
    }


}
