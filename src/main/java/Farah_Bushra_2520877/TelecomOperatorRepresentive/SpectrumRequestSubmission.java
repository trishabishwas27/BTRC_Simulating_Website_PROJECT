package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import Farah_Bushra_2520877.CitizenServiceUser.LicenseInformationInquiry;

import java.io.Serializable;
import java.time.LocalDate;

public class SpectrumRequestSubmission implements Serializable {

    private String operatorName;
    private String licenseNumber;
    private String frequencyBand;
    private String requestedBandwidth;
    private String coverageArea;
    private LocalDate requestDate;
    private String purpose;

    private LicenseInformationInquiry license;

    public SpectrumRequestSubmission(String operatorName,
                                     String licenseNumber,
                                     String frequencyBand,
                                     String requestedBandwidth,
                                     String coverageArea,
                                     LocalDate requestDate,
                                     String purpose) {

        this.operatorName = operatorName;
        this.licenseNumber = licenseNumber;
        this.frequencyBand = frequencyBand;
        this.requestedBandwidth = requestedBandwidth;
        this.coverageArea = coverageArea;
        this.requestDate = requestDate;
        this.purpose = purpose;
    }

    public LicenseInformationInquiry getLicense() {
        return license;
    }

    public void setLicense(LicenseInformationInquiry license) {

        this.license = license;

        if (license != null) {
            this.licenseNumber = license.getLicenseNo();
            this.operatorName = license.getCompanyName();
        }
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getFrequencyBand() {
        return frequencyBand;
    }

    public void setFrequencyBand(String frequencyBand) {
        this.frequencyBand = frequencyBand;
    }

    public String getRequestedBandwidth() {
        return requestedBandwidth;
    }

    public void setRequestedBandwidth(String requestedBandwidth) {
        this.requestedBandwidth = requestedBandwidth;
    }

    public String getCoverageArea() {
        return coverageArea;
    }

    public void setCoverageArea(String coverageArea) {
        this.coverageArea = coverageArea;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {

        return "SpectrumRequestSubmission{" +
                "operatorName='" + operatorName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", frequencyBand='" + frequencyBand + '\'' +
                ", requestedBandwidth='" + requestedBandwidth + '\'' +
                ", coverageArea='" + coverageArea + '\'' +
                ", requestDate=" + requestDate +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}