package Farah_Bushra_2520877.CitizenServiceUser;

import java.io.Serializable;

public class ServiceQualityInquiry implements Serializable {
    private String operatorName;
    private String serviceType;
    private String area;
    private String qualityStatus;
    private String serviceRemarks;

    public ServiceQualityInquiry(String operatorName, String serviceType, String area, String qualityStatus, String serviceRemarks) {
        this.operatorName = operatorName;
        this.serviceType = serviceType;
        this.area = area;
        this.qualityStatus = qualityStatus;
        this.serviceRemarks = serviceRemarks;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getQualityStatus() {
        return qualityStatus;
    }

    public void setQualityStatus(String qualityStatus) {
        this.qualityStatus = qualityStatus;
    }

    public String getServiceRemarks() {
        return serviceRemarks;
    }

    public void setServiceRemarks(String serviceRemarks) {
        this.serviceRemarks = serviceRemarks;
    }

    @Override
    public String toString() {
        return "ServiceQualityInquiry{" +
                "operatorName='" + operatorName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", area='" + area + '\'' +
                ", qualityStatus='" + qualityStatus + '\'' +
                ", serviceRemarks='" + serviceRemarks + '\'' +
                '}';
    }
}
