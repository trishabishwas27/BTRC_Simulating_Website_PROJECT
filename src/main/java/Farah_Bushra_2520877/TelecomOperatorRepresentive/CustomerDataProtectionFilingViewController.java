
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.BushraApplication;
import Farah_Bushra_2520877.CitizenServiceUser.AppendableObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

public class CustomerDataProtectionFilingViewController
{
    @javafx.fxml.FXML
    private TextField dataProtectionOfficerTextField;
    @javafx.fxml.FXML
    private TextField dataRetentionPeriod;
    @javafx.fxml.FXML
    private ComboBox<String> protectionMeasureComboBox;
    @javafx.fxml.FXML
    private TextArea additionalRemarksTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> filingTypeComboBox;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private TextField officerContactEmailTextField;
    @javafx.fxml.FXML
    private DatePicker filingDatePicker;
    @javafx.fxml.FXML
    private TextArea protectionDetailsTextArea;
    @javafx.fxml.FXML
    private CheckBox isDeclarationConfirmedCheckBox;
    @javafx.fxml.FXML
    private TextField processingPurposeTextField;
    @javafx.fxml.FXML
    private ComboBox<String> dataCatagoryComboBox;
    @javafx.fxml.FXML
    private TextField outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        filingTypeComboBox.getItems().addAll(
                "Initial Filing",
                "Annual Filing",
                "Updated Filing",
                "Incident Reporting"
        );

        dataCatagoryComboBox.getItems().addAll(
                "Personal Information",
                "Subscriber Information",
                "Call Records",
                "Billing Information",
                "Location Information"
        );

        protectionMeasureComboBox.getItems().addAll(
                "Data Encryption",
                "Access Control",
                "Secure Storage",
                "Data Anonymization",
                "Multiple Protection Measures"
        );

        outputLabel.setEditable(false);
    }

    public boolean isValidEmail(String email) {

        int atPosition = email.indexOf("@");
        int dotPosition = email.lastIndexOf(".");

        return atPosition > 0
                && atPosition == email.lastIndexOf("@")
                && dotPosition > atPosition + 1
                && dotPosition < email.length() - 1
                && !email.contains(" ");
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameTextField.clear();
        filingTypeComboBox.setValue(null);
        dataCatagoryComboBox.setValue(null);
        processingPurposeTextField.clear();
        dataRetentionPeriod.clear();

        protectionMeasureComboBox.setValue(null);

        dataProtectionOfficerTextField.clear();
        officerContactEmailTextField.clear();

        filingDatePicker.setValue(null);

        protectionDetailsTextArea.clear();
        additionalRemarksTextArea.clear();

        isDeclarationConfirmedCheckBox.setSelected(false);

        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SubmitFilingOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameTextField.getText();
        String filingType = filingTypeComboBox.getValue();
        String dataCategory = dataCatagoryComboBox.getValue();

        String processingPurpose =
                processingPurposeTextField.getText();

        String retentionPeriod =
                dataRetentionPeriod.getText();

        String protectionMeasure =
                protectionMeasureComboBox.getValue();

        String dataProtectionOfficer =
                dataProtectionOfficerTextField.getText();

        String officerContactEmail =
                officerContactEmailTextField.getText();

        LocalDate filingDate = filingDatePicker.getValue();

        String protectionDetails =
                protectionDetailsTextArea.getText();

        String additionalRemarks =
                additionalRemarksTextArea.getText();

        boolean declaration =
                isDeclarationConfirmedCheckBox.isSelected();

        if (operatorName.isEmpty()
                || filingType == null
                || dataCategory == null
                || processingPurpose.isEmpty()
                || retentionPeriod.isEmpty()
                || protectionMeasure == null
                || dataProtectionOfficer.isEmpty()
                || officerContactEmail.isEmpty()
                || filingDate == null
                || protectionDetails.isEmpty()) {

            outputLabel.setText("Please complete all required information.");
            return;
        }

        if (!isValidEmail(officerContactEmail)) {

            outputLabel.setText("Please enter a valid email address.");
            return;
        }

        if (LocalDate.now().isBefore(filingDate)) {

            outputLabel.setText("Filing date cannot be in the future.");
            return;
        }

        if (!declaration) {

            outputLabel.setText("Please confirm the declaration.");
            return;
        }

        RegulatorySubmission filing =
                new CustomerDataProtectionFiling(
                        operatorName,
                        filingType,
                        dataCategory,
                        processingPurpose,
                        retentionPeriod,
                        protectionMeasure,
                        dataProtectionOfficer,
                        officerContactEmail,
                        filingDate,
                        protectionDetails,
                        additionalRemarks,
                        declaration
                );

        try {

            File f = new File("CustomerDataProtectionFiling.bin");

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

            oos.writeObject(filing);
            oos.close();

            outputLabel.setText(
                    filing.getReportType() + " Submitted Successfully."
            );
        }
        catch (Exception e) {

            outputLabel.setText("Customer Data Protection Filing Failed.");
        }
    }

    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {

        try {

            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/TelecomOperatorRepresentativeView/TelecomOperatorRepresentiveView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage =
                    (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Telecom Operator Representative Dashboard");
            currentStage.show();
        }
        catch (Exception e) {

            outputLabel.setText("Unable to open dashboard.");
        }
    }
}
