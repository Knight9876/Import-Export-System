package models;

public class OrderShipped {
	private int orderId;
	private String orderDate;
	private boolean orderPlaced;
	private boolean shipped;
	private boolean outForDelivery;
	private boolean delivered;
	private int consumerId;
	private int productId;
	private int quantity;

	// Constructor
	public OrderShipped(int orderId, String orderDate, boolean orderPlaced, boolean shipped, boolean outForDelivery,
			boolean delivered, int consumerId, int productId, int quantity) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderPlaced = orderPlaced;
		this.shipped = shipped;
		this.outForDelivery = outForDelivery;
		this.delivered = delivered;
		this.consumerId = consumerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	// Getters and Setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	public boolean isOutForDelivery() {
		return outForDelivery;
	}

	public void setOutForDelivery(boolean outForDelivery) {
		this.outForDelivery = outForDelivery;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
