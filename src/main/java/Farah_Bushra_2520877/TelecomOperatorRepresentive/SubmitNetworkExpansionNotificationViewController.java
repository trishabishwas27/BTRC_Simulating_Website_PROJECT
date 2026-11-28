
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.BushraApplication;
import Farah_Bushra_2520877.CitizenServiceUser.AppendableObjectOutputStream;

import javafx.event.ActionEvent;
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
    private ComboBox<String> expansionTypeComboBox;
    @javafx.fxml.FXML
    private TextField notificationStatusTextField;

    private ArrayList<SubmitNetworkExpansionNotification> notificationList;

    private boolean fileLoaded;

    @javafx.fxml.FXML
    public void initialize() {

        notificationList =
                new ArrayList<SubmitNetworkExpansionNotification>();

        expansionTypeComboBox.getItems().addAll(
                "Coverage Expansion",
                "Capacity Expansion",
                "Technology Upgrade",
                "New Tower Installation"
        );

        notificationIdTextField.setEditable(false);
        notificationStatusTextField.setEditable(false);
        outputLabel.setEditable(false);

        notificationIdTextField.setText("Not Generated");
        notificationStatusTextField.setText("Not Submitted");

        loadNotifications();
    }

    public void loadNotifications() {

        notificationList.clear();

        File f = new File("NetworkExpansionNotification.bin");

        fileLoaded = false;

        if (!f.exists()) {

            fileLoaded = true;
            return;
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (true) {

                notificationList.add(
                        (SubmitNetworkExpansionNotification)
                                ois.readObject()
                );
            }
        }
        catch (EOFException e) {

            if (ois != null) {
                fileLoaded = true;
            }
        }
        catch (Exception e) {

            outputLabel.setText("Unable to load previous notifications.");
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

    @javafx.fxml.FXML
    public void SubmitNotificationOnAction(ActionEvent actionEvent) {

        String area = expansionAreaTextField.getText();
        String type = expansionTypeComboBox.getValue();
        String towers = numberOfNewTowersTextField.getText();
        LocalDate date = expectedStartingDateDatePicker.getValue();
        String description = expansionDescriptionTextArea.getText();

        if (area.isEmpty()
                || type == null
                || towers.isEmpty()
                || date == null
                || description.isEmpty()) {

            outputLabel.setText("Please complete all required information.");
            return;
        }

        int numberOfTowers;

        try {

            numberOfTowers = Integer.parseInt(towers);
        }
        catch (NumberFormatException e) {

            outputLabel.setText("Please enter a valid whole number of towers.");
            return;
        }

        if (numberOfTowers < 0) {

            outputLabel.setText("Number of towers cannot be negative.");
            return;
        }

        if (date.isBefore(LocalDate.now())) {

            outputLabel.setText("Expected starting date cannot be in the past.");
            return;
        }

        if (!fileLoaded) {

            outputLabel.setText("Previous notifications could not be loaded.");
            return;
        }

        String notificationId =
                Integer.toString(notificationList.size() + 1);

        String notificationStatus = "Submitted";

        SubmitNetworkExpansionNotification n =
                new SubmitNetworkExpansionNotification(
                        area,
                        type,
                        numberOfTowers,
                        date,
                        description,
                        notificationId,
                        notificationStatus
                );

        try {

            File f = new File("NetworkExpansionNotification.bin");

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

            oos.writeObject(n);
            oos.close();

            notificationList.add(n);

            notificationIdTextField.setText(notificationId);
            notificationStatusTextField.setText(notificationStatus);

            outputLabel.setText(
                    "Network Expansion Notification Submitted Successfully."
            );
        }
        catch (Exception e) {

            fileLoaded = false;

            outputLabel.setText("Notification submission failed.");
        }
    }

    @javafx.fxml.FXML
    public void BackToDashBoardOnAction(ActionEvent actionEvent) {

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

            outputLabel.setText("Unable to open dashboard.");
        }
    }
}
