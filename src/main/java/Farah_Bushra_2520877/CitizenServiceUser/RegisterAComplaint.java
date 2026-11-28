package Farah_Bushra_2520877.CitizenServiceUser;

import java.time.LocalDate;
import java.io.Serializable;

public class RegisterAComplaint implements Serializable {

    public static final int MOBILE_NUMBER_LENGTH = 11;
    public static final String MOBILE_PREFIX = "01";
    private String complaintId, operatorName, complaintType, complaintDetails, area;
    private LocalDate problemDate;
    private String mobileNumber;

    public RegisterAComplaint(String complaintId, String operatorName, String complaintType, String complaintDetails, String area, LocalDate problemDate, String mobileNumber) {
        this.complaintId = complaintId;
        this.operatorName = operatorName;
        this.complaintType = complaintType;
        this.complaintDetails = complaintDetails;
        this.area = area;
        this.problemDate = problemDate;
        this.mobileNumber = mobileNumber;
    }

    public String getComplaintId() {

        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getProblemDate() {
        return problemDate;
    }

    public void setProblemDate(LocalDate problemDate) {
        this.problemDate = problemDate;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "RegisterAComplaint{" +
                "complaintId='" + complaintId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", complaintType='" + complaintType + '\'' +
                ", complaintDetails='" + complaintDetails + '\'' +
                ", area='" + area + '\'' +
                ", problemDate=" + problemDate +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
