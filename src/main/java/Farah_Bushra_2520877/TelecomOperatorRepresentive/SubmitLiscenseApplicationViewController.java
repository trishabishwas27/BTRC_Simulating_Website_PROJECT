
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
    private ComboBox<String> liscenseTypeComboBox;
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

    @javafx.fxml.FXML
    public void initialize() {

        applicationList = new ArrayList<SubmitLiscenseApplication>();

        registeredCompanyNumbers = new ArrayList<String>();

        registeredCompanyNumbers.add("REG-1001");
        registeredCompanyNumbers.add("REG-1002");

        liscenseTypeComboBox.getItems().addAll(
                "Mobile Operator", "ISP", "Other"
        );

        applicationIdTextField.setEditable(false);
        applicationStatusTextFIeld.setEditable(false);
        outputLabelTextField.setEditable(false);

        applicationIdTextField.setText("Not Generated");
        applicationStatusTextFIeld.setText("Not Submitted");

        loadApplications();
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
    public void SubmitApplicationOnAction(ActionEvent actionEvent) {

        if (!isValid()) {

            Alert a = new Alert(Alert.AlertType.ERROR);

            a.setTitle("Invalid Application");
            a.setContentText("Please complete all required information.");
            a.showAndWait();

            return;
        }

        String companyName = companyNameTextField.getText();
        String registrationNumber = registrationNumberTextField.getText();
        String contactInformation = contactInformationTextField.getText();
        String licenseType = liscenseTypeComboBox.getValue();
        String reasonForApplying = reasonForApplyingTextArea.getText();
        LocalDate applicationDate = applicationDateDatePicker.getValue();

        if (LocalDate.now().isBefore(applicationDate)) {

            Alert a = new Alert(Alert.AlertType.ERROR);

            a.setTitle("Invalid Application Date");
            a.setContentText("Application date cannot be in the future.");
            a.showAndWait();

            return;
        }

        boolean registrationFound = false;

        for (String reg : registeredCompanyNumbers) {

            if (reg.equals(registrationNumber)) {

                registrationFound = true;
            }
        }

        if (!registrationFound) {

            Alert a = new Alert(Alert.AlertType.ERROR);

            a.setTitle("Registration Verification");
            a.setContentText("Company registration information does not match.");
            a.showAndWait();

            return;
        }

        if (!((companyName.equals("Grameenphone")
                && registrationNumber.equals("REG-1001"))
                ||
                (companyName.equals("Robi")
                        && registrationNumber.equals("REG-1002")))) {

            Alert a = new Alert(Alert.AlertType.ERROR);

            a.setTitle("Registration Verification");
            a.setContentText("Company name and registration number do not match.");
            a.showAndWait();

            return;
        }

        String applicationId =
                Integer.toString(applicationList.size() + 1);

        SubmitLiscenseApplication newApplication =
                new SubmitLiscenseApplication(
                        companyName,
                        registrationNumber,
                        contactInformation,
                        licenseType,
                        reasonForApplying,
                        applicationDate,
                        applicationId,
                        "Pending"
                );

        try {

            File f = new File("LicenseApplication.bin");

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

            oos.writeObject(newApplication);
            oos.close();

            applicationList.add(newApplication);

            applicationIdTextField.setText(applicationId);
            applicationStatusTextFIeld.setText("Pending");

            outputLabelTextField.setText(
                    "Application Submitted Successfully! Application ID: "
                            + applicationId
            );
        }
        catch (Exception e) {

            outputLabelTextField.setText(
                    "License Application Submission Failed."
            );
        }
    }

    public void loadApplications() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream("LicenseApplication.bin");
            ois = new ObjectInputStream(fis);

            if (!applicationList.isEmpty()) {

                applicationList.clear();
            }

            while (true) {

                applicationList.add(
                        (SubmitLiscenseApplication) ois.readObject()
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

            outputLabelTextField.setText("Unable to open dashboard.");
        }
    }
}
