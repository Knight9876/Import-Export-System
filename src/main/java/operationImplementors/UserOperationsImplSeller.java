package operationImplementors;

import db.GetConnection;
import models.ConsumerUpdateDelete;
import models.SellerUpdateDelete;
import operations.UserOperationsConsumer;
import operations.UserOperationsSeller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserOperationsImplSeller implements UserOperationsSeller {

    @Override
    public boolean updateSeller(SellerUpdateDelete seller) {
        String updateQuery = "UPDATE seller_port SET password = ?, location = ? WHERE port_id = ?";
        
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            pstmt.setString(1, seller.getPassword());
            pstmt.setString(2, seller.getLocation());
            pstmt.setString(3, seller.getPortId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSeller(String portId) {
        String deleteQuery = "DELETE FROM seller_port WHERE port_id = ?";
        
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
