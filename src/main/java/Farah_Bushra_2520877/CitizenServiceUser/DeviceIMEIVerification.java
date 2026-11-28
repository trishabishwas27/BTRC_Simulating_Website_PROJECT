package Farah_Bushra_2520877.CitizenServiceUser;

import java.io.Serializable;

public class DeviceIMEIVerification implements Serializable {

    private final String IMEINumber;
    private String deviceBrand;
    private String deviceModel;
    private String deviceStatus;
    private String verificationStatus;

    public static final int IMEI_LENGTH = 15;

    public DeviceIMEIVerification(String IMEINumber,
                                  String deviceBrand,
                                  String deviceModel,
                                  String deviceStatus,
                                  String verificationStatus) {
        this.IMEINumber = IMEINumber;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceStatus = deviceStatus;
        this.verificationStatus = verificationStatus;
    }

    public String getIMEINumber() {
        return IMEINumber;
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


    public static boolean isValidIMEI(String imei) {

        if (imei == null || imei.length() != IMEI_LENGTH) {
            return false;
        }

        for (int i = 0; i < imei.length(); i++) {

            if (imei.charAt(i) < '0' || imei.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }
}