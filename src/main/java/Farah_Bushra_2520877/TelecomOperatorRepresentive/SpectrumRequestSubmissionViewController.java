package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpectrumRequestSubmissionViewController
{
    @javafx.fxml.FXML
    private TextField licenseNumberTextField;
    @javafx.fxml.FXML
    private TextField requestedBandwidthTextField;
    @javafx.fxml.FXML
    private TextField coverageAreaTextField;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private DatePicker requestDateDatePicker;
    @javafx.fxml.FXML
    private TextArea purposeOfRequestTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> frequencyBandComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitRequestOnAction(ActionEvent actionEvent) {
    }
}