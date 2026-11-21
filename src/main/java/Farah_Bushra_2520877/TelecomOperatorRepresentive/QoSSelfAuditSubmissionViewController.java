package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class QoSSelfAuditSubmissionViewController
{
    @javafx.fxml.FXML
    private TextField auditAreaTextField;
    @javafx.fxml.FXML
    private TextArea correctiveActionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeComboBox;
    @javafx.fxml.FXML
    private TextArea auditFindlingsTextArea;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private TextField callSuccessRateTextField;
    @javafx.fxml.FXML
    private ComboBox<String> TechnologyComboBox;
    @javafx.fxml.FXML
    private TextField averageDataSpeedTextField;
    @javafx.fxml.FXML
    private DatePicker auditEndDatePicker;
    @javafx.fxml.FXML
    private TextField callDropRateTextField;
    @javafx.fxml.FXML
    private DatePicker auditStartDatePicker;
    @javafx.fxml.FXML
    private DatePicker submissionDatePicker;
    @javafx.fxml.FXML
    private TextField averageLatencyTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitSelfAuditOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {
    }
}