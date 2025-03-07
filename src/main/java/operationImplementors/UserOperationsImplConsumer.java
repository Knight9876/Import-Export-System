package operationImplementors;

import db.GetConnection;
import models.ConsumerUpdateDelete;
import operations.UserOperationsConsumer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserOperationsImplConsumer implements UserOperationsConsumer {

    @Override
    public boolean updateConsumer(ConsumerUpdateDelete consumer) {
        String updateQuery = "UPDATE consumer_port SET password = ?, location = ? WHERE port_id = ?";
        
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, consumer.getPassword());
            pstmt.setString(2, consumer.getLocation());
            pstmt.setString(3, consumer.getPortId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteConsumer(String portId) {
        String deleteQuery = "DELETE FROM consumer_port WHERE port_id = ?";
        
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            pstmt.setString(1, portId);

            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
