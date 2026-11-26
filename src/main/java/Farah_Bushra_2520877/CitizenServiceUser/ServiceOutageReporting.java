package Farah_Bushra_2520877.CitizenServiceUser;

import java.io.Serializable;
import java.time.LocalDate;

public class ServiceOutageReporting implements Serializable {
    private String operatorName,serviceType, outageStartTime, location, outageDescription;
    private LocalDate outageStartDate;

    public ServiceOutageReporting(String operatorName, String serviceType, String outageStartTime, String location, String outageDescription, LocalDate outageStartDate) {
        this.operatorName = operatorName;
        this.serviceType = serviceType;
        this.outageStartTime = outageStartTime;
        this.location = location;
        this.outageDescription = outageDescription;
        this.outageStartDate = outageStartDate;
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

    public String getOutageStartTime() {
        return outageStartTime;
    }

    public void setOutageStartTime(String outageStartTime) {
        this.outageStartTime = outageStartTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOutageDescription() {
        return outageDescription;
    }

    public void setOutageDescription(String outageDescription) {
        this.outageDescription = outageDescription;
    }

    public LocalDate getOutageStartDate() {
        return outageStartDate;
    }

    public void setOutageStartDate(LocalDate outageStartDate) {
        this.outageStartDate = outageStartDate;
    }

    @Override
    public String toString() {
        return "ServiceOutageReporting{" +
                "operatorName='" + operatorName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", outageStartTime='" + outageStartTime + '\'' +
                ", location='" + location + '\'' +
                ", outageDescription='" + outageDescription + '\'' +
                ", outageStartDate=" + outageStartDate +
                '}';
    }
}
