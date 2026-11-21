package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.time.LocalDate;

public class SpectrumRequestSubmission {
    private String operatorName;
    private String licenseNumber;
    private String frequencyBand;
    private String requestedBandwidth;
    private String coverageArea;
    private LocalDate requestDate;
    private String purpose;

    public SpectrumRequestSubmission(String operatorName, String licenseNumber, String frequencyBand, String requestedBandwidth, String coverageArea, LocalDate requestDate, String purpose) {
        this.operatorName = operatorName;
        this.licenseNumber = licenseNumber;
        this.frequencyBand = frequencyBand;
        this.requestedBandwidth = requestedBandwidth;
        this.coverageArea = coverageArea;
        this.requestDate = requestDate;
        this.purpose = purpose;
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
