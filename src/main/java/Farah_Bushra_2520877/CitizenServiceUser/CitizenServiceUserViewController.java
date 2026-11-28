
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CitizenServiceUserViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void ServiceFeedbackSubmissionOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/ServiceFeedbackSubmissionView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Service Feedback Submission");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void VerifyRegisteredSimInformationOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/VerifyRegisteredSIMInformationView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Verify Registered SIM Information");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void CallDropReportingOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/CallDropReportingView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Call Drop Reporting");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void LicenseInformationInquiryOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/LicenseInformationInquiry.View.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("License Information Inquiry");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void RegisterAComplaintOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/RegisterAComplaintView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Register a Complaint");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void ServiceOutageReportingOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/ServiceOutageReportingView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Service Outage Reporting");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void DeviceIMEIVerificationOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/DeviceIMEIVerficationView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Device IMEI Verification");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void SignOutOnAction(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void ServiceQualityInquiryOnAction(ActionEvent actionEvent) {

        try {
            FXMLLoader myFxmlLoader = new FXMLLoader(
                    BushraApplication.class.getResource(
                            "/org/main/btrc_simulating_website_project/Farah_Bushra_2520877/CitizenServiceUserView/ServiceQualityInquiryView.fxml"
                    )
            );

            Scene nextScene = new Scene(myFxmlLoader.load());

            Stage currentStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();

            currentStage.setScene(nextScene);
            currentStage.setTitle("Service Quality Inquiry");
            currentStage.show();
        }
        catch (Exception e) {

        }
    }
}
