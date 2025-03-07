package operations;

import models.OrderShipped;
import java.sql.SQLException;
import java.util.List;

public interface OrderShipOperations {
    List<OrderShipped> getShippedOrdersByConsumer(int consumerId) throws SQLException;
    List<OrderShipped> getShippedOrdersBySeller(int sellerId) throws SQLException;
    boolean updateShipmentStatus(int orderId, String status) throws SQLException;
}
