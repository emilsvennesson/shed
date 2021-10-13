package shedbolaget.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Categories {
    private final List<Product> products;
    private final HashMap<Category, List<Category>> categories = new HashMap<>();

    Categories(List<Product> products) {
        this.products = products;
        initCategories();
    }

    private List<Category> getCategoriesLevel1() {
        List<Category> categories = new ArrayList<>();
        for (Product product : products)
            if (!categories.contains(product.getCategoryLevel1()))
                categories.add(product.getCategoryLevel1());
        return categories;
    }

    private List<Category> getCategoriesLevel2(Category categoryLevel1) {
        List<Category> categories = new ArrayList<>();
        for (Product product : products)
            if (Objects.equals(product.getCategoryLevel1().getName(), categoryLevel1.getName()) && !categories.contains(product.getCategoryLevel2()))
                categories.add(product.getCategoryLevel2());
        return categories;
    }

    public HashMap<Category, List<Category>> getCategories() {
        return new HashMap<>(categories);
    }

    private void initCategories() {
        for (Category level1Category : getCategoriesLevel1())
            categories.put(level1Category, getCategoriesLevel2(level1Category));
    }
}
