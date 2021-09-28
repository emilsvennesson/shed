package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class CategorySideBarController extends BaseController {
    @FXML
    private FlowPane categoriesFlowPane;

    @FXML
    private CategorySideBarItemController sideBarItems;

    public CategorySideBarController() {
        super("CategorySideBarView.fxml");
        sideBarItems = new CategorySideBarItemController();
        populateSideBar();
    }

    private void populateSideBar() {
        this.categoriesFlowPane.getChildren().add(sideBarItems);
    }
}
