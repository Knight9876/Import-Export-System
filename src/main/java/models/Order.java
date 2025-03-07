package models;

import java.util.Date;

public class Order {
    private int orderId;
    private int consumerPortId;
    private int productId;
    private int productQuantity;
    private Date orderDate;
    private boolean orderPlaced;
    private boolean shipped;
    private boolean outForDelivery;
    private boolean delivered;

    public Order(int orderId, int consumerPortId, int productId, int productQuantity, Date orderDate,
                 boolean orderPlaced, boolean shipped, boolean outForDelivery, boolean delivered) {
        this.orderId = orderId;
        this.consumerPortId = consumerPortId;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.orderDate = orderDate;
        this.orderPlaced = orderPlaced;
        this.shipped = shipped;
        this.outForDelivery = outForDelivery;
        this.delivered = delivered;
    }

    public int getOrderId() { return orderId; }
    public int getConsumerPortId() { return consumerPortId; }
    public int getProductId() { return productId; }
    public int getProductQuantity() { return productQuantity; }
    public Date getOrderDate() { return orderDate; }
    public boolean isOrderPlaced() { return orderPlaced; }
    public boolean isShipped() { return shipped; }
    public boolean isOutForDelivery() { return outForDelivery; }
    public boolean isDelivered() { return delivered; }
}
