<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.OrderShipped" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shipment Tracking</title>
    <link rel="stylesheet" href="styles.css"> <!-- External CSS -->
    <script>
        function updateOrderStatus(orderId) {
            let status = document.getElementById("status-" + orderId).value;
            fetch("OrderShipServlet", {
                method: "POST",
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
                body: "orderId=" + orderId + "&status=" + status
            }).then(response => {
                if (response.ok) {
                    alert("Order status updated successfully!");
                    location.reload();
                } else {
                    alert("Failed to update order status.");
                }
            });
        }
    </script>
</head>
<body>
    <h2>Shipment Tracking</h2>

    <%
        List<OrderShipped> orders = (List<OrderShipped>) request.getAttribute("orders");
        if (orders != null && !orders.isEmpty()) {
    %>

    <table border="1">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Consumer ID</th>
                <th>Product ID</th>
                <th>Quantity</th>
                <th>Shipped</th>
                <th>Out for Delivery</th>
                <th>Delivered</th>
                <th>Update Status</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (OrderShipped order : orders) {
            %>
            <tr>
                <td><%= order.getOrderId() %></td>
                <td><%= order.getOrderDate() %></td>
                <td><%= order.getConsumerId() %></td>
                <td><%= order.getProductId() %></td>
                <td><%= order.getQuantity() %></td>
                <td><%= order.isShipped() ? "Yes" : "No" %></td>
                <td><%= order.isOutForDelivery() ? "Yes" : "No" %></td>
                <td><%= order.isDelivered() ? "Yes" : "No" %></td>
                <td>
                    <select id="status-<%= order.getOrderId() %>">
                        <option value="shipped">Shipped</option>
                        <option value="out_for_delivery">Out for Delivery</option>
                        <option value="delivered">Delivered</option>
                    </select>
                    <button onclick="updateOrderStatus(<%= order.getOrderId() %>)">Update</button>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

    <%
        } else {
    %>
        <p>No orders found.</p>
    <%
        }
    %>

</body>
</html>
