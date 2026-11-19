package Farah_Bushra_2520877.CitizenServiceUser;

import java.time.LocalDate;

public class LicenseInformationInquiry {
    private String licenseNo;
    private String companyName;
    private String licenseType;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String licenseStatus;

    public LicenseInformationInquiry(String licenseNo, String companyName, String licenseType, LocalDate issueDate, LocalDate expiryDate, String licenseStatus) {
        this.licenseNo = licenseNo;
        this.companyName = companyName;
        this.licenseType = licenseType;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.licenseStatus = licenseStatus;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }
}
