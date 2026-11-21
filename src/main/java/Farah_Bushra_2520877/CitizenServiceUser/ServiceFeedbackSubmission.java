package Farah_Bushra_2520877.CitizenServiceUser;

public class ServiceFeedbackSubmission {
    private String operatorName;
    private String serviceType;
    private String rating;
    private String feedbackComments;
    private String feedbackId;

    public ServiceFeedbackSubmission(String operatorName, String serviceType, String rating, String feedbackComments, String feedbackId) {
        this.operatorName = operatorName;
        this.serviceType = serviceType;
        this.rating = rating;
        this.feedbackComments = feedbackComments;
        this.feedbackId = feedbackId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getRating() {
        return rating;
    }

    public String getFeedbackComments() {
        return feedbackComments;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    @Override
    public String toString() {
        return "ServiceFeedbackSubmission{" +
                "operatorName='" + operatorName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", rating='" + rating + '\'' +
                ", feedbackComments='" + feedbackComments + '\'' +
                ", feedbackId='" + feedbackId + '\'' +
                '}';
    }
}
