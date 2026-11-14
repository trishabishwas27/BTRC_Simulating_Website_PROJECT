package Farah_Bushra_2520877;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class SignInViewController
{
    @javafx.fxml.FXML
    private PasswordField passPasswordField;
    @javafx.fxml.FXML
    private TextField outputLabel;
    @javafx.fxml.FXML
    private TextField userIdTextField;
    @javafx.fxml.FXML
    private TextField userTypeTextField;

    private ArrayList<SignIn>UserList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        SignIn citizen = new SignIn("Citizen123","Demo123","1@354user");
        UserList.add(citizen);
    }

    @javafx.fxml.FXML
    public void SignInOnAction(ActionEvent actionEvent) {
        String userId = userIdTextField.getText();
        String userType = userTypeTextField.getText();
        String password = passPasswordField.getText();

        if (userId.isEmpty() || userType.isEmpty() || password.isEmpty()){
            outputLabel.setText("Fill the ID , type , password");
            return;
        }
        for (SignIn user : UserList){
            if (userId.equals(user.getUserId()) && userType.equals(user.getUserType())
                    && password.equals(user.getPasswordField()));
            outputLabel.setText("Sign in successful");
            return;

        }
    }
}