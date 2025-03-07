package operationImplementors;

import db.GetConnection;
import models.SellerOrder;
import operations.SellerOrderOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerOrderOperationsImpl implements SellerOrderOperations {
    @Override
    public List<SellerOrder> getOrdersBySellerId(int sellerId) {
        List<SellerOrder> orders = new ArrayList<>();
        
        String query = "SELECT o.order_id, o.consumer_port_id, o.product_id, o.product_quantity, o.order_date, " +
                       "o.order_placed, o.shipped, o.out_for_delivery, o.delivered, p.product_name " +
                       "FROM orders o " +
                       "JOIN product p ON o.product_id = p.product_id " +
                       "WHERE p.seller_id = ?";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, sellerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                orders.add(new SellerOrder(
                    rs.getInt("order_id"),
                    rs.getInt("consumer_port_id"),
                    rs.getInt("product_id"),
                    rs.getInt("product_quantity"),
                    rs.getTimestamp("order_date"),
                    rs.getBoolean("order_placed"),
                    rs.getBoolean("shipped"),
                    rs.getBoolean("out_for_delivery"),
                    rs.getBoolean("delivered"),
                    rs.getString("product_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
