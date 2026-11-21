package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegulatoryFeePaymentRecordViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> feeTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker paymentDateDatePicker;
    @javafx.fxml.FXML
    private TextField amountPaidTextField;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private TextField transactionReferenceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitPaymentRecordOnAction(ActionEvent actionEvent) {
    }
}