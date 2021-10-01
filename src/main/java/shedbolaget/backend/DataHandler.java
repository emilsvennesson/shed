package shedbolaget.backend;

import shedbolaget.backend.favorites.ProductIdListsIOManager;
import shedbolaget.backend.favorites.SavableProductIdList;
import shedbolaget.backend.parser.IProductParser;
import shedbolaget.backend.parser.ParserFactory;

import java.util.List;

public class DataHandler {
    public enum ImageSize {
        SMALL,
        MEDIUM,
        LARGE
    }

    private List<Product> products;
    private ProductIdListsIOManager listIOManager;
    private final Filter filter;

    public DataHandler() {
        populateProducts(ParserFactory.getJsonParser());
        filter = new Filter(getProducts());
        listIOManager = ProductIdListsIOManager.getInstance();
    }

    public List<Product> getProducts() {
        return products;
    }

    private void populateProducts(IProductParser parser) {
        products = parser.getProducts();
    }

    /**
     * <p>Adds a {@link Product} to favorites</p>
     *
     * @param prod the {@link Product} that is added
     */
    public void addToFavorites(Product prod) {
        SavableProductIdList favList = listIOManager.getList("Favorites");
        if (favList == null) {
            listIOManager.addList(new SavableProductIdList("Favorites"));
            favList = listIOManager.getList("Favorites");
        }
        favList.addProductId(prod);
    }

    /**
     * <p>Removes a {@link Product} from favorites</p>
     *
     * @param prod the {@link Product} that will be removed
     */
    public void removeFromFavorites(Product prod) {
        SavableProductIdList favList = listIOManager.getList("Favorites");
        if (favList == null) listIOManager.addList(new SavableProductIdList("Favorites"));
        favList.removeProductId(prod);
    }

    /**
     * Returns all the {@link Product} ids from Favorites
     *
     * @return {@link Product} ids as an {@link List} of {@link Integer}s
     */
    public List<Integer> getProductIdsFromFavorites() {
        //TODO Fix so that this return product
        SavableProductIdList favList = listIOManager.getList("Favorites");
        if (favList == null) {
            listIOManager.addList(new SavableProductIdList("Favorites"));
            favList = listIOManager.getList("Favorites");
        }
        return favList.getProductIds();
    }

    /**
     * Removes all the products from favorites
     */
    public void clearFavorites() {
        listIOManager.removeList("Favorites");
    }

    public void onStartUp() {
        listIOManager.loadAllLists();
    }

    public void onShutDown() {
        listIOManager.saveAllLists();
    }

    public int getSize() {
        return this.products.size();
    }

    public void setCategoryLevel1Filter(String categoryName) {
        filter.setCategoryLevel1Filter(categoryName);
    }

    public void clearCategoryLevel1Filter() {
        filter.clearCategoryLevel1Filter();
    }

    public void addCategoryLevel2Filter(String categoryName) {
        filter.addCategoryLevel2Filter(categoryName);
    }

    public void removeCategoryLevel2Filter(String categoryName) {
        filter.removeCategoryLevel2Filter(categoryName);
    }

    public void clearCategoryLevel2Filters() {
        filter.clearCategoryLevel2Filters();
    }

    public List<Product> getFilteredProducts() {
        return filter.getFilteredProducts();
    }

    public String getProductImageUrl(Product product, ImageSize imageSize) {
        String imageUrl;
        String size;
        switch (imageSize) {
            case SMALL:
                size = "20";
                break;
            case MEDIUM:
                size = "100";
                break;
            case LARGE:
                size = "200";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + imageSize);
        }

        try {
            imageUrl = product.getImages().get(0).getImageUrl();
        } catch (IndexOutOfBoundsException e) {
            return "https://i.ibb.co/LdVhq7m/skavlan.png";
        }

        return imageUrl + String.format("_%s.png", size);
    }

}
