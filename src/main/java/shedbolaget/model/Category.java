package shedbolaget.model;

public class Category {
    private final String name;
    private final int level;

    public Category(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
