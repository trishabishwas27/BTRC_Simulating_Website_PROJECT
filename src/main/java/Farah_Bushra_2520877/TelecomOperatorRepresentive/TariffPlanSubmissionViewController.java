package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TariffPlanSubmissionViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeComboBox;
    @javafx.fxml.FXML
    private TextField voiceCallRateTextField;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private TextField tariffPlanNameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> planCategoryComboBox;
    @javafx.fxml.FXML
    private TextArea planDescriptionTextArea;
    @javafx.fxml.FXML
    private DatePicker effectiveDateDatePicker;
    @javafx.fxml.FXML
    private TextField smsRateTextField;
    @javafx.fxml.FXML
    private TextField dataRateTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitTariffPlanOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {
    }
}