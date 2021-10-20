package shedbolaget.model.categories;

import org.junit.Assert;
import org.junit.Test;

public class TestCategory {
    @Test
    public void testCategoryEquals() {
        Category category1 = new Category("Test", 3);
        Category category2 = new Category("Test", 3);
        Assert.assertEquals(category1, category2);
        Assert.assertEquals(category1, category1);
    }
}
