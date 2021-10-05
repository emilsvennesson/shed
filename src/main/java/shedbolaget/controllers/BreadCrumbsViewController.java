package shedbolaget.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class BreadCrumbsViewController {

    @FXML
    private Text currentCategoryText;

    @FXML
    private Text categoryLevel1Text;

    @FXML
    private Text categoryLevel2Text;

    @FXML
    private Text separatorText;

    @FXML
    public void initialize() throws IOException {
        // Sets the breadcrumbs and current category
        String currentCategoryLevel1 = "Öl";
        String currentCategoryLevel2 = "Veteöl";
        String mostDetailedCategoryText = currentCategoryLevel2.isEmpty() ? currentCategoryLevel1 : currentCategoryLevel2;
        String separator = currentCategoryLevel2.isEmpty() ? "" : ">";
        categoryLevel1Text.setText(currentCategoryLevel1);
        categoryLevel2Text.setText(mostDetailedCategoryText);
    }

}