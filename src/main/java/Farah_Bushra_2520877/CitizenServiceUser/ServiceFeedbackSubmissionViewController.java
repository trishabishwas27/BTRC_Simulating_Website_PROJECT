
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ServiceFeedbackSubmissionViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> serviceTypeComboBox;
    @javafx.fxml.FXML
    private TextField outputLabel;
    @javafx.fxml.FXML
    private ComboBox<String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextArea feedbackCommentsTextArea;
    @javafx.fxml.FXML
    private TextField feedbackIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> ratingComboBox;

    private ArrayList<ServiceFeedbackSubmission> feedbackList = new ArrayList<ServiceFeedbackSubmission>();

    @javafx.fxml.FXML
    public void initialize() {

        operatorNameComboBox.getItems().addAll(
                "Banglalink", "Grameenphone", "Robi",
                "Airtel", "Teletalk"
        );

        serviceTypeComboBox.getItems().addAll(
                "Internet", "Voice Call", "SMS"
        );

        ratingComboBox.getItems().addAll(
                "1", "2", "3", "4", "5"
        );

        loadFeedback();
    }

    @javafx.fxml.FXML
    public void SubmitFeedbackOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameComboBox.getValue();
        String serviceType = serviceTypeComboBox.getValue();
        String rating = ratingComboBox.getValue();
        String feedbackComments = feedbackCommentsTextArea.getText();

        if (operatorName == null || serviceType == null
                || rating == null || feedbackComments.isEmpty()) {

            outputLabel.setText("Please complete all information.");
            return;
        }

        String feedbackId = Integer.toString(feedbackList.size() + 1);

        ServiceFeedbackSubmission f = new ServiceFeedbackSubmission(
                operatorName, serviceType, rating,
                feedbackComments, feedbackId
        );

        try {

            File file = new File("ServiceFeedback.bin");

            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(f);
            oos.close();

            feedbackList.add(f);

            feedbackIdTextField.setText(feedbackId);

            outputLabel.setText("Feedback Submitted Successfully! Feedback ID: " + feedbackId);
        }
        catch (Exception e) {
            outputLabel.setText("Feedback Submission Failed.");
        }
    }

    public void loadFeedback() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("ServiceFeedback.bin");
            ois = new ObjectInputStream(fis);

            if (!feedbackList.isEmpty()) {
                feedbackList.clear();
            }

            while (true) {
                feedbackList.add(
                        (ServiceFeedbackSubmission) ois.readObject()
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
