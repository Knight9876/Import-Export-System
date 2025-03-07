package operationImplementors;

import db.GetConnection;
import models.Consumer;
import operations.ConsumerOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsumerOperationsImpl implements ConsumerOperations {
    @Override
    public Consumer getConsumerByPortId(String portId) {
    	 Consumer consumer = null;
        String query = "SELECT port_id, location FROM consumer_port WHERE port_id = ?";
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = GetConnection.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, portId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                consumer = new Consumer(
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
        return consumer;
    }
}