package operationImplementors;

import models.UserLogin;
import operations.UserOperationsLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.GetConnection;

public class UserOperationsImplLogin implements UserOperationsLogin {
    @Override
    public UserLogin loginUser(String portId, String password, String role) {
        String query = "";

        // Determine the table based on the role
        if ("consumer".equalsIgnoreCase(role)) {
            query = "SELECT * FROM consumer_port WHERE port_id = ? AND password = ?";
        } else if ("seller".equalsIgnoreCase(role)) {
            query = "SELECT * FROM seller_port WHERE port_id = ? AND password = ?";
        } else {
            System.out.println("Invalid role specified.");
            return null;
        }

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, portId);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new UserLogin(
                        rs.getString("port_id"),
                        rs.getString("password"),
                        role, // We already know the role
                        rs.getString("location")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
