
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

import java.io.*;
import java.time.LocalDate;

public class ServiceOutageReportingViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeComboBox;
    @javafx.fxml.FXML
    private TextArea outageDescriptionTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextField outageStartTimeTextField;
    @javafx.fxml.FXML
    private DatePicker outageStartDateDatePicker;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private TextField outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        operatorNameComboBox.getItems().addAll(
                "Banglalink", "Grameenphone", "Robi",
                "Airtel", "Teletalk"
        );

        serviceTypeComboBox.getItems().addAll(
                "Internet", "Voice Call", "SMS"
        );
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameComboBox.setValue(null);
        serviceTypeComboBox.setValue(null);
        outageStartDateDatePicker.setValue(null);

        outageStartTimeTextField.clear();
        locationTextField.clear();
        outageDescriptionTextArea.clear();
        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SubmitOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameComboBox.getValue();
        String serviceType = serviceTypeComboBox.getValue();
        String outageStartTime = outageStartTimeTextField.getText();
        String location = locationTextField.getText();
        String outageDescription = outageDescriptionTextArea.getText();
        LocalDate outageStartDate = outageStartDateDatePicker.getValue();

        if (operatorName == null || serviceType == null
                || outageStartTime.isEmpty()
                || location.isEmpty()
                || outageDescription.isEmpty()
                || outageStartDate == null) {

            outputLabel.setText("Please complete all information.");
            return;
        }

        if (LocalDate.now().isBefore(outageStartDate)) {

            outputLabel.setText("Outage start date cannot be in the future.");
            return;
        }

        ServiceOutageReporting report = new ServiceOutageReporting(
                operatorName,
                serviceType,
                outageStartTime,
                location,
                outageDescription,
                outageStartDate
        );

        try {

            File f = new File("ServiceOutageReport.bin");

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

            outputLabel.setText("Service Outage Report Submitted Successfully.");
        }
        catch (Exception e) {

            outputLabel.setText("Service Outage Report Submission Failed.");
        }
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
