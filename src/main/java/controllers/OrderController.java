package controllers;

import operationImplementors.OrderOperationsImpl;
import models.Order;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // For now, use a fixed consumer ID (for testing)
        int consumerPortId = 1; // Change this to any valid consumer ID

        OrderOperationsImpl orderOps = new OrderOperationsImpl();
        List<Order> orders = orderOps.getOrdersByConsumer(consumerPortId);

        request.setAttribute("orders", orders);
        request.getRequestDispatcher("consumerOrders.jsp").forward(request, response);
    }
    
    private OrderOperationsImpl orderOps = new OrderOperationsImpl();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        try {
            HttpSession session = request.getSession();
            Integer consumerPortId = null;

            // Retrieve portId from session and convert it to Integer
            try {
                String portIdStr = (String) session.getAttribute("portId");
                if (portIdStr != null) {
                    consumerPortId = Integer.parseInt(portIdStr);
                }
            } catch (NumberFormatException e) {
                // Handle the case where portId is not a valid integer
                e.printStackTrace();
                response.getWriter().write(gson.toJson(Map.of("success", false, "message", "Invalid portId in session")));
                return;
            }

            if (consumerPortId == null) {
                response.getWriter().write(gson.toJson(Map.of("success", false, "message", "User not logged in")));
                return;
            }

            // Parse the cart items from the request body
            List<Map<String, Object>> cartItems = gson.fromJson(request.getReader(), new TypeToken<List<Map<String, Object>>>() {}.getType());

            if (cartItems == null || cartItems.isEmpty()) {
                response.getWriter().write(gson.toJson(Map.of("success", false, "message", "Cart is empty")));
                return;
            }

            // Place the order
            boolean success = orderOps.placeOrder(consumerPortId, cartItems);

            if (success) {
                response.getWriter().write(gson.toJson(Map.of("success", true, "message", "Order placed successfully")));
            } else {
                response.getWriter().write(gson.toJson(Map.of("success", false, "message", "Failed to place order")));
            }
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();

            // Return a JSON response with the error message
            response.getWriter().write(gson.toJson(Map.of("success", false, "message", "An error occurred: " + e.getMessage())));
        }
    }
}
