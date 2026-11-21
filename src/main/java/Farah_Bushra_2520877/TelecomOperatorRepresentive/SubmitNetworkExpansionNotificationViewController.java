package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.ArrayList;

public class SubmitNetworkExpansionNotificationViewController
{
    @javafx.fxml.FXML
    private TextArea expansionDescriptionTextArea;
    @javafx.fxml.FXML
    private TextField outputLabel;
    @javafx.fxml.FXML
    private TextField numberOfNewTowersTextField;
    @javafx.fxml.FXML
    private TextField expansionAreaTextField;
    @javafx.fxml.FXML
    private DatePicker expectedStartingDateDatePicker;
    @javafx.fxml.FXML
    private TextField notificationIdTextField;
    @javafx.fxml.FXML
    private ComboBox <String> expansionTypeComboBox;
    @javafx.fxml.FXML
    private TextField notificationStatusTextField;

    private ArrayList<SubmitNetworkExpansionNotification> notificationList = new ArrayList<SubmitNetworkExpansionNotification>();
    int notificationCount = 0;
    @javafx.fxml.FXML
    public void initialize() {

        notificationList = new ArrayList<SubmitNetworkExpansionNotification>();

        expansionTypeComboBox.getItems().addAll("Coverage Expansion", "Capacity Expansion", "Technology Upgrade",
                "New Tower Installation");
    }

    @javafx.fxml.FXML
    public void SubmitNotificationOnAction(ActionEvent actionEvent) {
        String area = expansionAreaTextField.getText();

        String type = expansionTypeComboBox.getValue();

        String towers = numberOfNewTowersTextField.getText();

        LocalDate date = expectedStartingDateDatePicker.getValue();

        String description = expansionDescriptionTextArea.getText();

        if (area.isEmpty() || type == null
                || towers.isEmpty() || date == null
                || description.isEmpty()
                || !towers.matches("[0-9]+")) {

            outputLabel.setText("Please enter all information correctly.");
        }
        else if (Integer.parseInt(towers) <= 0
                || date.isBefore(LocalDate.now())) {

            outputLabel.setText("Please enter a valid tower number and date.");

        }
        else {

            notificationCount++;

            String notificationId = "N-" + notificationCount;

            SubmitNetworkExpansionNotification n = new SubmitNetworkExpansionNotification(area, type,
                    Integer.parseInt(towers), date, description, notificationId, "Submitted");

            notificationList.add(n);

            notificationIdTextField.setText(notificationId);

            notificationStatusTextField.setText("Submitted");

            outputLabel.setText("Network Expansion Notification Submitted Successfully. "
                            + "Notification ID: " + notificationId);
        }


    }

    @javafx.fxml.FXML
    public void BackToDashBoardOnAction(ActionEvent actionEvent) {

        outputLabel.setText("Back to Dashboard selected.");
    }
}