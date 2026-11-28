
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.BushraApplication;
import Farah_Bushra_2520877.CitizenServiceUser.AppendableObjectOutputStream;
import Farah_Bushra_2520877.CitizenServiceUser.LicenseInformationInquiry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.util.ArrayList;

public class SpectrumRequestSubmissionViewController {

    @FXML
    private TextField licenseNumberTextField;
    @FXML
    private TextField requestedBandwidthTextField;
    @FXML
    private TextField coverageAreaTextField;
    @FXML
    private TextField operatorNameTextField;
    @FXML
    private DatePicker requestDateDatePicker;
    @FXML
    private TextArea purposeOfRequestTextArea;
    @FXML
    private ComboBox<String> frequencyBandComboBox;
    @FXML
    private TextField outputLabel;

    private ArrayList<LicenseInformationInquiry> licenseList =
            new ArrayList<>();

    private ArrayList<TelecomCompany> companyList =
            new ArrayList<>();

    @FXML
    public void initialize() {

        frequencyBandComboBox.getItems().addAll(
                "700 MHz",
                "900 MHz",
                "1800 MHz",
                "2100 MHz",
                "2600 MHz",
                "3500 MHz"
        );

        outputLabel.setEditable(false);

        loadLicenses();

        companyList.add(new TelecomCompany(
                "REG-1001",
                "Grameenphone",
                "Demo Contact"
        ));

        companyList.add(new TelecomCompany(
                "REG-1002",
                "Robi",
                "Demo Contact"
        ));

        for (TelecomCompany company : companyList) {

            for (LicenseInformationInquiry license : licenseList) {

                company.addLicense(license);
            }
        }
    }

    public void loadLicenses() {

        licenseList.clear();

        File f = new File("LicenseRegistry.bin");

        if (!f.exists()) {

            licenseList.add(
                    new LicenseInformationInquiry(
                            "1001",
                            "Grameenphone",
                            "Mobile Operator",
                            LocalDate.of(2020, 1, 1),
                            LocalDate.of(2030, 1, 1),
                            "Active"
                    )
            );

            return;
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true) {

                licenseList.add(
                        (LicenseInformationInquiry) ois.readObject()
                );
            }
        }
        catch (EOFException e) {

        }
        catch (Exception e) {

            licenseList.clear();

            outputLabel.setText(
                    "Unable to load license records.");
        }

        try {

            if (ois != null) {

                ois.close();
            }
            else if (fis != null) {

                fis.close();
            }
        }
        catch (Exception e) {

        }
    }

    public LicenseInformationInquiry findLicense(
            String operatorName,
            String licenseNumber) {

        for (TelecomCompany company : companyList) {

            if (company.getCompanyName().equals(operatorName)) {

                for (LicenseInformationInquiry license :
                        company.getLicenseList()) {

                    if (license.getLicenseNo().equals(licenseNumber)
                            && license.isActiveLicense()) {

                        return license;
                    }
                }
            }
        }

        for (LicenseInformationInquiry license : licenseList) {

            if (license.getCompanyName().equals(operatorName)
                    && license.getLicenseNo().equals(licenseNumber)
                    && license.isActiveLicense()) {

                return license;
            }
        }

        return null;
    }

    public boolean verifyLicense(String operatorName,
                                 String licenseNumber) {

        return findLicense(operatorName, licenseNumber) != null;
    }

    @FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameTextField.clear();
        licenseNumberTextField.clear();
        frequencyBandComboBox.setValue(null);
        requestedBandwidthTextField.clear();
        coverageAreaTextField.clear();
        requestDateDatePicker.setValue(null);
        purposeOfRequestTextArea.clear();
        outputLabel.clear();
    }

    @FXML
    public void SubmitRequestOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameTextField.getText();

        String licenseNumber = licenseNumberTextField.getText();

        String frequencyBand = frequencyBandComboBox.getValue();

        String requestedBandwidth =
                requestedBandwidthTextField.getText();

        String coverageArea = coverageAreaTextField.getText();

        LocalDate requestDate = requestDateDatePicker.getValue();

        String purpose = purposeOfRequestTextArea.getText();

        if (operatorName.isEmpty()
                || licenseNumber.isEmpty()
                || frequencyBand == null
                || requestedBandwidth.isEmpty()
                || coverageArea.isEmpty()
                || requestDate == null
                || purpose.isEmpty()) {

            outputLabel.setText(
                    "Please complete all required information.");

            return;
        }

        double bandwidth;

        try {

            bandwidth = Double.parseDouble(requestedBandwidth);
        }
        catch (NumberFormatException e) {

            outputLabel.setText(
                    "Please enter a valid bandwidth.");

            return;
        }

        if (!(bandwidth > 0)
                || bandwidth == Double.POSITIVE_INFINITY) {

            outputLabel.setText(
                    "Bandwidth must be a positive number.");

            return;
        }

        if (LocalDate.now().isBefore(requestDate)) {

            outputLabel.setText(
                    "Request date cannot be in the future.");

            return;
        }

        LicenseInformationInquiry matchedLicense =
                findLicense(operatorName, licenseNumber);

        if (matchedLicense == null) {

            outputLabel.setText(
                    "Invalid operator name or license number.");

            return;
        }

        SpectrumRequestSubmission request =
                new SpectrumRequestSubmission(
                        operatorName,
                        licenseNumber,
                        frequencyBand,
                        requestedBandwidth,
                        coverageArea,
                        requestDate,
                        purpose
                );

        request.setLicense(matchedLicense);

        try {

            File f = new File("SpectrumRequest.bin");

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

            oos.writeObject(request);
            oos.close();

            outputLabel.setText(
                    "Spectrum Request Submitted Successfully.");
        }
        catch (Exception e) {

            outputLabel.setText(
                    "Spectrum Request Submission Failed.");
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

            outputLabel.setText(
                    "Unable to open dashboard.");
        }
    }
}