package shedbolaget.model.drinks;

import org.junit.Assert;
import org.junit.Test;
import shedbolaget.model.categories.Category;
import shedbolaget.model.products.Product;
import shedbolaget.model.products.ProductsHolder;
import shedbolaget.model.products.filter.Filter;

import shedbolaget.model.drinks.parser.DrinkJsonFileParser;
import shedbolaget.model.drinks.parser.IDrinkParser;

import java.util.ArrayList;
import java.util.List;

public class TestDrinkModel {

    DrinkModel dModel = new DrinkModel();


    @Test
    public void parsing(){
        IDrinkParser parser = new DrinkJsonFileParser();
        List<Drink> hej = parser.load();

        for (Drink d :
                hej) {
            System.out.println(d.getName());
        }

    }

    @Test
    public void canFindGinDrinkWithEveryGinProduct(){


        List<Product> prods = Filter.search(ProductsHolder.getInstance().getAllProducts(), "Gin", 100);

        Assert.assertNotEquals(prods.size(), 0);

        for (Product p :
                prods) {

            dModel.reset();
            dModel.addIngredient(p);
            List<Drink> din = dModel.loadDrinks();

            Assert.assertNotEquals(din.size(), 0);


        }

        List<Drink> din = dModel.loadDrinks();
        for (Drink d:
             din) {
            System.out.println(d.getName());
        }






    }



    public void addIngredient(){
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Tequila", 2));
        List<Product> products = ProductsHolder.getInstance().getAllProducts();
        List<Product> filteredProductsList = Filter.getFilteredProductsByCategory(products, categories);

        System.out.println(filteredProductsList.get(0).getProductNameBold());


    }




}
