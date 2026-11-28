
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.BushraApplication;
import Farah_Bushra_2520877.CitizenServiceUser.AppendableObjectOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegulatoryFeePaymentRecordViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> feeTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker paymentDateDatePicker;
    @javafx.fxml.FXML
    private TextField amountPaidTextField;
    @javafx.fxml.FXML
    private TextField operatorNameTextField;
    @javafx.fxml.FXML
    private TextField transactionReferenceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TextArea remarksTextArea;
    @javafx.fxml.FXML
    private TableColumn<RegulatoryFeePaymentRecord, Integer> amountTableCol;
    @javafx.fxml.FXML
    private TableColumn<RegulatoryFeePaymentRecord, String> refferenceTableCol;
    @javafx.fxml.FXML
    private TableColumn<RegulatoryFeePaymentRecord, String> operatorTableCol;
    @javafx.fxml.FXML
    private TableColumn<RegulatoryFeePaymentRecord, String> methodTableCol;
    @javafx.fxml.FXML
    private TableView<RegulatoryFeePaymentRecord> tableView;
    @javafx.fxml.FXML
    private TableColumn<RegulatoryFeePaymentRecord, LocalDate> dateTableCOl;
    @javafx.fxml.FXML
    private TableColumn<RegulatoryFeePaymentRecord, String> feeTypeTableCol;
    @javafx.fxml.FXML
    private TableColumn<RegulatoryFeePaymentRecord, String> remarksTableCol;
    @javafx.fxml.FXML
    private TextField outputLabel;

    private ArrayList<RegulatoryFeePaymentRecord> paymentList;

    private boolean fileLoaded;

    @javafx.fxml.FXML
    public void initialize() {

        paymentList = new ArrayList<RegulatoryFeePaymentRecord>();

        feeTypeComboBox.getItems().addAll(
                "License Fee",
                "Spectrum Fee",
                "Renewal Fee",
                "Annual Regulatory Fee",
                "Other"
        );

        paymentMethodComboBox.getItems().addAll(
                "Bank Transfer",
                "Bank Deposit",
                "Cheque",
                "Online Payment"
        );

        operatorTableCol.setCellValueFactory(
                new PropertyValueFactory<>("operatorName"));

        feeTypeTableCol.setCellValueFactory(
                new PropertyValueFactory<>("feeType"));

        amountTableCol.setCellValueFactory(
                new PropertyValueFactory<>("amountPaid"));

        methodTableCol.setCellValueFactory(
                new PropertyValueFactory<>("paymentMethod"));

        refferenceTableCol.setCellValueFactory(
                new PropertyValueFactory<>("transactionReference"));

        dateTableCOl.setCellValueFactory(
                new PropertyValueFactory<>("paymentDate"));

        remarksTableCol.setCellValueFactory(
                new PropertyValueFactory<>("remarks"));

        outputLabel.setEditable(false);

        loadPaymentRecords();

        showPaymentRecords();
    }

    public void loadPaymentRecords() {

        paymentList.clear();

        File f = new File("RegulatoryFeePaymentRecord.bin");

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

                paymentList.add(
                        (RegulatoryFeePaymentRecord)
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

            outputLabel.setText("Unable to load previous payment records.");
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

    public void showPaymentRecords() {

        tableView.getItems().clear();

        for (RegulatoryFeePaymentRecord payment : paymentList) {

            tableView.getItems().add(payment);
        }
    }

    public boolean isDuplicateTransaction(String transactionReference) {

        for (RegulatoryFeePaymentRecord payment : paymentList) {

            if (payment.getTransactionReference().equals(transactionReference)) {

                return true;
            }
        }

        return false;
    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {

        operatorNameTextField.clear();
        feeTypeComboBox.setValue(null);
        amountPaidTextField.clear();
        paymentMethodComboBox.setValue(null);
        transactionReferenceTextField.clear();
        paymentDateDatePicker.setValue(null);
        remarksTextArea.clear();

        outputLabel.clear();
    }

    @javafx.fxml.FXML
    public void SubmitPaymentRecordOnAction(ActionEvent actionEvent) {

        String operatorName = operatorNameTextField.getText();
        String feeType = feeTypeComboBox.getValue();
        String amount = amountPaidTextField.getText();
        String paymentMethod = paymentMethodComboBox.getValue();
        String transactionReference = transactionReferenceTextField.getText();
        LocalDate paymentDate = paymentDateDatePicker.getValue();
        String remarks = remarksTextArea.getText();

        if (operatorName.isEmpty()
                || feeType == null
                || amount.isEmpty()
                || paymentMethod == null
                || transactionReference.isEmpty()
                || paymentDate == null
                || remarks.isEmpty()) {

            outputLabel.setText("Please complete all required information.");
            return;
        }

        int amountPaid;

        try {

            amountPaid = Integer.parseInt(amount);
        }
        catch (NumberFormatException e) {

            outputLabel.setText("Please enter a valid payment amount.");
            return;
        }

        if (amountPaid <= 0) {

            outputLabel.setText("Payment amount must be positive.");
            return;
        }

        if (LocalDate.now().isBefore(paymentDate)) {

            outputLabel.setText("Payment date cannot be in the future.");
            return;
        }

        if (!fileLoaded) {

            outputLabel.setText("Previous payment records could not be loaded.");
            return;
        }

        if (isDuplicateTransaction(transactionReference)) {

            outputLabel.setText("Transaction reference already exists.");
            return;
        }

        RegulatoryFeePaymentRecord payment =
                new RegulatoryFeePaymentRecord(
                        operatorName,
                        feeType,
                        amountPaid,
                        paymentMethod,
                        transactionReference,
                        paymentDate,
                        remarks
                );

        try {

            File f = new File("RegulatoryFeePaymentRecord.bin");

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

            oos.writeObject(payment);
            oos.close();

            paymentList.add(payment);

            showPaymentRecords();

            outputLabel.setText("Payment Record Submitted Successfully.");
        }
        catch (Exception e) {

            fileLoaded = false;

            outputLabel.setText("Payment Record Submission Failed.");
        }
    }

    @javafx.fxml.FXML
    public void BackToDashboardOnAction(ActionEvent actionEvent) {

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
