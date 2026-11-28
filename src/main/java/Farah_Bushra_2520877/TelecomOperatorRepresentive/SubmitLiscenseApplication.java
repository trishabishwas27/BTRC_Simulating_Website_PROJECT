package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.io.Serializable;
import java.time.LocalDate;

public class SubmitLiscenseApplication implements Serializable {
    private String companyName;
    private String registrationNumber;
    private String contactInformation;
    private String licenseType;
    private String reasonForApplying;
    private LocalDate applicationDate;
    private String applicationId;
    private String applicationStatus;

    public SubmitLiscenseApplication(String companyName, String registrationNumber, String contactInformation, String licenseType, String reasonForApplying, LocalDate applicationDate, String applicationId, String applicationStatus) {
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.contactInformation = contactInformation;
        this.licenseType = licenseType;
        this.reasonForApplying = reasonForApplying;
        this.applicationDate = applicationDate;
        this.applicationId = applicationId;
        this.applicationStatus = applicationStatus;
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

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public String getReasonForApplying() {
        return reasonForApplying;
    }

    public void setReasonForApplying(String reasonForApplying) {
        this.reasonForApplying = reasonForApplying;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "SubmitLiscenseApplication{" +
                "companyName='" + companyName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", licenseType='" + licenseType + '\'' +
                ", reasonForApplying='" + reasonForApplying + '\'' +
                ", applicationDate=" + applicationDate +
                ", applicationId='" + applicationId + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}
