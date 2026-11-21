package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.time.LocalDate;

public class RegulatorySelfReporting {
    private String operatorName;
    private String reportCategory;
    private String reportingPeriod;
    private LocalDate submissionDate;
    private String reportDetails;

    public RegulatorySelfReporting(String operatorName, String reportCategory, String reportingPeriod, LocalDate submissionDate, String reportDetails) {
        this.operatorName = operatorName;
        this.reportCategory = reportCategory;
        this.reportingPeriod = reportingPeriod;
        this.submissionDate = submissionDate;
        this.reportDetails = reportDetails;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(String reportCategory) {
        this.reportCategory = reportCategory;
    }

    public String getReportingPeriod() {
        return reportingPeriod;
    }

    public void setReportingPeriod(String reportingPeriod) {
        this.reportingPeriod = reportingPeriod;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }
}
