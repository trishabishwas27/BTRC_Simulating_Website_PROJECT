
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.BushraApplication;
import Farah_Bushra_2520877.CitizenServiceUser.AppendableObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TariffPlanSubmissionViewController {

    @FXML
    private ComboBox<String> serviceTypeComboBox;
    @FXML
    private TextField voiceCallRateTextField;
    @FXML
    private TextField operatorNameTextField;
    @FXML
    private TextField tariffPlanNameTextField;
    @FXML
    private ComboBox<String> planCategoryComboBox;
    @FXML
    private TextArea planDescriptionTextArea;
    @FXML
    private DatePicker effectiveDateDatePicker;
    @FXML
    private TextField smsRateTextField;
    @FXML
    private TextField dataRateTextField;
    @FXML
    private TextField outputLabel;

    @FXML
    private TableColumn<TariffPlanSubmission, LocalDate> efffectiveTableCol;
    @FXML
    private TableColumn<TariffPlanSubmission, String> tariffplanNameTableCol;
    @FXML
    private TableColumn<TariffPlanSubmission, String> operatorNameTableCol;
    @FXML
    private TableColumn<TariffPlanSubmission, Float> smsRateTableCol;
    @FXML
    private TableColumn<TariffPlanSubmission, String> serviceTypeTableCol;
    @FXML
    private TableColumn<TariffPlanSubmission, Float> dataRateTableCol;
    @FXML
    private TableView<TariffPlanSubmission> tableViewTariff;
    @FXML
    private TableColumn<TariffPlanSubmission, Float> voiceRateTableCol;

    private ArrayList<TariffPlanSubmission> tariffList =
            new ArrayList<>();

    @FXML
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

        operatorNameTableCol.setCellValueFactory(
                new PropertyValueFactory<>("operatorName"));

        tariffplanNameTableCol.setCellValueFactory(
                new PropertyValueFactory<>("tariffPlanName"));

        serviceTypeTableCol.setCellValueFactory(
                new PropertyValueFactory<>("serviceType"));

        voiceRateTableCol.setCellValueFactory(
                new PropertyValueFactory<>("voiceCallRate"));

        smsRateTableCol.setCellValueFactory(
                new PropertyValueFactory<>("smsRate"));

        dataRateTableCol.setCellValueFactory(
                new PropertyValueFactory<>("dataRate"));

        efffectiveTableCol.setCellValueFactory(
                new PropertyValueFactory<>("effectiveDate"));

        loadTariffPlans();
        showTariffPlans();
    }

    public void loadTariffPlans() {

        tariffList.clear();

        File f = new File("TariffPlanSubmission.bin");

        if (!f.exists() || f.length() == 0) {
            return;
        }

        try {

            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {

                while (true) {

                    TariffPlanSubmission plan =
                            (TariffPlanSubmission) ois.readObject();

                    tariffList.add(plan);
                }
            }
            catch (EOFException e) {
                // End of file
            }
            finally {
                ois.close();
            }
        }
        catch (Exception e) {

            outputLabel.setText("Unable to load saved tariff plans.");
        }
    }

    public void showTariffPlans() {

        tableViewTariff.getItems().clear();
        tableViewTariff.getItems().addAll(tariffList);
    }

    @FXML
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

    @FXML
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

            outputLabel.setText(
                    "Please complete all required information.");
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

            outputLabel.setText(
                    "Please enter valid numeric rates.");
            return;
        }

        if (!(voiceCallRate >= 0)
                || !(smsRate >= 0)
                || !(dataRate >= 0)
                || voiceCallRate == Float.POSITIVE_INFINITY
                || smsRate == Float.POSITIVE_INFINITY
                || dataRate == Float.POSITIVE_INFINITY) {

            outputLabel.setText(
                    "Rates must be valid non-negative numbers.");
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

            if (f.exists() && f.length() > 0) {

                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {

                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(plan);
            oos.close();

            tariffList.add(plan);

            showTariffPlans();

            outputLabel.setText(
                    "Tariff Plan Submitted Successfully.");
        }
        catch (Exception e) {

            outputLabel.setText(
                    "Tariff Plan Submission Failed.");
        }
    }

    @FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {

        try {

            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/TelecomOperatorRepresentativeView/TelecomOperatorRepresentiveView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage =
                    (Stage)((Node) actionEvent.getSource())
                            .getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle(
                    "Telecom Operator Representative Dashboard");

            currentStage.show();
        }
        catch (Exception e) {

            outputLabel.setText("Unable to open dashboard.");
        }
    }
}