package shedbolaget.model.favorites;

import java.util.ArrayList;
import java.util.List;

/**
 * Favorites.ProductListIOManager
 *
 * <p> Used as a Manager for the Favorites facade to handle saving and loading {@link SavableProductIdList}s.</p>
 *
 * @author Daniel Rygaard
 * @version 1.0
 */
 class ProductIdListsIOManager {
    private static final ProductIdListsIOManager instance = new ProductIdListsIOManager();
    IProductListIO handler;
    List<SavableProductIdList> list;

    private ProductIdListsIOManager() {
        list = new ArrayList<>();
        this.handler = new ProductListFileIO();
    }

    public static ProductIdListsIOManager getInstance() {
        return instance;
    }

    /**
     * <p>Saves all the {@link SavableProductIdList} trough the file {@link IProductListIO}</p>
     */
    public void saveAllLists() {
        //TODO Call this on shut down
        for (SavableProductIdList sList :
                this.list) {
            handler.save(sList);
        }
        this.handler.close();
    }

    /**
     * <p>Loads all of the {@link SavableProductIdList}s from the {@link IProductListIO}</p>
     */
    public void loadAllLists() {
        //TODO Call this on start up
        this.list = handler.loadAll();

        handler.close();
    }


    /**
     * <p>Gives a {@link SavableProductIdList}, that has the given name.
     * Gives a null if the list doesn't exist</p>
     *
     * @param name, name of the list that should be returned as a String
     * @return a SavableList of products
     */
    public SavableProductIdList getList(String name) {
        for (SavableProductIdList sList : this.list) {
            if (sList.getName().equals(name))
                return sList;
        }
        return null;
    }

    /**
     * <p>Returns all of the saved {@link SavableProductIdList}s</p>
     *
     * @return a {@link SavableProductIdList}
     */
    public List<SavableProductIdList> getLists() {
        return this.list;
    }

    /**
     * <p>Adds a {@link SavableProductIdList} to the manager.
     * Doesn't add the list if the name is already taken</p>
     *
     * @param list, {@link SavableProductIdList} that will be saved
     */
    public void addList(SavableProductIdList list) {
        if (nameTaken(list.getName()))
            return;

        this.list.add(list);
    }

    public void addLists(List<SavableProductIdList> lists) {
        for (SavableProductIdList l : lists)
            this.addList(l);
    }

    /**
     * <p>Removes the given {@link SavableProductIdList} from the manager</p>
     *
     * @param list the {@link SavableProductIdList} that will be removed
     */
    public void removeList(SavableProductIdList list) {
        int index = getIndexOfListByName(list);
        if (index != -1)
            this.list.remove(index);
    }

    /**
     * <p>Removes the {@link SavableProductIdList} with the given name from the manager</p>
     *
     * @param listName name of the {@link SavableProductIdList} that will be removed
     */
    public void removeList(String listName) {
        int index = getIndexOfListByName(listName);
        if (index != -1)
            this.list.remove(index);
    }

    /**
     * <p>Checks if there is already a {@link SavableProductIdList} with that name</p>
     *
     * @param name the name as a String
     * @return boolean
     */
    private boolean nameTaken(String name) {
        for (SavableProductIdList sList : this.list) {
            if (sList.getName().equals(name))
                return true;
        }
        return false;
    }

    /**
     * <p>Returns the index of the {@link SavableProductIdList} with the given name</p>
     *
     * @param name name of the list that has an index
     * @return the index, -1 if a list with the given name doesn't exits
     */
    private int getIndexOfListByName(String name) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getName().equals(name))
                return i;
        }

        return -1;
    }

    /**
     * <p>Returns the index of the given {@link SavableProductIdList}</p>
     *
     * @param list the {@link SavableProductIdList}
     * @return the index, -1 if a list doesn't exits
     */
    private int getIndexOfListByName(SavableProductIdList list) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getName().equals(list.getName()))
                return i;
        }

        return -1;
    }


    /**
     * <p>Gives the amount of {@link SavableProductIdList}s that are currently in the manager</p>
     *
     * @return amount of {@link SavableProductIdList}s as an integer
     */
    public int getSize() {
        return this.list.size();
    }

    /**
     * <p>Clears all attributes of this object and returns it to a nwe state</p>
     */
    public void clear() {
        list.clear();
    }
}
