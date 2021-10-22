package shedbolaget.model.events;

/**
 * This event can be fired to notify listeners to change page.
 *
 * @author Emil Svensson
 */
public class NavigationEvent {
    private final NAVIGATION pageToNavigateTo;

    /**
     * Instantiates a new Navigation event.
     *
     * @param pageToNavigateTo the page to navigate to
     */
    public NavigationEvent(NAVIGATION pageToNavigateTo) {
        this.pageToNavigateTo = pageToNavigateTo;
    }

    /**
     * Gets page to navigate to.
     *
     * @return the page to navigate to
     */
    public NAVIGATION getPageToNavigateTo() {
        return pageToNavigateTo;
    }

    /**
     * This enum contains the available page to navigate to.
     */
    public enum NAVIGATION {
        MAIN,
        PRODUCTS,
        FAVORITES,
        APK,
        DRINKGENERATOR,
        DRINKlIST,
        SEARCH
    }


}
