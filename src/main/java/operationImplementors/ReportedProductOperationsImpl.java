package operationImplementors;

import models.ReportedProduct;
import operations.ReportOperations;
import operations.ReportedProductOperations;
import db.GetConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public class ReportedProductOperationsImpl implements ReportedProductOperations {

    @Override
    public String addReport(int consumerPortId, int productId, String issueType, String solution, Date reportDate, String token) {
        String generatedToken = null;
        try (Connection conn = GetConnection.getConnection()) {
            // Insert into reported_product table
            String query = "INSERT INTO reported_product (consumer_port_id, product_id, issue_type, solution, report_date, token, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, consumerPortId);
            stmt.setInt(2, productId);
            stmt.setString(3, issueType);
            stmt.setString(4, solution);
            stmt.setTimestamp(5, new Timestamp(reportDate.getTime()));
            stmt.setString(6, token);
            stmt.setString(7, "pending");

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                generatedToken = token;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedToken;
    }

    // Helper method to generate a random token
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
}