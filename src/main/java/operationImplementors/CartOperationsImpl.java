package operationImplementors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.GetConnection;



public class CartOperationsImpl {
	private Connection conn;

	public CartOperationsImpl() {
		conn = GetConnection.getConnection();
	}

	public void addToCart(int portId, int productId, int quantity) {
		try {
			// Check if the product is already in the cart
			String checkQuery = "SELECT quantity FROM cart WHERE port_id = ? AND product_id = ?";
			PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
			checkStmt.setInt(1, portId);
			checkStmt.setInt(2, productId);
			ResultSet rs = checkStmt.executeQuery();

			if (rs.next()) {
				// If product already exists, update quantity
				int existingQuantity = rs.getInt("quantity");
				String updateQuery = "UPDATE cart SET quantity = ? WHERE port_id = ? AND product_id = ?";
				PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
				updateStmt.setInt(1, existingQuantity + quantity);
				updateStmt.setInt(2, portId);
				updateStmt.setInt(3, productId);
				updateStmt.executeUpdate();
				updateStmt.close();
			} else {
				// If product doesn't exist, insert new record
				String insertQuery = "INSERT INTO cart (port_id, product_id, quantity) VALUES (?, ?, ?)";
				PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
				insertStmt.setInt(1, portId);
				insertStmt.setInt(2, productId);
				insertStmt.setInt(3, quantity);
				insertStmt.executeUpdate();
				insertStmt.close();
			}
			rs.close();
			checkStmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateQuantity(int portId, int productId, int change) {
		try {
			String query = "UPDATE cart SET quantity = quantity + ? WHERE port_id = ? AND product_id = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, change);
			stmt.setInt(2, portId);
			stmt.setInt(3, productId);
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeFromCart(int portId, int productId) {
		try {
			String query = "DELETE FROM cart WHERE port_id = ? AND product_id = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, portId);
			stmt.setInt(2, productId);
			stmt.executeUpdate();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}