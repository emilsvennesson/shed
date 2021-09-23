package backend;

import backend.favorites.ProductIdListsIOManager;
import backend.favorites.SavableProductIdList;
import backend.parser.ParserFactory;
import backend.parser.IProductParser;

import java.util.List;

public class DataHandler {
    private List<Product> products;
    private ProductIdListsIOManager ListIOManager;
    private Filter filter;


    public List<Product> getProducts() {
        return products;
    }


    /*------------------- Parsing ---------------------*/

    private void populateProducts(IProductParser parser) {
        products = parser.getProducts();
    }


    /*------------------- Favorites ---------------------*/


    /**
     * <p>Adds a {@link Product} to favorites</p>
     *
     * @param prod the {@link Product} that is added
     */
    public void addToFavorites(Product prod) {
        SavableProductIdList favList = ListIOManager.getList("Favorites");

        if (favList == null) ListIOManager.addList(new SavableProductIdList("Favorites"));

        favList.addProductId(prod);


    }

    /**
     * <p>Removes a {@link Product} from favorites</p>
     *
     * @param prod the {@link Product} that will be removed
     */
    public void removeFromFavorites(Product prod) {
        SavableProductIdList favList = ListIOManager.getList("Favorites");

        if (favList == null) ListIOManager.addList(new SavableProductIdList("Favorites"));

        favList.removeProductId(prod);
    }


    public DataHandler() {
        populateProducts(ParserFactory.makeJsonParser());
        filter = new Filter(getProducts());
    }


    /**
     * Returns all the {@link Product} ids from Favorites
     *
     * @return {@link Product} ids as an {@link List} of {@link Integer}s
     */
    public List<Integer> getProductIdsFromFavorites() {

        //TODO Fix so that this return product

        SavableProductIdList favList = ListIOManager.getList("Favorites");

        if (favList == null) ListIOManager.addList(new SavableProductIdList("Favorites"));

        return favList.getProductIds();

    }





    /*---------------- Utility -------------*/

    public void onStartUp(){
        ListIOManager.loadAllLists();
    }

    public void onShutDown(){
        ListIOManager.saveAllLists();
    }

    public int getSize() {
        return this.products.size();
    }

    public void setCategoryLevel1Filter(String categoryName){
        filter.setCategoryLevel1Filter(categoryName);
    }

    public void clearCategoryLevel1Filter(){
        filter.clearCategoryLevel1Filter();
    }

    public void addCategoryLevel2Filter(String categoryName){
        filter.addCategoryLevel2Filter(categoryName);
    }

    public void removeCategoryLevel2Filter(String categoryName){
        filter.removeCategoryLevel2Filter(categoryName);
    }

    public void clearCategoryLevel2Filters(){
        filter.clearCategoryLevel2Filters();
    }


    public List<Product> getFilteredProducts(){
        return filter.getFilteredProducts();
    }
}
