package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.time.LocalDate;

public class SubmitNetworkExpansionNotification {
    private String expansionArea;
    private String expansionType;
    private Integer numberOfNewTowers;
    private LocalDate expectedStartingDate;
    private String expansionDescription;
    private String notificationId;
    private String notificationStatus;

    public SubmitNetworkExpansionNotification(String expansionArea, String expansionType, Integer numberOfNewTowers, LocalDate expectedStartingDate, String expansionDescription, String notificationId, String notificationStatus) {
        this.expansionArea = expansionArea;
        this.expansionType = expansionType;
        this.numberOfNewTowers = numberOfNewTowers;
        this.expectedStartingDate = expectedStartingDate;
        this.expansionDescription = expansionDescription;
        this.notificationId = notificationId;
        this.notificationStatus = notificationStatus;
    }

    public String getExpansionArea() {
        return expansionArea;
    }

    public void setExpansionArea(String expansionArea) {
        this.expansionArea = expansionArea;
    }

    public String getExpansionType() {
        return expansionType;
    }

    public void setExpansionType(String expansionType) {
        this.expansionType = expansionType;
    }

    public Integer getNumberOfNewTowers() {
        return numberOfNewTowers;
    }

    public void setNumberOfNewTowers(Integer numberOfNewTowers) {
        this.numberOfNewTowers = numberOfNewTowers;
    }

    public LocalDate getExpectedStartingDate() {
        return expectedStartingDate;
    }

    public void setExpectedStartingDate(LocalDate expectedStartingDate) {
        this.expectedStartingDate = expectedStartingDate;
    }

    public String getExpansionDescription() {
        return expansionDescription;
    }

    public void setExpansionDescription(String expansionDescription) {
        this.expansionDescription = expansionDescription;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    @Override
    public String toString() {
        return "SubmitNetworkExpansionNotification{" +
                "expansionArea='" + expansionArea + '\'' +
                ", expansionType='" + expansionType + '\'' +
                ", numberOfNewTowers=" + numberOfNewTowers +
                ", expectedStartingDate=" + expectedStartingDate +
                ", expansionDescription='" + expansionDescription + '\'' +
                ", notificationId='" + notificationId + '\'' +
                ", notificationStatus='" + notificationStatus + '\'' +
                '}';
    }
}
