package operations;

import models.ReportedProduct;

public interface ReportedProductOperations {
    String addReport(int consumerPortId, int productId, String issueType, String solution, java.util.Date reportDate, String token);
}