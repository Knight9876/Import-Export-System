package models;

import java.util.Date;

public class Report {
    private int reportId;
    private int consumerPortId;
    private int productId;
    private String issueType;
    private String solution;
    private Date reportDate;
    private String token;
    private String status;

    public Report(int reportId, int consumerPortId, int productId, String issueType, String status, String solution) {
        this.reportId = reportId;
        this.consumerPortId = consumerPortId;
        this.productId = productId;
        this.solution = solution;
        this.issueType = issueType;
        this.status = status;
    }

    public int getReportId() {
        return reportId;
    }

    public int getConsumerPortId() {
        return consumerPortId;
    }

    public int getProductId() {
        return productId;
    }

    public String getSolution() {
        return solution;
    }

    public String getStatus() {
        return status;
    }

    public String getIssueType() {
        return issueType;
    }
}