package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

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

        if (problemDate.isAfter(LocalDate.now())) {
            outputLabel.setText("Problem date cannot be a future date.");
            return;
        }

        String complaintId = Integer.toString(ComplaintList.size() + 1);

        RegisterAComplaint complaint = new RegisterAComplaint(
                complaintId, operatorName, complaintType,
                complaintDetails, area, problemDate, mobileNumber
        );

        try {
            File f = new File("Complaint.bin");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(complaint);
            oos.close();

            ComplaintList.add(complaint);

            complaintIdTextField.setText(complaintId);
            outputLabel.setText("Complaint Submitted Successfully");
        }
        catch (Exception e) {
            outputLabel.setText("Complaint Submission Failed");
        }
    }

    private void clearFields(){
        operatorNameComboBox.getSelectionModel().clearSelection();
        complaintTypeComboBox.getSelectionModel().clearSelection();
        mobileNumberTextField.clear();
        areaTextField.clear();
        problemDateDatePicker.setValue(null);
        complaintDetailsTextArea.clear();

    }


    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/CitizenServiceUserView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Citizen Service User Dashboard");
            currentStage.show();
        }
        catch (Exception e) {
            outputLabel.setText("Unable to open dashboard.");
        }
    }

}