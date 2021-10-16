package shedbolaget.controllers.components;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import shedbolaget.model.events.PagesEvent;
import shedbolaget.model.products.pages.Pages;

public class PaginationComponent extends Component {
    @FXML
    private Button backButton;

    @FXML
    private TextField pageTextField;

    @FXML
    private Text pagesText;

    @FXML
    private Button nextButton;

    private int currentPage = 1;

    private final Pages pages;

    protected PaginationComponent(Pages pages) {
        super("PaginationView");
        this.pages = pages;
        pagesText.setText("/ " + pages.getNumberOfPages());
        pageTextField.setText("1");
    }

    @FXML
    void backButtonClicked(ActionEvent event) {
        if (currentPage == 1) {
        } // apply greyed out css?
        else {
            currentPage--;
            pageTextField.setText(String.valueOf(currentPage));
            eventManager.fireEvent(new PagesEvent(currentPage, pages.getProductsFromPage(currentPage)));
        }

    }

    @FXML
    void nextButtonClicked(ActionEvent event) {
        if (currentPage == pages.getNumberOfPages()) {
        } // apply greyed out css?
        else {
            currentPage++;
            pageTextField.setText(String.valueOf(currentPage));
            eventManager.fireEvent(new PagesEvent(currentPage, pages.getProductsFromPage(currentPage)));
        }
    }
}

