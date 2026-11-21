package Farah_Bushra_2520877.CitizenServiceUser;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CallDropReportingViewController
{
    @javafx.fxml.FXML
    private DatePicker callDropDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextField mobileNumberTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private TextField callDropTimeTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitOnAction(ActionEvent actionEvent) {
    }
}