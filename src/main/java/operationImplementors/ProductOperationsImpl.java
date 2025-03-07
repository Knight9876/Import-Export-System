package operationImplementors;

import db.GetConnection;
import models.Product;
import operations.ProductOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOperationsImpl implements ProductOperations {
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM product";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                productList.add(new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("product_price"),
                        rs.getInt("product_quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(productList);
        return productList;
    }
}
