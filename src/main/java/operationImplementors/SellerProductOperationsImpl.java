package operationImplementors;

import db.GetConnection;
import models.SellerProduct;
import operations.SellerProductOperations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerProductOperationsImpl implements SellerProductOperations {

    @Override
    public boolean addProduct(SellerProduct product) {
        String query = "INSERT INTO product (product_id, product_name, product_price, product_quantity, seller_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setDouble(3, product.getProductPrice());
            stmt.setInt(4, product.getProductQuantity());
            stmt.setInt(5, product.getSellerId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(SellerProduct product) {
        String query = "UPDATE product SET product_name = ?, product_price = ?, product_quantity = ? WHERE product_id = ? AND seller_id = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getProductName());
            stmt.setDouble(2, product.getProductPrice());
            stmt.setInt(3, product.getProductQuantity());
            stmt.setInt(4, product.getProductId());
            stmt.setInt(5, product.getSellerId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int productId, int sellerId) {
        String query = "DELETE FROM product WHERE product_id = ? AND seller_id = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, productId);
            stmt.setInt(2, sellerId);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SellerProduct> getSellerProducts(int sellerId) {
        List<SellerProduct> products = new ArrayList<>();
        String query = "SELECT * FROM product WHERE seller_id = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sellerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                products.add(new SellerProduct(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("product_price"),
                        rs.getInt("product_quantity"),
                        rs.getInt("seller_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
