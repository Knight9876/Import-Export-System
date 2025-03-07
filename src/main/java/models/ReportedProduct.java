package models;

import java.util.Date;

public class ReportedProduct {
    private int reportId;
    private int consumerPortId;
    private int productId;
    private String issueType;
    private String solution;
    private Date reportDate;
    private String token;
    private String status;

    // Constructor
    public ReportedProduct(int consumerPortId, int productId, String issueType, String solution, Date reportDate, String token, String status) {
        this.consumerPortId = consumerPortId;
        this.productId = productId;
        this.issueType = issueType;
        this.solution = solution;
        this.reportDate = reportDate;
        this.token = token;
        this.status = status;
    }

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getConsumerPortId() {
        return consumerPortId;
    }

    public void setConsumerPortId(int consumerPortId) {
        this.consumerPortId = consumerPortId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReportedProduct{" +
                "reportId=" + reportId +
                ", consumerPortId=" + consumerPortId +
                ", productId=" + productId +
                ", issueType='" + issueType + '\'' +
                ", solution='" + solution + '\'' +
                ", reportDate=" + reportDate +
                ", token='" + token + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}