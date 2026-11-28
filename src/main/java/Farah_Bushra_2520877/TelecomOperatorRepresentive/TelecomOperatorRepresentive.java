package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.User;

public class TelecomOperatorRepresentive extends User {

    private String companyName;
    private String registrationNumber;

    public TelecomOperatorRepresentive(String userId,
                                       String name,
                                       String companyName,
                                       String registrationNumber) {

        super(userId, name);
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String getUserType() {
        return "Telecom Operator Representative";
    }
}
