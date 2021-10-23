package shedbolaget.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

/**
 * This class manages the user data directory.
 *
 * @author Emil Svensson
 * @author Pouya Shirin
 */
public enum UserDataManager {
    ;
    static final String USERDATA_FOLDER_NAME = ".shedbolaget";
    static final String USERDATA_DIRECTORY = System.getProperty("user.home") + File.separator + USERDATA_FOLDER_NAME;
    private static final File USERDATA_FILE = new File(USERDATA_DIRECTORY);


    private static void createUserDataDirectory() {
        USERDATA_FILE.mkdir();
    }

    private static boolean homeDirectoryExists() {
        return USERDATA_FILE.exists();
    }

    /**
     * Gets user data directory. It creates the directory if it does not exist.
     *
     * @return the user data directory
     */
    public static String getUserDataDirectory() {
        if (!homeDirectoryExists())
            createUserDataDirectory();
        return USERDATA_DIRECTORY;
    }

    /**
     * Clears all user data.
     */
    public static void clearUserData() {
        try {
            Files.walk(Path.of(USERDATA_DIRECTORY))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            System.out.println("Failed to clear user data.");
        }
    }

}
