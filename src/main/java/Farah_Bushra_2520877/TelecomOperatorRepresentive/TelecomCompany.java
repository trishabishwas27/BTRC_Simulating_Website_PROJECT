package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.CitizenServiceUser.LicenseInformationInquiry;

import java.io.Serializable;
import java.util.ArrayList;

public class TelecomCompany implements Serializable {

    private final String registrationNumber;
    private String companyName;
    private String contactInformation;

    private ArrayList<LicenseInformationInquiry> licenseList;
    private ArrayList<TelecomOperatorRepresentive> representativeList;

    public TelecomCompany(String registrationNumber,
                          String companyName,
                          String contactInformation) {

        this.registrationNumber = registrationNumber;
        this.companyName = companyName;
        this.contactInformation = contactInformation;

        licenseList = new ArrayList<>();
        representativeList = new ArrayList<>();
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public ArrayList<LicenseInformationInquiry> getLicenseList() {
        return new ArrayList<>(licenseList);
    }

    public void addLicense(LicenseInformationInquiry license) {

        if (license != null
                && companyName.equals(license.getCompanyName())) {

            for (LicenseInformationInquiry l : licenseList) {

                if (l.getLicenseNo().equals(license.getLicenseNo())) {
                    return;
                }
            }

            licenseList.add(license);
        }
    }

    public ArrayList<TelecomOperatorRepresentive> getRepresentativeList() {
        return new ArrayList<>(representativeList);
    }

    public void addRepresentative(
            TelecomOperatorRepresentive representative) {

        if (representative != null
                && representative.getCompany() == this
                && !representativeList.contains(representative)) {

            representativeList.add(representative);
        }
    }

    public void removeRepresentative(
            TelecomOperatorRepresentive representative) {

        if (representative != null
                && representative.getCompany() != this) {

            representativeList.remove(representative);
        }
    }

    @Override
    public String toString() {
        return "TelecomCompany{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                '}';
    }
}