package shedbolaget.model.favorites;

import java.util.List;

/**
 * Favorites.IProductListIO
 *
 * <p> Is an interface for file saving, input/outputs(IO).</p>
 *
 * @author Daniel Rygaard
 * @version 1.0
 */
interface IProductListIO {
    /**
     * Saves a {@link SavableProductIdList} to a file
     *
     * @param list - the list that is saved
     */
    void save(SavableProductIdList list);

    /**
     * loads all {@link SavableProductIdList} to a file
     *
     * @return A generic list of {@link SavableProductIdList}
     */
    List<SavableProductIdList> loadAll();

    /**
     * Closes the readers and writers
     */
    void close();
}
