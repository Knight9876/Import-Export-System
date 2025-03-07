package controllers;

import operationImplementors.OrderShipImpl;
import models.OrderShipped;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OrderShipServlet")
public class OrderShipController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int consumerId = Integer.parseInt(request.getParameter("consumer_port_id"));

        try {
            OrderShipImpl orderShipDAO = new OrderShipImpl();
            List<OrderShipped> orders = orderShipDAO.getShippedOrdersByConsumer(consumerId);
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("shipmentTracking.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        String status = request.getParameter("status");

        try {
            OrderShipImpl orderShipDAO = new OrderShipImpl();
            boolean success = orderShipDAO.updateShipmentStatus(orderId, status);
            response.sendRedirect("shipmentTracking.jsp?updated=" + success);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
