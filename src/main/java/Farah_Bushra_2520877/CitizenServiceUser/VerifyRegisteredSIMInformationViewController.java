
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class VerifyRegisteredSIMInformationViewController {
    @FXML
    private TextField reportIdTextField;
    @FXML
    private Label outputLabel;
    @FXML
    private TextField nidNumberTextField;
    @FXML
    private TextField reportStatusTextField;
    @FXML
    private TextArea reportReasonTextArea;
    @FXML
    private ComboBox<String> mobileNumberComboBox1;
    @FXML
    private TextField operatorNameTextField;

    private ArrayList<VerifyRegisteredSIMInformation> simList = new ArrayList<>();
    private ArrayList<VerifyRegisteredSIMInformation> reportList = new ArrayList<>();

    private String checkedNid;

    @FXML
    public void initialize() {
         mobileNumberComboBox1.getItems().addAll("01712345678","01812345678");

        simList.add(new VerifyRegisteredSIMInformation(
                "1234567890123", "01712345678",
                "Grameenphone", "", "", "Not Reported"
        ));

        simList.add(new VerifyRegisteredSIMInformation(
                "1234567890123", "01812345678",
                "Robi", "", "", "Not Reported"
        ));


    }

    @FXML
    public void CheckSIMOnAction(ActionEvent actionEvent) {

        checkedNid = null;

        mobileNumberComboBox1.getItems().clear();
        operatorNameTextField.clear();
        reportIdTextField.clear();
        reportStatusTextField.clear();
        reportReasonTextArea.clear();

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
            checkedNid = nid;
            outputLabel.setText("SIM information found.");
        }
    }



    @FXML
    public void SubmitReportOnAction(ActionEvent actionEvent) {

        String nid = nidNumberTextField.getText();
        String mobileNumber = mobileNumberComboBox1.getValue();
        String reportReason = reportReasonTextArea.getText();

        if (!nid.equals(checkedNid)) {
            outputLabel.setText("Please check SIM information first.");
            return;
        }

        if (mobileNumber == null) {
            outputLabel.setText("Please select a mobile number.");
            return;
        }

        if (reportReason.isEmpty()) {
            outputLabel.setText("Please enter report reason.");
            return;
        }

        for (VerifyRegisteredSIMInformation sim : simList) {

            if (sim.getNidNumber().equals(nid)
                    && sim.getMobileNumber().equals(mobileNumber)) {

                String reportId = Integer.toString(reportList.size() + 1);

                VerifyRegisteredSIMInformation report =
                        new VerifyRegisteredSIMInformation(
                                nid,
                                mobileNumber,
                                sim.getOperatorName(),
                                reportId,
                                reportReason,
                                "Submitted"
                        );

                try {
                    File f = new File("SIMReport.bin");

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

                    oos.writeObject(report);
                    oos.close();

                    reportList.add(report);

                    operatorNameTextField.setText(sim.getOperatorName());
                    reportIdTextField.setText(reportId);
                    reportStatusTextField.setText("Submitted");

                    outputLabel.setText("Report Submitted Successfully");
                    reportReasonTextArea.clear();
                }
                catch (Exception e) {
                    outputLabel.setText("Report Submission Failed");
                }

                return;
            }
        }

        outputLabel.setText("SIM information not found.");
    }



    @FXML
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
