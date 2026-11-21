package Farah_Bushra_2520877.CitizenServiceUser;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class LicenseInformationInquiryViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> licenseStatusComboBox;
    @javafx.fxml.FXML
    private DatePicker expiredDateDatePicker;
    @javafx.fxml.FXML
    private TextField licenseNumberTextField;
    @javafx.fxml.FXML
    private ComboBox<String> licenseTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker issueDateDatePicker;
    @javafx.fxml.FXML
    private TextField companyNameTextField;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void ClearOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void SearchOnAction(ActionEvent actionEvent) {
    }
}