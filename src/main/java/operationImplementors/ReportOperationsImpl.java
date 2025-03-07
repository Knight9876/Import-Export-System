package operationImplementors;

import db.GetConnection;
import models.Report;
import operations.ReportOperations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportOperationsImpl implements ReportOperations {
    @Override
    public List<Report> viewReports() {
        List<Report> reports = new ArrayList<>();
        String query = "SELECT report_id, product_id, consumer_port_id, issue_type, solution, status FROM reported_product"; // Include report_id

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reports.add(new Report(
                        rs.getInt("report_id"), // Include report_id
                        rs.getInt("consumer_port_id"),
                        rs.getInt("product_id"),
                        rs.getString("issue_type"),
                        rs.getString("status"),
                        rs.getString("solution")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }
    
    public boolean updateReportStatus(int reportId, String status) {
        String query = "UPDATE reported_product SET status = ? WHERE report_id = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, reportId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}