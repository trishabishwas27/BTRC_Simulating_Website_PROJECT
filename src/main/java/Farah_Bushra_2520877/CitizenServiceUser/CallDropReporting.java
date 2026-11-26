package Farah_Bushra_2520877.CitizenServiceUser;

import java.io.Serializable;
import java.time.LocalDate;

public class CallDropReporting implements Serializable {
    private String operatorName,mobileNumber,callDropTime,Location,remarks;
    private LocalDate callDropDate;

    public CallDropReporting(String operatorName, String mobileNumber, String callDropTime, String location, String remarks, LocalDate callDropDate) {
        this.operatorName = operatorName;
        this.mobileNumber = mobileNumber;
        this.callDropTime = callDropTime;
        Location = location;
        this.remarks = remarks;
        this.callDropDate = callDropDate;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCallDropTime() {
        return callDropTime;
    }

    public void setCallDropTime(String callDropTime) {
        this.callDropTime = callDropTime;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getCallDropDate() {
        return callDropDate;
    }

    public void setCallDropDate(LocalDate callDropDate) {
        this.callDropDate = callDropDate;
    }

    @Override
    public String toString() {
        return "CallDropReporting{" +
                "operatorName='" + operatorName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", callDropTime='" + callDropTime + '\'' +
                ", Location='" + Location + '\'' +
                ", remarks='" + remarks + '\'' +
                ", callDropDate=" + callDropDate +
                '}';
    }
}
