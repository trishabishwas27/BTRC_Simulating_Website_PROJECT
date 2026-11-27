
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomerDataProtectionFiling extends RegulatorySubmission implements Serializable {

    private String filingType;
    private String dataCategory;
    private String processingPurpose;
    private String dataRetentionPeriod;
    private String protectionMeasure;
    private String dataProtectionOfficer;
    private String officerContactEmail;
    private String protectionDetails;
    private String additionalRemarks;
    private boolean isDeclarationConfirmed;

    public CustomerDataProtectionFiling(String operatorName,
                                        String filingType,
                                        String dataCategory,
                                        String processingPurpose,
                                        String dataRetentionPeriod,
                                        String protectionMeasure,
                                        String dataProtectionOfficer,
                                        String officerContactEmail,
                                        LocalDate filingDate,
                                        String protectionDetails,
                                        String additionalRemarks,
                                        boolean isDeclarationConfirmed) {

        super(operatorName, filingDate);

        this.filingType = filingType;
        this.dataCategory = dataCategory;
        this.processingPurpose = processingPurpose;
        this.dataRetentionPeriod = dataRetentionPeriod;
        this.protectionMeasure = protectionMeasure;
        this.dataProtectionOfficer = dataProtectionOfficer;
        this.officerContactEmail = officerContactEmail;
        this.protectionDetails = protectionDetails;
        this.additionalRemarks = additionalRemarks;
        this.isDeclarationConfirmed = isDeclarationConfirmed;
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
        return getSubmissionDate();
    }

    public void setFilingDate(LocalDate filingDate) {
        setSubmissionDate(filingDate);
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
    public String getReportType() {
        return "Customer Data Protection Filing";
    }

    @Override
    public String toString() {
        return "CustomerDataProtectionFiling{" +
                "operatorName='" + getOperatorName() + '\'' +
                ", filingType='" + filingType + '\'' +
                ", dataCategory='" + dataCategory + '\'' +
                ", processingPurpose='" + processingPurpose + '\'' +
                ", dataRetentionPeriod='" + dataRetentionPeriod + '\'' +
                ", protectionMeasure='" + protectionMeasure + '\'' +
                ", dataProtectionOfficer='" + dataProtectionOfficer + '\'' +
                ", officerContactEmail='" + officerContactEmail + '\'' +
                ", filingDate=" + getFilingDate() +
                ", protectionDetails='" + protectionDetails + '\'' +
                ", additionalRemarks='" + additionalRemarks + '\'' +
                ", isDeclarationConfirmed=" + isDeclarationConfirmed +
                '}';
    }
}
