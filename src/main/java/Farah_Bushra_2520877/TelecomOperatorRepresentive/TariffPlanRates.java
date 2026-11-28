package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.io.Serializable;

public final class TariffPlanRates implements Serializable {

    private float voiceCallRate;
    private float smsRate;
    private float dataRate;

    public TariffPlanRates(float voiceCallRate,
                           float smsRate,
                           float dataRate) {

        this.voiceCallRate = voiceCallRate;
        this.smsRate = smsRate;
        this.dataRate = dataRate;
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

    @Override
    public String toString() {
        return "TariffPlanRates{" +
                "voiceCallRate=" + voiceCallRate +
                ", smsRate=" + smsRate +
                ", dataRate=" + dataRate +
                '}';
    }
}