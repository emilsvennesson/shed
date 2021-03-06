package shedbolaget;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml")).load();
        primaryStage.setTitle("Shedbolaget.");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
