package shedbolaget.controllers.components;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;

import java.util.List;

public class APKLeaderboardPage extends Component{

    @FXML
    private FlowPane contentFlowPane;

    protected APKLeaderboardPage() {
        super("APKLeaderboardView");
        populateView();
    }

    private void populateView() {
        contentFlowPane.getChildren().add(ComponentFactory.createCategoryMenu());
        contentFlowPane.getChildren().add(ComponentFactory.createBreadCrumbs());
        contentFlowPane.getChildren().add(ComponentFactory.createAPKTop3());
    }
}
