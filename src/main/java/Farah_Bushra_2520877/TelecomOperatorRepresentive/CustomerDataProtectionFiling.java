package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.time.LocalDate;

public class CustomerDataProtectionFiling {
    private String operatorName;
    private String filingType;
    private String dataCategory;
    private String processingPurpose;
    private String dataRetentionPeriod;
    private String protectionMeasure;
    private String dataProtectionOfficer;
    private String officerContactEmail;
    private LocalDate filingDate;
    private String protectionDetails;
    private String additionalRemarks;
    private boolean isDeclarationConfirmed;

    public CustomerDataProtectionFiling(String operatorName, String filingType, String dataCategory, String processingPurpose, String dataRetentionPeriod, String protectionMeasure, String dataProtectionOfficer, String officerContactEmail, LocalDate filingDate, String protectionDetails, String additionalRemarks, boolean isDeclarationConfirmed) {
        this.operatorName = operatorName;
        this.filingType = filingType;
        this.dataCategory = dataCategory;
        this.processingPurpose = processingPurpose;
        this.dataRetentionPeriod = dataRetentionPeriod;
        this.protectionMeasure = protectionMeasure;
        this.dataProtectionOfficer = dataProtectionOfficer;
        this.officerContactEmail = officerContactEmail;
        this.filingDate = filingDate;
        this.protectionDetails = protectionDetails;
        this.additionalRemarks = additionalRemarks;
        this.isDeclarationConfirmed = isDeclarationConfirmed;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getFilingType() {
        return filingType;
    }

    public void setFilingType(String filingType) {
        this.filingType = filingType;
    }

    public String getDataCategory() {
        return dataCategory;
    }

    public void setDataCategory(String dataCategory) {
        this.dataCategory = dataCategory;
    }

    public String getProcessingPurpose() {
        return processingPurpose;
    }

    public void setProcessingPurpose(String processingPurpose) {
        this.processingPurpose = processingPurpose;
    }

    public String getDataRetentionPeriod() {
        return dataRetentionPeriod;
    }

    public void setDataRetentionPeriod(String dataRetentionPeriod) {
        this.dataRetentionPeriod = dataRetentionPeriod;
    }

    public String getProtectionMeasure() {
        return protectionMeasure;
    }

    public void setProtectionMeasure(String protectionMeasure) {
        this.protectionMeasure = protectionMeasure;
    }

    public String getDataProtectionOfficer() {
        return dataProtectionOfficer;
    }

    public void setDataProtectionOfficer(String dataProtectionOfficer) {
        this.dataProtectionOfficer = dataProtectionOfficer;
    }

    public String getOfficerContactEmail() {
        return officerContactEmail;
    }

    public void setOfficerContactEmail(String officerContactEmail) {
        this.officerContactEmail = officerContactEmail;
    }

    public LocalDate getFilingDate() {
        return filingDate;
    }

    public void setFilingDate(LocalDate filingDate) {
        this.filingDate = filingDate;
    }

    public String getProtectionDetails() {
        return protectionDetails;
    }

    public void setProtectionDetails(String protectionDetails) {
        this.protectionDetails = protectionDetails;
    }

    public String getAdditionalRemarks() {
        return additionalRemarks;
    }

    public void setAdditionalRemarks(String additionalRemarks) {
        this.additionalRemarks = additionalRemarks;
    }

    public boolean isDeclarationConfirmed() {
        return isDeclarationConfirmed;
    }

    public void setDeclarationConfirmed(boolean declarationConfirmed) {
        isDeclarationConfirmed = declarationConfirmed;
    }

    @Override
    public String toString() {
        return "CustomerDataProtectionFiling{" +
                "operatorName='" + operatorName + '\'' +
                ", filingType='" + filingType + '\'' +
                ", dataCategory='" + dataCategory + '\'' +
                ", processingPurpose='" + processingPurpose + '\'' +
                ", dataRetentionPeriod='" + dataRetentionPeriod + '\'' +
                ", protectionMeasure='" + protectionMeasure + '\'' +
                ", dataProtectionOfficer='" + dataProtectionOfficer + '\'' +
                ", officerContactEmail='" + officerContactEmail + '\'' +
                ", filingDate=" + filingDate +
                ", protectionDetails='" + protectionDetails + '\'' +
                ", additionalRemarks='" + additionalRemarks + '\'' +
                ", isDeclarationConfirmed=" + isDeclarationConfirmed +
                '}';
    }
}
