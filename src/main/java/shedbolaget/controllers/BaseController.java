package shedbolaget.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public abstract class BaseController extends AnchorPane {
    public BaseController(String fxmlName) {
        this.initController(fxmlName);
    }

    private void initController(String fxmlName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlName));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
