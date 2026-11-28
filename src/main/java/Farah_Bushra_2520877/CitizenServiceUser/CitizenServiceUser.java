package Farah_Bushra_2520877.CitizenServiceUser;

import Farah_Bushra_2520877.User;

public class CitizenServiceUser extends User {

    private String nidNumber;
    private String mobileNumber;

    public CitizenServiceUser(String userId,
                              String name,
                              String nidNumber,
                              String mobileNumber) {

        super(userId, name);
        this.nidNumber = nidNumber;
        this.mobileNumber = mobileNumber;
    }

    public String getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(String nidNumber) {
        this.nidNumber = nidNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String getUserType() {
        return "Citizen Service User";
    }
}