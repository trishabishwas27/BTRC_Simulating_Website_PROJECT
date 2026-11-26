
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class LicenseInformationInquiryViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> licenseStatusComboBox;
    @javafx.fxml.FXML
    private DatePicker expiredDateDatePicker;
    @javafx.fxml.FXML
    private TextField licenseNumberTextField;
    @javafx.fxml.FXML
    private ComboBox<String> licenseTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker issueDateDatePicker;
    @javafx.fxml.FXML
    private TextField companyNameTextField;
    @javafx.fxml.FXML
    private Label outputLabel;

    private ArrayList<LicenseInformationInquiry> licenseList =
            new ArrayList<LicenseInformationInquiry>();

    @javafx.fxml.FXML
    public void initialize() {

        licenseTypeComboBox.getItems().addAll(
                "Mobile Operator", "ISP", "Broadband"
        );

        licenseStatusComboBox.getItems().addAll(
                "Active", "Expired", "Suspended"
        );

        File f = new File("LicenseRegistry.bin");

        if (f.exists()) {
            loadLicenses();
        }
        else {

            licenseList.add(new LicenseInformationInquiry(
                    "1001", "Grameenphone",
                    "Mobile Operator",
                    LocalDate.of(2020, 1, 1),
                    LocalDate.of(2030, 1, 1),
                    "Active"
            ));

            licenseList.add(new LicenseInformationInquiry(
                    "1002", "Robi",
                    "Mobile Operator",
                    LocalDate.of(2021, 1, 1),
                    LocalDate.of(2031, 1, 1),
                    "Active"
            ));

            licenseList.add(new LicenseInformationInquiry(
                    "1003", "Banglalink",
                    "Mobile Operator",
                    LocalDate.of(2015, 1, 1),
                    LocalDate.of(2025, 1, 1),
                    "Expired"
            ));
        }
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        licenseNumberTextField.clear();
        companyNameTextField.clear();

        licenseTypeComboBox.setValue(null);
        issueDateDatePicker.setValue(null);
        expiredDateDatePicker.setValue(null);
        licenseStatusComboBox.setValue(null);

        outputLabel.setText("");
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {

        String licenseNo = licenseNumberTextField.getText();
        String companyName = companyNameTextField.getText();

        licenseTypeComboBox.setValue(null);
        issueDateDatePicker.setValue(null);
        expiredDateDatePicker.setValue(null);
        licenseStatusComboBox.setValue(null);

        if (licenseNo.isEmpty() && companyName.isEmpty()) {

            outputLabel.setText(
                    "Please enter license number or company name."
            );
            return;
        }

        for (LicenseInformationInquiry license : licenseList) {

            if ((licenseNo.isEmpty()
                    || license.getLicenseNo().equals(licenseNo))
                    &&
                    (companyName.isEmpty()
                            || license.getCompanyName().equals(companyName))) {

                licenseNumberTextField.setText(
                        license.getLicenseNo()
                );

                companyNameTextField.setText(
                        license.getCompanyName()
                );

                licenseTypeComboBox.setValue(
                        license.getLicenseType()
                );

                issueDateDatePicker.setValue(
                        license.getIssueDate()
                );

                expiredDateDatePicker.setValue(
                        license.getExpiryDate()
                );

                licenseStatusComboBox.setValue(
                        license.getLicenseStatus()
                );

                outputLabel.setText(
                        "License Information Found."
                );

                return;
            }
        }

        outputLabel.setText(
                "No matching license information found."
        );
    }

    public void loadLicenses() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream("LicenseRegistry.bin");
            ois = new ObjectInputStream(fis);

            if (!licenseList.isEmpty()) {
                licenseList.clear();
            }

            while (true) {

                licenseList.add(
                        (LicenseInformationInquiry) ois.readObject()
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
