package Farah_Bushra_2520877.CitizenServiceUser;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class RegisterAComplaintViewController
{
    @javafx.fxml.FXML
    private DatePicker problemDateDatePicker;
    @javafx.fxml.FXML
    private TextField areaTextField;
    @javafx.fxml.FXML
    private TextField outputLabel;
    @javafx.fxml.FXML
    private TextField complaintIdTextField;
    @javafx.fxml.FXML
    private TextArea complaintDetailsTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextField mobileNumberTextField;
    @javafx.fxml.FXML
    private ComboBox<String> complaintTypeComboBox;

    private ArrayList<RegisterAComplaint>ComplaintList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        operatorNameComboBox.getItems().addAll("Grameenphone", "Robi","Teletalk",
                "Banglalink","Airtel", "Other");
        complaintTypeComboBox.getItems().addAll("Network Problem","Internet Problem", "Billing Problem",
                "Call Drop", "Audio Problem", "Other");


    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {
        clearFields();
        return;
    }

    @javafx.fxml.FXML
    public void SubmitComplaintOnAction(ActionEvent actionEvent) {
        String operatorName = operatorNameComboBox.getValue();
        String complaintType = complaintTypeComboBox.getValue();
        String mobileNumber = mobileNumberTextField.getText();
        String area = areaTextField.getText();
        String complaintDetails = complaintDetailsTextArea.getText();
        LocalDate problemDate = problemDateDatePicker.getValue();

        if (operatorName == null) {
            outputLabel.setText("Please select an operator.");
            return;
        }
        if (complaintType == null) {
            outputLabel.setText("Please select a complaint type.");
            return;
        }
        if (mobileNumber.isEmpty() || area.isEmpty() || complaintDetails.isEmpty()) {
            outputLabel.setText("Please enter mobile number, area and complaint details.");
            return;
        }
        if (problemDate == null) {
            outputLabel.setText("Please select the problem date.");
            return;
        }
        if (mobileNumber.length() != 11 || !mobileNumber.startsWith("01")) {
            outputLabel.setText(
                    "Mobile number must have 11 digits and start with 01.");
            return;
        }
        if (problemDate.isAfter(LocalDate.now())) {
            outputLabel.setText("Problem date cannot be a future date.");
            return;
        }
        String complaintId = "CMP-" + (ComplaintList.size() + 1);
        RegisterAComplaint complaint = new RegisterAComplaint (complaintId, operatorName, complaintType,
                complaintDetails, area, problemDate, mobileNumber);
        ComplaintList.add(complaint);


    }
    private void clearFields(){
        operatorNameComboBox.getSelectionModel().clearSelection();
        complaintTypeComboBox.getSelectionModel().clearSelection();
        mobileNumberTextField.clear();
        areaTextField.clear();
        problemDateDatePicker.setValue(null);
        complaintDetailsTextArea.clear();

    }
}