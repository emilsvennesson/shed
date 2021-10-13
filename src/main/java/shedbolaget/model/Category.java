package shedbolaget.model;

import java.util.Objects;

/**
 * Represents a product category.
 *
 * @author Emil Svensson
 */
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

    @Override
    public boolean equals(Object o) {
        // override equals and match category name
        if (getClass() != o.getClass())
            return false;
        if (o == this)
            return true;
        return Objects.equals(this.getName(), ((Category) o).getName()) && this.getLevel() == ((Category) o).getLevel();
    }

    public String getName() {
        return name;
    }
}
