
package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class RegulatorySubmission implements Serializable {

    private String operatorName;
    private LocalDate submissionDate;

    public RegulatorySubmission(String operatorName, LocalDate submissionDate) {
        this.operatorName = operatorName;
        this.submissionDate = submissionDate;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public abstract String getReportType();
}
