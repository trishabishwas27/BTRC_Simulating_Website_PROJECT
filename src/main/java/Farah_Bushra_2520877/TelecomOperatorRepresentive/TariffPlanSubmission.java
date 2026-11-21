package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.time.LocalDate;

public class TariffPlanSubmission {
    private String operatorName;
    private String tariffPlanName;
    private String serviceType;
    private String planCategory;
    private float voiceCallRate;
    private float smsRate;
    private float dataRate;
    private LocalDate effectiveDate;
    private String planDescription;

    public TariffPlanSubmission(String operatorName, String tariffPlanName, String serviceType, String planCategory, float voiceCallRate, float smsRate, float dataRate, LocalDate effectiveDate, String planDescription) {
        this.operatorName = operatorName;
        this.tariffPlanName = tariffPlanName;
        this.serviceType = serviceType;
        this.planCategory = planCategory;
        this.voiceCallRate = voiceCallRate;
        this.smsRate = smsRate;
        this.dataRate = dataRate;
        this.effectiveDate = effectiveDate;
        this.planDescription = planDescription;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getTariffPlanName() {
        return tariffPlanName;
    }

    public void setTariffPlanName(String tariffPlanName) {
        this.tariffPlanName = tariffPlanName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPlanCategory() {
        return planCategory;
    }

    public void setPlanCategory(String planCategory) {
        this.planCategory = planCategory;
    }

    public float getVoiceCallRate() {
        return voiceCallRate;
    }

    public void setVoiceCallRate(float voiceCallRate) {
        this.voiceCallRate = voiceCallRate;
    }

    public float getSmsRate() {
        return smsRate;
    }

    public void setSmsRate(float smsRate) {
        this.smsRate = smsRate;
    }

    public float getDataRate() {
        return dataRate;
    }

    public void setDataRate(float dataRate) {
        this.dataRate = dataRate;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public void setPlanDescription(String planDescription) {
        this.planDescription = planDescription;
    }

    @Override
    public String toString() {
        return "TariffPlanSubmission{" +
                "operatorName='" + operatorName + '\'' +
                ", tariffPlanName='" + tariffPlanName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", planCategory='" + planCategory + '\'' +
                ", voiceCallRate=" + voiceCallRate +
                ", smsRate=" + smsRate +
                ", dataRate=" + dataRate +
                ", effectiveDate=" + effectiveDate +
                ", planDescription='" + planDescription + '\'' +
                '}';
    }
}
