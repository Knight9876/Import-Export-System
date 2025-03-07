package operationImplementors;

import db.GetConnection;
import models.Order;
import operations.OrderOperations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderOperationsImpl implements OrderOperations {
    
    @Override
    public List<Order> getOrdersByConsumer(int consumerPortId) {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE consumer_port_id = ? ORDER BY order_date DESC";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, consumerPortId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                orders.add(new Order(
                        rs.getInt("order_id"),
                        rs.getInt("consumer_port_id"),
                        rs.getInt("product_id"),
                        rs.getInt("product_quantity"),
                        rs.getTimestamp("order_date"),
                        rs.getBoolean("order_placed"),
                        rs.getBoolean("shipped"),
                        rs.getBoolean("out_for_delivery"),
                        rs.getBoolean("delivered")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public boolean placeOrder(int consumerPortId, List<Map<String, Object>> cartItems) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        String insertOrderSQL = "INSERT INTO orders (order_id, consumer_port_id, product_id, product_quantity, order_date, order_placed, shipped, out_for_delivery, delivered) VALUES (?, ?, ?, ?, NOW(), ?, ?, ?, ?)";

        try {
            conn = GetConnection.getConnection();
            conn.setAutoCommit(false);  // Start transaction

            int orderId = generateOrderId(conn); // Generate unique order ID

            pstmt = conn.prepareStatement(insertOrderSQL);

            for (Map<String, Object> item : cartItems) {
                int productId = ((Double) item.get("id")).intValue();
                int quantity = ((Double) item.get("quantity")).intValue();

                pstmt.setInt(1, orderId);
                pstmt.setInt(2, consumerPortId);
                pstmt.setInt(3, productId);
                pstmt.setInt(4, quantity);
                pstmt.setBoolean(5, true);  // order_placed = true
                pstmt.setBoolean(6, false); // shipped = false
                pstmt.setBoolean(7, false); // out_for_delivery = false
                pstmt.setBoolean(8, false); // delivered = false
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();  // Commit transaction
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // Rollback on failure
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    // Method to generate a unique order ID
    private int generateOrderId(Connection conn) throws SQLException {
        String query = "SELECT COALESCE(MAX(order_id), 0) + 1 FROM orders";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            return rs.next() ? rs.getInt(1) : 1;
        }
    }
    
    @Override
    public boolean updateOrderStatus(int orderId, int productId, boolean orderPlaced, boolean shipped, boolean outForDelivery, boolean delivered) {
        String query = "UPDATE orders SET order_placed = ?, shipped = ?, out_for_delivery = ?, delivered = ? " +
                       "WHERE order_id = ? AND product_id = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setBoolean(1, orderPlaced);
            ps.setBoolean(2, shipped);
            ps.setBoolean(3, outForDelivery);
            ps.setBoolean(4, delivered);
            ps.setInt(5, orderId);
            ps.setInt(6, productId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
