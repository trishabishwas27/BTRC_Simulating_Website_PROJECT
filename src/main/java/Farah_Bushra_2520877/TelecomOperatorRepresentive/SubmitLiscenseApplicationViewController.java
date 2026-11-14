package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class SubmitLiscenseApplicationViewController
{
    @javafx.fxml.FXML
    private DatePicker applicationDateDatePicker;
    @javafx.fxml.FXML
    private TextField contactInformationTextField;
    @javafx.fxml.FXML
    private TextField applicationIdTextField;
    @javafx.fxml.FXML
    private TextField registrationNumberTextField;
    @javafx.fxml.FXML
    private ComboBox <String> liscenseTypeComboBox;
    @javafx.fxml.FXML
    private TextField companyNameTextField;
    @javafx.fxml.FXML
    private TextArea reasonForApplyingTextArea;
    @javafx.fxml.FXML
    private TextField applicationStatusTextFIeld;
    @javafx.fxml.FXML
    private TextField outputLabelTextField;

    private ArrayList<SubmitLiscenseApplication> applicationList;

    private ArrayList<String> registeredCompanyNumbers;

    int applicationCount = 0;

    @javafx.fxml.FXML
    public void initialize() {
        applicationList = new ArrayList<SubmitLiscenseApplication>();

        registeredCompanyNumbers = new ArrayList<String>();
        registeredCompanyNumbers.add("REG-1001");
        registeredCompanyNumbers.add("REG-1002");

        liscenseTypeComboBox.getItems().addAll("Mobile Operator", "ISP", "Other");

        applicationIdTextField.setEditable(false);

        applicationStatusTextFIeld.setEditable(false);

        applicationIdTextField.setText("Not Generated");

        applicationStatusTextFIeld.setText("Not Submitted");
    }

    private boolean isValid() {

        boolean valid = true;

        if (companyNameTextField.getText().isEmpty()
                || registrationNumberTextField.getText().isEmpty()
                || contactInformationTextField.getText().isEmpty()
                || liscenseTypeComboBox.getValue() == null
                || reasonForApplyingTextArea.getText().isEmpty()
                || applicationDateDatePicker.getValue() == null) {

            valid = false;
        }

        return valid;
    }




    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SubmitApplicationOnAction(ActionEvent actionEvent) {
        if (isValid()) {

            boolean registrationFound = false;

            for (String registrationNumber : registeredCompanyNumbers) {

                if (registrationNumber.equals(
                        registrationNumberTextField.getText())) {

                    registrationFound = true;
                }
            }

            if (registrationFound) {

                applicationCount++;

                String applicationId = "LIC-APP-" + applicationCount;

                SubmitLiscenseApplication newApplication =
                        new SubmitLiscenseApplication(
                                companyNameTextField.getText(),
                                registrationNumberTextField.getText(),
                                contactInformationTextField.getText(),
                                liscenseTypeComboBox.getValue(),
                                reasonForApplyingTextArea.getText(),
                                applicationDateDatePicker.getValue(),
                                applicationId,
                                "Pending"
                        );

                applicationList.add(newApplication);

                applicationIdTextField.setText(applicationId);

                applicationStatusTextFIeld.setText("Pending");

                outputLabelTextField.setText("Application Submitted Successfully! Application ID: "
                                + applicationId);

            } else {

                Alert a = new Alert(Alert.AlertType.ERROR);

                a.setTitle("Registration Verification");

                a.setContentText(
                        "Company registration information does not match."
                );

                a.showAndWait();
            }

        } else {

            Alert a = new Alert(Alert.AlertType.ERROR);

            a.setTitle("Invalid Application");

            a.setContentText(
                    "Please complete all required information."
            );

            a.showAndWait();
        }

    }
}