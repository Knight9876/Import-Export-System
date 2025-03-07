package controllers;

import operationImplementors.UserOperationsImplConsumer;
import models.ConsumerUpdateDelete;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ConsumerController")
public class ConsumerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        UserOperationsImplConsumer userOps = new UserOperationsImplConsumer();

        if ("update".equals(action)) {
            String portId = request.getParameter("portId");
            String password = request.getParameter("password");
            String location = request.getParameter("location");

            // Passwords match, proceed with the update
            ConsumerUpdateDelete consumer = new ConsumerUpdateDelete(portId, password, location);
            boolean success = userOps.updateConsumer(consumer);

            if (success) {
                response.sendRedirect("consumerProfileEdit.jsp");
            } else {
                response.getWriter().write("Update failed. Please try again.");
            }
        } else if ("delete".equals(action)) {
            String portId = request.getParameter("portId");

            boolean success = userOps.deleteConsumer(portId);

            if (success) {
                response.getWriter().write("Consumer profile deleted successfully!");
            } else {
                response.getWriter().write("Deletion failed. Please try again.");
            }
        }
    }
}