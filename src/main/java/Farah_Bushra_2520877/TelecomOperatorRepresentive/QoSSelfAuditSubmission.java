
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.io.Serializable;
import java.time.LocalDate;

public class QoSSelfAuditSubmission extends RegulatorySubmission implements Serializable {

    private String serviceType;
    private String technology;
    private String auditArea;
    private LocalDate auditStartDate;
    private LocalDate auditEndDate;
    private float callSetupSuccessRate;
    private float callDropRate;
    private float averageDataSpeed;
    private float averageLatency;
    private String auditFindings;
    private String correctiveAction;

    public QoSSelfAuditSubmission(String operatorName, String serviceType,
                                  String technology, String auditArea,
                                  LocalDate auditStartDate, LocalDate auditEndDate,
                                  float callSetupSuccessRate, float callDropRate,
                                  float averageDataSpeed, float averageLatency,
                                  String auditFindings, String correctiveAction,
                                  LocalDate submissionDate) {

        super(operatorName, submissionDate);

        this.serviceType = serviceType;
        this.technology = technology;
        this.auditArea = auditArea;
        this.auditStartDate = auditStartDate;
        this.auditEndDate = auditEndDate;
        this.callSetupSuccessRate = callSetupSuccessRate;
        this.callDropRate = callDropRate;
        this.averageDataSpeed = averageDataSpeed;
        this.averageLatency = averageLatency;
        this.auditFindings = auditFindings;
        this.correctiveAction = correctiveAction;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getAuditArea() {
        return auditArea;
    }

    public void setAuditArea(String auditArea) {
        this.auditArea = auditArea;
    }

    public LocalDate getAuditStartDate() {
        return auditStartDate;
    }

    public void setAuditStartDate(LocalDate auditStartDate) {
        this.auditStartDate = auditStartDate;
    }

    public LocalDate getAuditEndDate() {
        return auditEndDate;
    }

    public void setAuditEndDate(LocalDate auditEndDate) {
        this.auditEndDate = auditEndDate;
    }

    public float getCallSetupSuccessRate() {
        return callSetupSuccessRate;
    }

    public void setCallSetupSuccessRate(float callSetupSuccessRate) {
        this.callSetupSuccessRate = callSetupSuccessRate;
    }

    public float getCallDropRate() {
        return callDropRate;
    }

    public void setCallDropRate(float callDropRate) {
        this.callDropRate = callDropRate;
    }

    public float getAverageDataSpeed() {
        return averageDataSpeed;
    }

    public void setAverageDataSpeed(float averageDataSpeed) {
        this.averageDataSpeed = averageDataSpeed;
    }

    public float getAverageLatency() {
        return averageLatency;
    }

    public void setAverageLatency(float averageLatency) {
        this.averageLatency = averageLatency;
    }

    public String getAuditFindings() {
        return auditFindings;
    }

    public void setAuditFindings(String auditFindings) {
        this.auditFindings = auditFindings;
    }

    public String getCorrectiveAction() {
        return correctiveAction;
    }

    public void setCorrectiveAction(String correctiveAction) {
        this.correctiveAction = correctiveAction;
    }

    @Override
    public String getReportType() {
        return "QoS Self-Audit";
    }

    @Override
    public String toString() {
        return "QoSSelfAuditSubmission{" +
                "operatorName='" + getOperatorName() + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", technology='" + technology + '\'' +
                ", auditArea='" + auditArea + '\'' +
                ", auditStartDate=" + auditStartDate +
                ", auditEndDate=" + auditEndDate +
                ", callSetupSuccessRate=" + callSetupSuccessRate +
                ", callDropRate=" + callDropRate +
                ", averageDataSpeed=" + averageDataSpeed +
                ", averageLatency=" + averageLatency +
                ", auditFindings='" + auditFindings + '\'' +
                ", correctiveAction='" + correctiveAction + '\'' +
                ", submissionDate=" + getSubmissionDate() +
                '}';
    }
}
