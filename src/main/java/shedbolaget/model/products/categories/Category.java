package shedbolaget.model.products.categories;

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
        return Objects.equals(name, ((Category) o).getName()) && level == ((Category) o).getLevel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

    public String getName() {
        return name;
    }
}
