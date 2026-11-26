package Farah_Bushra_2520877.CitizenServiceUser;

import java.io.Serializable;

public class DeviceIMEIVerification implements Serializable {

    private String IMEINumber;
    private String deviceBrand;
    private String deviceModel;
    private String deviceStatus;
    private String verificationStatus;

    public DeviceIMEIVerification(String IMEINumber, String deviceBrand, String deviceModel, String deviceStatus, String verificationStatus) {
        this.IMEINumber = IMEINumber;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceStatus = deviceStatus;
        this.verificationStatus = verificationStatus;
    }

    public String getIMEINumber() {
        return IMEINumber;
    }

    public void setIMEINumber(String IMEINumber) {
        this.IMEINumber = IMEINumber;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    @Override
    public String toString() {
        return "DeviceIMEIVerification{" +
                "IMEINumber='" + IMEINumber + '\'' +
                ", deviceBrand='" + deviceBrand + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", verificationStatus='" + verificationStatus + '\'' +
                '}';
    }
}
