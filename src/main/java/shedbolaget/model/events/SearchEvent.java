package shedbolaget.model.events;

public class SearchEvent {
    private final String searchString;

    public SearchEvent(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }

    public boolean isEmptySearch() {
        return searchString.isEmpty();
    }

    public int getSearchLength() {
        return searchString.length();
    }
}
