
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ServiceQualityInquiryViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextField serviceRemarksTextField;
    @javafx.fxml.FXML
    private TextField locationTextField;
    @javafx.fxml.FXML
    private TextField qualityStatusTextField;
    @javafx.fxml.FXML
    private TextField outputLabel;

    private ArrayList<ServiceQualityInquiry> qualityList =
            new ArrayList<ServiceQualityInquiry>();

    @javafx.fxml.FXML
    public void initialize() {

        operatorNameComboBox.getItems().addAll(
                "Banglalink", "Grameenphone", "Robi",
                "Airtel", "Teletalk"
        );

        serviceTypeComboBox.getItems().addAll(
                "Internet", "Voice Call", "SMS"
        );

        File f = new File("ServiceQuality.bin");

        if (f.exists()) {
            loadServiceQuality();
        }
        else {

            qualityList.add(new ServiceQualityInquiry(
                    "Grameenphone", "Internet",
                    "Uttara", "Good",
                    "Stable internet connection."
            ));

            qualityList.add(new ServiceQualityInquiry(
                    "Robi", "Voice Call",
                    "Mirpur", "Average",
                    "Occasional call interruptions."
            ));

            qualityList.add(new ServiceQualityInquiry(
                    "Banglalink", "Internet",
                    "Dhanmondi", "Poor",
                    "Slow internet speed."
            ));

            qualityList.add(new ServiceQualityInquiry(
                    "Teletalk", "SMS",
                    "Uttara", "Good",
                    "SMS service is working properly."
            ));
        }
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameComboBox.setValue(null);
        serviceTypeComboBox.setValue(null);

        locationTextField.clear();
        qualityStatusTextField.clear();
        serviceRemarksTextField.clear();
        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameComboBox.getValue();
        String serviceType = serviceTypeComboBox.getValue();
        String area = locationTextField.getText();

        qualityStatusTextField.clear();
        serviceRemarksTextField.clear();

        if (operatorName == null || serviceType == null
                || area.isEmpty()) {

            outputLabel.setText("Please complete all search information.");
            return;
        }

        for (ServiceQualityInquiry quality : qualityList) {

            if (quality.getOperatorName().equals(operatorName)
                    && quality.getServiceType().equals(serviceType)
                    && quality.getArea().equals(area)) {

                qualityStatusTextField.setText(
                        quality.getQualityStatus()
                );

                serviceRemarksTextField.setText(
                        quality.getServiceRemarks()
                );

                outputLabel.setText("Service Quality Information Found.");
                return;
            }
        }

        outputLabel.setText("No matching service quality information found.");
    }

    public void loadServiceQuality() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream("ServiceQuality.bin");
            ois = new ObjectInputStream(fis);

            if (!qualityList.isEmpty()) {
                qualityList.clear();
            }

            while (true) {

                qualityList.add(
                        (ServiceQualityInquiry) ois.readObject()
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
    public void BackToDashBoardOnAction(ActionEvent actionEvent) {

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
