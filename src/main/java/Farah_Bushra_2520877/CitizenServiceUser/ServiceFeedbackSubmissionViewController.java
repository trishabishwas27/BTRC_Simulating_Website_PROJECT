package Farah_Bushra_2520877.CitizenServiceUser;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ServiceFeedbackSubmissionViewController
{
    @javafx.fxml.FXML
    private ComboBox <String> serviceTypeComboBox;
    @javafx.fxml.FXML
    private TextField outputLabel;
    @javafx.fxml.FXML
    private ComboBox <String> operatorNameComboBox;
    @javafx.fxml.FXML
    private TextArea feedbackCommentsTextArea;
    @javafx.fxml.FXML
    private TextField feedbackIdTextField;
    @javafx.fxml.FXML
    private ComboBox <String> ratingComboBox;

    private ArrayList<ServiceFeedbackSubmission> feedbackList = new ArrayList<ServiceFeedbackSubmission>();

    @javafx.fxml.FXML
    public void initialize() {
        operatorNameComboBox.getItems().addAll("Banglalink", "Grameenphone", "Robi", "Airtel", "Teletalk");
        serviceTypeComboBox.getItems().addAll("Internet", "Voice Call", "SMS");
        ratingComboBox.getItems().addAll("Excellent", "Good", "Average", "Poor");

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

        } else {

            String feedbackId = "F-" + (feedbackList.size() + 1);
            ServiceFeedbackSubmission f = new ServiceFeedbackSubmission(operatorName, serviceType, rating,
                    feedbackComments, feedbackId);
            feedbackList.add(f);
            feedbackIdTextField.setText(feedbackId);
            outputLabel.setText("Feedback Submitted Successfully! Feedback ID: " + feedbackId);
        }


    }

    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {
        outputLabel.setText("Back to Dashboard selected.");
    }
}