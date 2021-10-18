package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import shedbolaget.model.events.PagesEvent;
import shedbolaget.model.products.pages.Pages;

public class PaginationComponent extends Component {
    @FXML
    private Button backButton;

    @FXML
    private Text currentPageText;

    @FXML
    private Text totalPagesText;

    @FXML
    private Button nextButton;

    private int currentPage = 1;

    private final Pages pages;

    protected PaginationComponent(Pages pages) {
        super("PaginationView");
        this.pages = pages;
        totalPagesText.setText("/ " + pages.getNumberOfPages());
        currentPageText.setText("1");
    }

    @FXML
    void backButtonClicked(ActionEvent event) {
        if (currentPage == 1) {
        } // apply greyed out css?
        else {
            currentPage--;
            currentPageText.setText(String.valueOf(currentPage));
            eventManager.fireEvent(new PagesEvent(currentPage, pages.getProductsFromPage(currentPage)));
        }

    }

    @FXML
    void nextButtonClicked(ActionEvent event) {
        if (currentPage == pages.getNumberOfPages()) {
        } // apply greyed out css?
        else {
            currentPage++;
            currentPageText.setText(String.valueOf(currentPage));
            eventManager.fireEvent(new PagesEvent(currentPage, pages.getProductsFromPage(currentPage)));
        }
    }
}

