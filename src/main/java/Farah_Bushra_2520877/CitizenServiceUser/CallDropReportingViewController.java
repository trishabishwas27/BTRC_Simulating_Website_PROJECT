
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CallDropReportingViewController
{
    @javafx.fxml.FXML
    private DatePicker callDropDateDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextField mobileNumberTextField;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private TextField callDropTimeTextField;
    @javafx.fxml.FXML
    private TableColumn<CallDropReporting, String> mobileNoTableCol;
    @javafx.fxml.FXML
    private TableColumn<CallDropReporting, String> operatorNameTableCol;
    @javafx.fxml.FXML
    private TableColumn<CallDropReporting, LocalDate> callDropDateTableCol;
    @javafx.fxml.FXML
    private TableView<CallDropReporting> TableViewCallDropReport;
    @javafx.fxml.FXML
    private TableColumn<CallDropReporting, String> callDropTimeTableCol;
    @javafx.fxml.FXML
    private TextField outputLabel;
    @javafx.fxml.FXML
    private TableColumn<CallDropReporting, String> remarksTableCol;
    @javafx.fxml.FXML
    private TableColumn<CallDropReporting, String> locationTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> filterOperatorComboBox;

    private ArrayList<CallDropReporting> callDropList =
            new ArrayList<CallDropReporting>();

    @javafx.fxml.FXML
    public void initialize() {

        operatorNameComboBox.getItems().addAll(
                "Banglalink", "Grameenphone", "Robi",
                "Airtel", "Teletalk"
        );

        filterOperatorComboBox.getItems().addAll(
                "Banglalink", "Grameenphone", "Robi",
                "Airtel", "Teletalk"
        );

        operatorNameTableCol.setCellValueFactory(
                new PropertyValueFactory<>("operatorName")
        );

        mobileNoTableCol.setCellValueFactory(
                new PropertyValueFactory<>("mobileNumber")
        );

        callDropDateTableCol.setCellValueFactory(
                new PropertyValueFactory<>("callDropDate")
        );

        callDropTimeTableCol.setCellValueFactory(
                new PropertyValueFactory<>("callDropTime")
        );

        locationTableCol.setCellValueFactory(
                new PropertyValueFactory<>("location")
        );

        remarksTableCol.setCellValueFactory(
                new PropertyValueFactory<>("remarks")
        );

        loadCallDropReports();

        for (CallDropReporting report : callDropList) {
            TableViewCallDropReport.getItems().add(report);
        }
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameComboBox.setValue(null);
        mobileNumberTextField.clear();
        callDropTimeTextField.clear();
        callDropDateDatePicker.setValue(null);
        locationTextField.clear();
        remarksTextArea.clear();
        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SubmitOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameComboBox.getValue();
        String mobileNumber = mobileNumberTextField.getText();
        String callDropTime = callDropTimeTextField.getText();
        String location = locationTextField.getText();
        String remarks = remarksTextArea.getText();
        LocalDate callDropDate = callDropDateDatePicker.getValue();

        if (operatorName == null || mobileNumber.isEmpty()
                || callDropTime.isEmpty()
                || callDropDate == null
                || location.isEmpty()
                || remarks.isEmpty()) {

            outputLabel.setText("Please complete all information.");
            return;
        }

        if (mobileNumber.length() != 11
                || !mobileNumber.startsWith("01")) {

            outputLabel.setText("Mobile number must have 11 digits and start with 01.");
            return;
        }

        for (int i = 0; i < mobileNumber.length(); i++) {

            if (mobileNumber.charAt(i) < '0'
                    || mobileNumber.charAt(i) > '9') {

                outputLabel.setText("Mobile number must contain digits only.");
                return;
            }
        }

        if (callDropDate.isAfter(LocalDate.now())) {

            outputLabel.setText("Call drop date cannot be in the future.");
            return;
        }

        CallDropReporting report = new CallDropReporting(
                operatorName,
                mobileNumber,
                callDropTime,
                location,
                remarks,
                callDropDate
        );

        try {

            File f = new File("CallDropReport.bin");

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

            callDropList.add(report);

            TableViewCallDropReport.getItems().clear();

            for (CallDropReporting r : callDropList) {
                TableViewCallDropReport.getItems().add(r);
            }

            filterOperatorComboBox.setValue(null);

            outputLabel.setText("Call Drop Report Submitted Successfully.");
        }
        catch (Exception e) {

            outputLabel.setText("Call Drop Report Submission Failed.");
        }
    }

    @javafx.fxml.FXML
    public void ShowAllOnAction(ActionEvent actionEvent) {

        TableViewCallDropReport.getItems().clear();

        for (CallDropReporting report : callDropList) {

            TableViewCallDropReport.getItems().add(report);
        }

        filterOperatorComboBox.setValue(null);

        outputLabel.setText("All Call Drop Reports Displayed.");
    }

    @javafx.fxml.FXML
    public void FilterOnAction(ActionEvent actionEvent) {

        String operatorName = filterOperatorComboBox.getValue();

        if (operatorName == null) {

            outputLabel.setText("Please select an operator to filter.");
            return;
        }

        TableViewCallDropReport.getItems().clear();

        for (CallDropReporting report : callDropList) {

            if (report.getOperatorName().equals(operatorName)) {

                TableViewCallDropReport.getItems().add(report);
            }
        }

        if (TableViewCallDropReport.getItems().isEmpty()) {

            outputLabel.setText("No matching call drop reports found.");
        }
        else {

            outputLabel.setText("Filtered Call Drop Reports Displayed.");
        }
    }

    public void loadCallDropReports() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream("CallDropReport.bin");
            ois = new ObjectInputStream(fis);

            if (!callDropList.isEmpty()) {
                callDropList.clear();
            }

            while (true) {

                callDropList.add(
                        (CallDropReporting) ois.readObject()
                );
            }
        }
        catch (Exception e) {

            try {
                ois.close();
            }
            catch (Exception e2) {

            }
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
