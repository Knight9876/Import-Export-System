package controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import operationImplementors.OrderOperationsImpl;


@WebServlet("/SellerOrderUpdateController")
public class SellerOrderUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the form
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        boolean orderPlaced = Boolean.parseBoolean(request.getParameter("orderPlaced"));
        boolean shipped = Boolean.parseBoolean(request.getParameter("shipped"));
        boolean outForDelivery = Boolean.parseBoolean(request.getParameter("outForDelivery"));
        boolean delivered = Boolean.parseBoolean(request.getParameter("delivered"));
        
        OrderOperationsImpl orderImpl = new OrderOperationsImpl();
        boolean updated = orderImpl.updateOrderStatus(orderId, productId, orderPlaced, shipped, outForDelivery, delivered);
        if (updated) {
            response.sendRedirect("sellerOrderUpdate.jsp?message=Order updated successfully");
        } else {
            response.sendRedirect("sellerOrderUpdate.jsp?error=Update failed");
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("sellerOrderUpdate.jsp");
        rd.forward(request, response);
    }
}
