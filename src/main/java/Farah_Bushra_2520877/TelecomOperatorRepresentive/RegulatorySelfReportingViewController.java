
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

public class RegulatorySelfReportingViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> reportCategoryComboBox;
    @javafx.fxml.FXML
    private TextArea reportDetailsTextArea;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private TextField reportingPeriodTextField;
    @javafx.fxml.FXML
    private DatePicker submissionDatePicker;
    @javafx.fxml.FXML
    private TextField outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        reportCategoryComboBox.getItems().addAll(
                "Compliance Report",
                "Network Performance Report",
                "Financial Report",
                "Service Quality Report",
                "Other"
        );

        outputLabel.setEditable(false);
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameTextField.clear();
        reportCategoryComboBox.setValue(null);
        reportingPeriodTextField.clear();
        submissionDatePicker.setValue(null);
        reportDetailsTextArea.clear();
        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SubmitReportOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameTextField.getText();
        String reportCategory = reportCategoryComboBox.getValue();
        String reportingPeriod = reportingPeriodTextField.getText();
        LocalDate submissionDate = submissionDatePicker.getValue();
        String reportDetails = reportDetailsTextArea.getText();

        if (operatorName.isEmpty()
                || reportCategory == null
                || reportingPeriod.isEmpty()
                || submissionDate == null
                || reportDetails.isEmpty()) {

            outputLabel.setText("Please complete all required information.");
            return;
        }

        if (LocalDate.now().isBefore(submissionDate)) {

            outputLabel.setText("Submission date cannot be in the future.");
            return;
        }

        RegulatorySubmission report =
                new RegulatorySelfReporting(
                        operatorName,
                        reportCategory,
                        reportingPeriod,
                        submissionDate,
                        reportDetails
                );

        try {

            File f = new File("RegulatorySelfReport.bin");

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

            oos.writeObject(report);
            oos.close();

            outputLabel.setText(
                    report.getReportType() + " Submitted Successfully."
            );
        }
        catch (Exception e) {

            outputLabel.setText("Regulatory Report Submission Failed.");
        }
    }

    @javafx.fxml.FXML
    public void BackToDashboard(ActionEvent actionEvent) {

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
