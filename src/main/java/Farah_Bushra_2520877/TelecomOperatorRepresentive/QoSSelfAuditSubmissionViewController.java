
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.BushraApplication;
import Farah_Bushra_2520877.CitizenServiceUser.AppendableObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;

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
    private TextField outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        serviceTypeComboBox.getItems().addAll(
                "Voice Call",
                "SMS",
                "Internet",
                "Combined Service"
        );

        TechnologyComboBox.getItems().addAll(
                "2G",
                "3G",
                "4G",
                "5G"
        );

        outputLabel.setEditable(false);
    }

    public boolean isValidNumber(float value) {

        return value >= 0
                && value < Float.POSITIVE_INFINITY;
    }

    public boolean isValidNumber(float value, float maximum) {

        return value >= 0 && value <= maximum;
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameTextField.clear();
        serviceTypeComboBox.setValue(null);
        TechnologyComboBox.setValue(null);
        auditAreaTextField.clear();

        auditStartDatePicker.setValue(null);
        auditEndDatePicker.setValue(null);

        callSuccessRateTextField.clear();
        callDropRateTextField.clear();
        averageDataSpeedTextField.clear();
        averageLatencyTextField.clear();

        auditFindlingsTextArea.clear();
        correctiveActionTextArea.clear();

        submissionDatePicker.setValue(null);
        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SubmitSelfAuditOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameTextField.getText();
        String serviceType = serviceTypeComboBox.getValue();
        String technology = TechnologyComboBox.getValue();
        String auditArea = auditAreaTextField.getText();

        LocalDate auditStartDate = auditStartDatePicker.getValue();
        LocalDate auditEndDate = auditEndDatePicker.getValue();

        String successRate = callSuccessRateTextField.getText();
        String dropRate = callDropRateTextField.getText();
        String dataSpeed = averageDataSpeedTextField.getText();
        String latency = averageLatencyTextField.getText();

        String auditFindings = auditFindlingsTextArea.getText();
        String correctiveAction = correctiveActionTextArea.getText();

        LocalDate submissionDate = submissionDatePicker.getValue();

        if (operatorName.isEmpty()
                || serviceType == null
                || technology == null
                || auditArea.isEmpty()
                || auditStartDate == null
                || auditEndDate == null
                || successRate.isEmpty()
                || dropRate.isEmpty()
                || dataSpeed.isEmpty()
                || latency.isEmpty()
                || auditFindings.isEmpty()
                || correctiveAction.isEmpty()
                || submissionDate == null) {

            outputLabel.setText("Please complete all required information.");
            return;
        }

        if (auditEndDate.isBefore(auditStartDate)) {

            outputLabel.setText("Audit end date cannot be before start date.");
            return;
        }

        if (submissionDate.isBefore(auditEndDate)) {

            outputLabel.setText("Submission date cannot be before audit end date.");
            return;
        }

        if (LocalDate.now().isBefore(submissionDate)) {

            outputLabel.setText("Submission date cannot be in the future.");
            return;
        }

        float callSetupSuccessRate;
        float callDropRate;
        float averageDataSpeed;
        float averageLatency;

        try {

            callSetupSuccessRate = Float.parseFloat(successRate);
            callDropRate = Float.parseFloat(dropRate);
            averageDataSpeed = Float.parseFloat(dataSpeed);
            averageLatency = Float.parseFloat(latency);
        }
        catch (Exception e) {

            outputLabel.setText("Please enter valid numeric values.");
            return;
        }

        if (!isValidNumber(callSetupSuccessRate, 100)
                || !isValidNumber(callDropRate, 100)) {

            outputLabel.setText("Percentage must be between 0 and 100.");
            return;
        }

        if (!isValidNumber(averageDataSpeed)
                || !isValidNumber(averageLatency)) {

            outputLabel.setText("Data speed and latency must be valid non-negative numbers.");
            return;
        }

        RegulatorySubmission audit =
                new QoSSelfAuditSubmission(
                        operatorName,
                        serviceType,
                        technology,
                        auditArea,
                        auditStartDate,
                        auditEndDate,
                        callSetupSuccessRate,
                        callDropRate,
                        averageDataSpeed,
                        averageLatency,
                        auditFindings,
                        correctiveAction,
                        submissionDate
                );

        try {

            File f = new File("QoSSelfAuditSubmission.bin");

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

            oos.writeObject(audit);
            oos.close();

            outputLabel.setText(
                    audit.getReportType() + " Submitted Successfully."
            );
        }
        catch (Exception e) {

            outputLabel.setText("QoS Self-Audit Submission Failed.");
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

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Telecom Operator Representative Dashboard");
            currentStage.show();
        }
        catch (Exception e) {

            outputLabel.setText("Unable to open dashboard.");
        }
    }
}
