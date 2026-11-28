package Farah_Bushra_2520877.CitizenServiceUser;

import java.io.Serializable;

public class CitizenServiceUser implements Serializable {

    private final String citizenId;
    private String name;
    private String nidNumber;
    private String mobileNumber;

    public CitizenServiceUser(String citizenId, String name,
                              String nidNumber, String mobileNumber) {
        this.citizenId = citizenId;
        this.name = name;
        this.nidNumber = nidNumber;
        this.mobileNumber = mobileNumber;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String toString() {
        return "CitizenServiceUser{" +
                "citizenId='" + citizenId + '\'' +
                ", name='" + name + '\'' +
                ", nidNumber='" + nidNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
