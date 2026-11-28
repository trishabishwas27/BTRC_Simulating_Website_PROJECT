package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.User;

public class TelecomOperatorRepresentive extends User {

    private String companyName;
    private String registrationNumber;
    private TelecomCompany company;

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
        if (company == null) {
            this.companyName = companyName;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (company == null) {
            this.registrationNumber = registrationNumber;
        }
    }

    public TelecomCompany getCompany() {
        return company;
    }

    public void setCompany(TelecomCompany company) {

        if (this.company == company) {
            return;
        }

        TelecomCompany oldCompany = this.company;

        this.company = company;

        if (oldCompany != null) {
            oldCompany.removeRepresentative(this);
        }

        if (company != null) {

            this.companyName = company.getCompanyName();

            this.registrationNumber =
                    company.getRegistrationNumber();

            company.addRepresentative(this);
        }
        else {
            this.companyName = null;
            this.registrationNumber = null;
        }
    }

    @Override
    public String getUserType() {
        return "Telecom Operator Representative";
    }

    @Override
    public String toString() {
        return "TelecomOperatorRepresentive{" +
                "companyName='" + companyName + '\'' +
                ", registrationNumber='" +
                registrationNumber + '\'' +
                '}';
    }
}