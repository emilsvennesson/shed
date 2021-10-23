package shedbolaget.model;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;

public class TestUserDataManager {
    @Test
    public void testGetUserDataPath() {
        String path = UserDataManager.getUserDataDirectory();
        Assert.assertEquals(path, System.getProperty("user.home") + File.separator + UserDataManager.USERDATA_FOLDER_NAME);
    }

    @Test
    public void testClearUserData() {
        String path = UserDataManager.getUserDataDirectory();
        UserDataManager.clearUserData();
        Assert.assertFalse(Path.of(path).toFile().exists());
    }

    @Test
    public void testCreateUserDataPath() {
        String path = UserDataManager.getUserDataDirectory();
        UserDataManager.clearUserData();
        Assert.assertFalse(Path.of(path).toFile().exists());
        UserDataManager.getUserDataDirectory();
        Assert.assertTrue(Path.of(path).toFile().exists());
    }
}
