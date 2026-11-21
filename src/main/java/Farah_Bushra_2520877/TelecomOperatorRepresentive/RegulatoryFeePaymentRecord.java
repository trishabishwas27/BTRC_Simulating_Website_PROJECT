package Farah_Bushra_2520877.TelecomOperatorRepresentive;

import java.time.LocalDate;

public class RegulatoryFeePaymentRecord {
    private String operatorName;
    private String feeType;
    private Integer amountPaid;
    private String paymentMethod;
    private String transactionReference;
    private LocalDate paymentDate;
    private String remarks;

    public RegulatoryFeePaymentRecord(String operatorName, String feeType, Integer amountPaid, String paymentMethod, String transactionReference, LocalDate paymentDate, String remarks) {
        this.operatorName = operatorName;
        this.feeType = feeType;
        this.amountPaid = amountPaid;
        this.paymentMethod = paymentMethod;
        this.transactionReference = transactionReference;
        this.paymentDate = paymentDate;
        this.remarks = remarks;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "RegulatoryFeePaymentRecord{" +
                "operatorName='" + operatorName + '\'' +
                ", feeType='" + feeType + '\'' +
                ", amountPaid=" + amountPaid +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", transactionReference='" + transactionReference + '\'' +
                ", paymentDate=" + paymentDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
