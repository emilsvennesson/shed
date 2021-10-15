package shedbolaget.controllers.components;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public abstract class Component {
    private final AnchorPane pane = new AnchorPane();

    protected Component(String fxmlFileName) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + fxmlFileName + ".fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(pane);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public AnchorPane getPane() {
        return pane;
    }

}

