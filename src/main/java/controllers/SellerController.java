package controllers;

import operationImplementors.UserOperationsImplSeller;
import models.SellerUpdateDelete;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        UserOperationsImplSeller userOps = new UserOperationsImplSeller();

        if ("update".equals(action)) {
            String portId = request.getParameter("portId");
            String password = request.getParameter("password");
            String location = request.getParameter("location");

            SellerUpdateDelete consumer = new SellerUpdateDelete(portId, password, location);
            boolean success = userOps.updateSeller(consumer);

            if (success) {
                response.sendRedirect("sellerProfile.jsp");
            } else {
                response.getWriter().write("Update failed. Please try again.");
            }
        } else if ("delete".equals(action)) {
            String portId = request.getParameter("portId");

            boolean success = userOps.deleteSeller(portId);

            if (success) {
                response.getWriter().write("Seller profile deleted successfully!");
            } else {
                response.getWriter().write("Deletion failed. Please try again.");
            }
        }
    }
}
