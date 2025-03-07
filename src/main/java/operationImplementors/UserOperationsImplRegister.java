package operationImplementors;

import db.GetConnection;
import models.UserRegister;
import operations.UserOperationsRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserOperationsImplRegister implements UserOperationsRegister {
    @Override
    public boolean registerUser(UserRegister user) {
        String insertQuery;
        if (user.getRole().equalsIgnoreCase("consumer")) {
            insertQuery = "INSERT INTO consumer_port (port_id, password, role, location) VALUES (?, ?, ?, ?)";
        } else if (user.getRole().equalsIgnoreCase("seller")) {
            insertQuery = "INSERT INTO seller_port (port_id, password, role, location) VALUES (?, ?, ?, ?)";
        } else {
            return false; // Invalid role
        }

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setString(1, user.getPortId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, user.getLocation());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
