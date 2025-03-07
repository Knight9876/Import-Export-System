package operationImplementors;

import db.GetConnection;
import operations.OrderShipOperations;
import models.OrderShipped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderShipImpl implements OrderShipOperations {
    private Connection conn;

    public OrderShipImpl() throws SQLException {
        this.conn = GetConnection.getConnection();
    }

    @Override
    public List<OrderShipped> getShippedOrdersByConsumer(int consumerId) throws SQLException {
        List<OrderShipped> orders = new ArrayList<>();
        String query = "select * from orders where consumer_port_id = ?";
        

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, consumerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(new OrderShipped(
                        rs.getInt("order_id"),
                        rs.getString("order_date"),
                        rs.getBoolean("order_placed"),
                        rs.getBoolean("shipped"),
                        rs.getBoolean("out_for_delivery"),
                        rs.getBoolean("delivered"),
                        rs.getInt("consumer_port_id"),
                        rs.getInt("product_id"),
                        rs.getInt("product_quantity")
                ));
            }
        }
        return orders;
    }

    @Override
    public List<OrderShipped> getShippedOrdersBySeller(int sellerId) throws SQLException {
        List<OrderShipped> orders = new ArrayList<>();
        String query = "SELECT o.order_id, o.consumer_port_id, o.product_id, o.product_quantity, o.order_date, " +
                "o.order_placed, o.shipped, o.out_for_delivery, o.delivered, p.product_name " +
                "FROM orders o " +
                "JOIN product p ON o.product_id = p.product_id " +
                "WHERE p.seller_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                orders.add(new OrderShipped(
                        rs.getInt("order_id"),
                        rs.getString("order_date"),
                        rs.getBoolean("order_placed"),
                        rs.getBoolean("shipped"),
                        rs.getBoolean("out_for_delivery"),
                        rs.getBoolean("delivered"),
                        rs.getInt("consumer_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity")
                ));
            }
        }
        return orders;
    }

    @Override
    public boolean updateShipmentStatus(int orderId, String status) throws SQLException {
        String query = "update orders set delivery = ? where order_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
        	stmt.setString(1, status);
            stmt.setInt(2, orderId);
            return stmt.executeUpdate() > 0;
        }
    }
}
