package shedbolaget.model.favorites;

import shedbolaget.model.UserDataManager;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Favorites.ProductListIOFile
 *
 * <p> Inherits {@link IProductListIO}, used to save {@link SavableProductIdList} to a file.</p>
 *
 * @author Daniel Rygaard
 * @version %I%, %G%
 */
class ProductListFileIO implements IProductListIO {
    private static final String FILE_NAME = "favorites.txt";
    private static final Path FILE_PATH = Path.of(UserDataManager.getUserDataDirectory(), FILE_NAME);
    private File file;
    private BufferedWriter writer;
    private BufferedReader reader;

    public ProductListFileIO() {
        file = new File(FILE_PATH.toUri());
        try {
            if (!file.exists()) file.createNewFile();

        } catch (IOException e) {
            genericFileError(e, "Creating a file ");
        }

    }

    @Override
    public void save(SavableProductIdList list) {
        if (writer == null) {
            try {
                this.writer = new BufferedWriter(new FileWriter(file));
            } catch (IOException e) {
                genericFileError(e, "Creating a buffered writer");
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(list.getName()).append("\n");
        builder.append(list.getSize()).append("\n");

        for (int prod : list.getProductIds())
            builder.append(prod).append("\n");
        try {
            writer.write(builder.toString());
        } catch (IOException e) {
            genericFileError(e, "Writing to the file");
        }

    }

    @Override
    public List<SavableProductIdList> loadAll() {
        if (reader == null) {
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                genericFileError(e, "Creating a buffered reader");
            }
        }


        List<SavableProductIdList> listOfLists = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                SavableProductIdList list = new SavableProductIdList(line);
                int amount = Integer.parseInt(reader.readLine());
                for (int i = 0; i < amount; i++)
                    list.addProductId(Integer.parseInt(reader.readLine()));
                listOfLists.add(list);
            }
        } catch (IOException e) {
            genericFileError(e, "Reading the lists from the file");
        }

        return listOfLists;
    }

    @Override
    public void close() {
        try {
            if (writer != null)
                writer.close();
            if (reader != null)
                reader.close();
            writer = null;
            reader = null;

        } catch (IOException e) {
            genericFileError(e, " Closing the FileIO Class");
        }
    }

    //TODO add a method to display errors in gui

    /**
     * <p>Called when an IO error occurs in the file handling</p>
     *
     * @param ex  Exception
     * @param msg Message to display with the error
     */
    private void genericFileError(IOException ex, String msg) {
        System.out.println("IO file error has occurred in Path: " + file.getAbsolutePath() + "\n" +
                "At a point where the program is " + msg + "\n" +
                "Exception error message: " + ex.getMessage());
    }

}
