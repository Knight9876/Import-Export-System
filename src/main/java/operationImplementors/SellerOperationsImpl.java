package operationImplementors;

import db.GetConnection;
import models.Seller;
import operations.SellerOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerOperationsImpl implements SellerOperations {
    @Override
    public Seller getSellerByPortId(String portId) {
        Seller seller = null;
        String query = "SELECT port_id, location FROM seller_port WHERE port_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = GetConnection.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, portId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                seller = new Seller(
                        rs.getString("port_id"),
                        rs.getString("location")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return seller;
    }
}
