
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
    private TextField outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        serviceTypeComboBox.getItems().addAll(
                "Voice Call",
                "SMS",
                "Internet",
                "Combined Service"
        );

        planCategoryComboBox.getItems().addAll(
                "Prepaid",
                "Postpaid"
        );

        outputLabel.setEditable(false);
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameTextField.clear();
        tariffPlanNameTextField.clear();
        serviceTypeComboBox.setValue(null);
        planCategoryComboBox.setValue(null);
        voiceCallRateTextField.clear();
        smsRateTextField.clear();
        dataRateTextField.clear();
        effectiveDateDatePicker.setValue(null);
        planDescriptionTextArea.clear();
        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SubmitTariffPlanOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameTextField.getText();
        String tariffPlanName = tariffPlanNameTextField.getText();
        String serviceType = serviceTypeComboBox.getValue();
        String planCategory = planCategoryComboBox.getValue();

        String voiceRate = voiceCallRateTextField.getText();
        String sms = smsRateTextField.getText();
        String data = dataRateTextField.getText();

        LocalDate effectiveDate = effectiveDateDatePicker.getValue();
        String planDescription = planDescriptionTextArea.getText();

        if (operatorName.isEmpty()
                || tariffPlanName.isEmpty()
                || serviceType == null
                || planCategory == null
                || voiceRate.isEmpty()
                || sms.isEmpty()
                || data.isEmpty()
                || effectiveDate == null
                || planDescription.isEmpty()) {

            outputLabel.setText("Please complete all required information.");
            return;
        }

        float voiceCallRate;
        float smsRate;
        float dataRate;

        try {

            voiceCallRate = Float.parseFloat(voiceRate);
            smsRate = Float.parseFloat(sms);
            dataRate = Float.parseFloat(data);
        }
        catch (Exception e) {

            outputLabel.setText("Please enter valid numeric rates.");
            return;
        }

        if (!(voiceCallRate >= 0)
                || !(smsRate >= 0)
                || !(dataRate >= 0)
                || voiceCallRate == Float.POSITIVE_INFINITY
                || smsRate == Float.POSITIVE_INFINITY
                || dataRate == Float.POSITIVE_INFINITY) {

            outputLabel.setText("Rates must be valid non-negative numbers.");
            return;
        }

        TariffPlanSubmission plan =
                new TariffPlanSubmission(
                        operatorName,
                        tariffPlanName,
                        serviceType,
                        planCategory,
                        voiceCallRate,
                        smsRate,
                        dataRate,
                        effectiveDate,
                        planDescription
                );

        try {

            File f = new File("TariffPlanSubmission.bin");

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

            oos.writeObject(plan);
            oos.close();

            outputLabel.setText("Tariff Plan Submitted Successfully.");
        }
        catch (Exception e) {

            outputLabel.setText("Tariff Plan Submission Failed.");
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
