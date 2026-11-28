package Farah_Bushra_2520877;

public class SignIn {
    private String userId , userType , passwordField;

    public SignIn(String userId, String userType, String passwordField) {
        this.userId = userId;
        this.userType = userType;
        this.passwordField = passwordField;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", passwordField='" + passwordField + '\'' +
                '}';
    }

}
