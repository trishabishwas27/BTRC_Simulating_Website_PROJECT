package Farah_Bushra_2520877.CitizenServiceUser;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServiceOutageReportingViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeComboBox;
    @javafx.fxml.FXML
    private TextArea outageDescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextField outageStartTimeTextField;
    @javafx.fxml.FXML
    private DatePicker outageStartDateDatePicker;
    @javafx.fxml.FXML
    private TextField locationTextField;

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