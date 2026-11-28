
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.time.LocalDate;

public class RegulatorySelfReporting extends RegulatorySubmission {

    private String reportCategory;
    private String reportingPeriod;
    private String reportDetails;

    public RegulatorySelfReporting(String operatorName, String reportCategory, String reportingPeriod, LocalDate submissionDate, String reportDetails) {

        super(operatorName, submissionDate);

        this.reportCategory = reportCategory;
        this.reportingPeriod = reportingPeriod;
        this.reportDetails = reportDetails;
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

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    @Override
    public String getReportType() {
        return "Regulatory Self-Reporting";
    }
}
