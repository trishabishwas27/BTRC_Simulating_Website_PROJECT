package Farah_Bushra_2520877.CitizenServiceUser;

public class VerifyRegisteredSIMInformation {
    private String nidNumber;
    private String mobileNumber;
    private String operatorName;
    private String reportId;
    private String reportReason;
    private String reportStatus;

    public VerifyRegisteredSIMInformation(String nidNumber, String mobileNumber, String operatorName, String reportId, String reportReason, String reportStatus) {
        this.nidNumber = nidNumber;
        this.mobileNumber = mobileNumber;
        this.operatorName = operatorName;
        this.reportId = reportId;
        this.reportReason = reportReason;
        this.reportStatus = reportStatus;
    }

    public String getNidNumber() {
        return nidNumber;
    }

    public void setNidNumber(String nidNumber) {
        this.nidNumber = nidNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportReason() {
        return reportReason;
    }

    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    @Override
    public String toString() {
        return "VerifyRegisteredSIMInformation{" +
                "nidNumber='" + nidNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", reportId='" + reportId + '\'' +
                ", reportReason='" + reportReason + '\'' +
                ", reportStatus='" + reportStatus + '\'' +
                '}';
    }
}
