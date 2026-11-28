
package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;


import Farah_Bushra_2520877.BushraApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TextField operatorNameTextField;
    @FXML
    private ComboBox<String> mobileNumberComboBox;
    @FXML
    private TableView<VerifyRegisteredSIMInformation> tableViewSim;
    @FXML
    private TableColumn<VerifyRegisteredSIMInformation, String> mobileNoTableCol;
    @FXML
    private TableColumn<VerifyRegisteredSIMInformation, String> operatorNameTableCol;
    @FXML
    private TableColumn<VerifyRegisteredSIMInformation, String> reportStatusTableCol;

    private ArrayList<VerifyRegisteredSIMInformation> simList = new ArrayList<>();
    private ArrayList<VerifyRegisteredSIMInformation> reportList = new ArrayList<>();

    private String checkedNid;

    @FXML
    public void initialize() {
        mobileNumberComboBox.getItems().addAll("01712345678","01812345678");

        mobileNoTableCol.setCellValueFactory(
                new PropertyValueFactory<>("mobileNumber"));

        operatorNameTableCol.setCellValueFactory(
                new PropertyValueFactory<>("operatorName"));

        reportStatusTableCol.setCellValueFactory(
                new PropertyValueFactory<>("reportStatus"));

        simList.add(new VerifyRegisteredSIMInformation(
                "1234567890123",
                "01712345678",
                "Grameenphone",
                "",
                "",
                "Not Reported"
        ));

        simList.add(new VerifyRegisteredSIMInformation(
                "1234567890123",
                "01812345678",
                "Robi",
                "",
                "",
                "Not Reported"
        ));

        loadReports();
    }

    public void loadReports() {

        File f = new File("SIMReport.bin");

        if (!f.exists()) {
            return;
        }

        reportList.clear();

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                while (true) {

                    VerifyRegisteredSIMInformation report =
                            (VerifyRegisteredSIMInformation) ois.readObject();

                    reportList.add(report);
                }
            }
            catch (EOFException e) {
                // End of file
            }
            finally {
                ois.close();
            }

            for (VerifyRegisteredSIMInformation report : reportList) {

                for (VerifyRegisteredSIMInformation sim : simList) {

                    if (sim.getNidNumber().equals(report.getNidNumber())
                            && sim.getMobileNumber().equals(report.getMobileNumber())) {

                        sim.setReportStatus(report.getReportStatus());
                    }
                }
            }
        }
        catch (Exception e) {
            outputLabel.setText("Unable to load saved reports.");
        }
    }

    @FXML
    public void CheckSIMOnAction(ActionEvent actionEvent) {

        checkedNid = null;

        tableViewSim.getItems().clear();
        mobileNumberComboBox.getItems().clear();

        operatorNameTextField.clear();
        reportIdTextField.clear();
        reportStatusTextField.clear();
        reportReasonTextArea.clear();

        String nid = nidNumberTextField.getText();

        if (nid.isEmpty()) {
            outputLabel.setText("Please enter NID number.");
            return;
        }

        if (nid.length() != 10
                && nid.length() != 13
                && nid.length() != 17) {

            outputLabel.setText("NID must contain 10, 13 or 17 digits.");
            return;
        }

        for (int i = 0; i < nid.length(); i++) {

            if (!Character.isDigit(nid.charAt(i))) {
                outputLabel.setText("NID must contain digits only.");
                return;
            }
        }

        for (VerifyRegisteredSIMInformation sim : simList) {

            if (sim.getNidNumber().equals(nid)) {

                mobileNumberComboBox.getItems().add(
                        sim.getMobileNumber()
                );

                tableViewSim.getItems().add(sim);
            }
        }

        if (tableViewSim.getItems().isEmpty()) {

            outputLabel.setText("No SIM information found.");
        }
        else {
            checkedNid = nid;
            outputLabel.setText("SIM information found.");
        }
    }

    @FXML
    public void SubmitReportOnAction(ActionEvent actionEvent) {

        String nid = nidNumberTextField.getText();
        String mobileNumber = mobileNumberComboBox.getValue();
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

                String reportId =
                        Integer.toString(reportList.size() + 1);

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

                    if (f.exists() && f.length() > 0) {

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

                    sim.setReportStatus("Submitted");

                    tableViewSim.refresh();

                    operatorNameTextField.setText(
                            sim.getOperatorName());

                    reportIdTextField.setText(reportId);

                    reportStatusTextField.setText("Submitted");

                    outputLabel.setText(
                            "Report Submitted Successfully");

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

            Stage currentStage =
                    (Stage)((Node) actionEvent.getSource())
                            .getScene().getWindow();

            currentStage.setScene(nextScene);

            currentStage.setTitle("Citizen Service User Dashboard");

            currentStage.show();
        }
        catch (Exception e) {

            outputLabel.setText("Unable to open dashboard.");
        }
    }
}