
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class DeviceIMEIVerficationViewController
{
    @javafx.fxml.FXML
    private TextField deviceStatusTextField;
    @javafx.fxml.FXML
    private TextField IMEINumberTextField;
    @javafx.fxml.FXML
    private TextField deviceModelTextField;
    @javafx.fxml.FXML
    private TextField verificationStatusTextField;
    @javafx.fxml.FXML
    private TextField deviceBrandTextField;

    private ArrayList<DeviceIMEIVerification> deviceList =
            new ArrayList<DeviceIMEIVerification>();
    @javafx.fxml.FXML
    private TextField outputLabel;

    @javafx.fxml.FXML
    public void initialize() {

        File f = new File("DeviceRegistry.bin");

        if (f.exists()) {

            loadDeviceRecords();
        }
        else {

            deviceList.add(new DeviceIMEIVerification(
                    "111111111111119",
                    "Samsung", "Galaxy A15",
                    "Registered", "Verified"
            ));

            deviceList.add(new DeviceIMEIVerification(
                    "222222222222228",
                    "Xiaomi", "Redmi Note 13",
                    "Unregistered", "Not Verified"
            ));

            deviceList.add(new DeviceIMEIVerification(
                    "333333333333337",
                    "Apple", "iPhone 13",
                    "Blocked", "Verified"
            ));
        }
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        IMEINumberTextField.clear();
        deviceBrandTextField.clear();
        deviceModelTextField.clear();
        deviceStatusTextField.clear();
        verificationStatusTextField.clear();

        outputLabel.setText("");
    }

    @javafx.fxml.FXML
    public void VerifyOnAction(ActionEvent actionEvent) {

        String imeiNumber = IMEINumberTextField.getText();

        deviceBrandTextField.clear();
        deviceModelTextField.clear();
        deviceStatusTextField.clear();
        verificationStatusTextField.clear();

        if (imeiNumber.isEmpty()) {

            outputLabel.setText("Please enter IMEI number.");
            return;
        }

        if (imeiNumber.length() != 15) {

            outputLabel.setText("IMEI number must contain 15 digits.");
            return;
        }

        for (int i = 0; i < imeiNumber.length(); i++) {

            if (imeiNumber.charAt(i) < '0'
                    || imeiNumber.charAt(i) > '9') {

                outputLabel.setText("IMEI number must contain digits only.");
                return;
            }
        }

        for (DeviceIMEIVerification device : deviceList) {

            if (device.getIMEINumber().equals(imeiNumber)) {

                deviceBrandTextField.setText(
                        device.getDeviceBrand()
                );

                deviceModelTextField.setText(
                        device.getDeviceModel()
                );

                deviceStatusTextField.setText(
                        device.getDeviceStatus()
                );

                verificationStatusTextField.setText(
                        device.getVerificationStatus()
                );

                outputLabel.setText("Device Information Found.");

                return;
            }
        }

        outputLabel.setText("No matching device information found.");
    }

    public void loadDeviceRecords() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream("DeviceRegistry.bin");
            ois = new ObjectInputStream(fis);

            if (!deviceList.isEmpty()) {
                deviceList.clear();
            }

            while (true) {

                deviceList.add(
                        (DeviceIMEIVerification) ois.readObject()
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
