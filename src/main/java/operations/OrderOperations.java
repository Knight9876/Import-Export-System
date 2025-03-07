package operations;

import models.Order;
import java.util.List;
import java.util.Map;

public interface OrderOperations {
    List<Order> getOrdersByConsumer(int consumerPortId);
    boolean updateOrderStatus(int orderId, int productId, boolean orderPlaced, boolean shipped, boolean outForDelivery, boolean delivered);
    boolean placeOrder(int consumerPortId, List<Map<String, Object>> cartItems);
}
