package shedbolaget.controllers.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import shedbolaget.model.events.EventManager;

import java.io.IOException;

/**
 * @author Emil Svensson
 * @author Samuel Kajava
 * @author OOPsie project :-)
 */
public abstract class Component {
    static final EventManager eventManager = EventManager.getInstance();
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

