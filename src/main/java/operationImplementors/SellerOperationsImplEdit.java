package operationImplementors;

import db.GetConnection;
import models.SellerEdit;
import operations.SellerOperationsEdit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SellerOperationsImplEdit implements SellerOperationsEdit {
    
    @Override
    public boolean updateSeller(SellerEdit seller) {
        String query = "UPDATE seller_port SET password = ?, role = ?, location = ? WHERE port_id = ?";
        
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, seller.getPassword());
            stmt.setString(2, seller.getRole());
            stmt.setString(3, seller.getLocation());
            stmt.setInt(4, seller.getPortId());

            int updatedRows = stmt.executeUpdate();
            return updatedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSeller(int portId) {
        String query = "DELETE FROM seller_port WHERE port_id = ?";
        
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, portId);
            int deletedRows = stmt.executeUpdate();
            return deletedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
