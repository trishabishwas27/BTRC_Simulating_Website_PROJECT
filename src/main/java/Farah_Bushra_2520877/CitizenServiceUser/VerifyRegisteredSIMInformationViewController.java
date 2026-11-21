package Farah_Bushra_2520877.CitizenServiceUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class VerifyRegisteredSIMInformationViewController
{
    @javafx.fxml.FXML
    private TextField reportIdTextField;
    @javafx.fxml.FXML
    private Label outputLabel;
    @javafx.fxml.FXML
    private TextField nidNumberTextField;
    @javafx.fxml.FXML
    private TextField reportStatusTextField;
    @javafx.fxml.FXML
    private TextArea reportReasonTextArea;

    private ArrayList <VerifyRegisteredSIMInformation>simList = new ArrayList<>();
    @javafx.fxml.FXML
    private ComboBox <String>  mobileNumberComboBox1;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        simList = new ArrayList<VerifyRegisteredSIMInformation>();

        simList.add(new VerifyRegisteredSIMInformation(
                "1234567890123", "01712345678",
                "Grameenphone", "", "", "Not Reported"
        ));

        simList.add(new VerifyRegisteredSIMInformation(
                "1234567890123", "01812345678",
                "Robi", "", "", "Not Reported"
        ));
    }

    @javafx.fxml.FXML
    public void CheckSIMOnAction(ActionEvent actionEvent) {
        mobileNumberComboBox1.getItems().clear();

        String nid = nidNumberTextField.getText();

        if (nid.isEmpty()) {
            outputLabel.setText("Please enter NID number.");
            return;
        }

        for (VerifyRegisteredSIMInformation sim : simList) {

            if (sim.getNidNumber().equals(nid)) {

                mobileNumberComboBox1.getItems().add(
                        sim.getMobileNumber()
                );
            }
        }

        if (mobileNumberComboBox1.getItems().isEmpty()) {
            outputLabel.setText("No SIM information found.");
        } else {
            outputLabel.setText("SIM information found.");
        }
    }
    int reportCount = 0;

    @FXML
    public void SubmitReportOnAction(ActionEvent actionEvent) {

        String mobileNumber = mobileNumberComboBox1.getValue();

        String reportReason = reportReasonTextArea.getText();

        if (mobileNumber == null) {
            outputLabel.setText("Please select a mobile number.");
            return;
        }

        if (reportReason.isEmpty()) {
            outputLabel.setText("Please enter report reason.");
            return;
        }

        reportCount++;

        String reportId = "SIM-RPT-" + reportCount;

        for (VerifyRegisteredSIMInformation sim : simList) {

            if (sim.getMobileNumber().equals(mobileNumber)) {

                sim.setReportId(reportId);

                sim.setReportReason(reportReason);

                sim.setReportStatus("Submitted");

                operatorNameTextField.setText(sim.getOperatorName());

                reportIdTextField.setText(reportId);

                reportStatusTextField.setText("Submitted");
            }
        }

        outputLabel.setText("Report Submitted Successfully!");

        reportReasonTextArea.clear();
    }

}
