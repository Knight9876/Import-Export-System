package controllers;

import operationImplementors.SellerOperationsImpl;
import operationImplementors.SellerOperationsImplEdit;
import models.Seller;
import models.SellerEdit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/SellerUpdateDeleteController")
public class SellerUpdateDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        SellerOperationsImplEdit sellerOps = new SellerOperationsImplEdit();

        if ("update".equals(action)) {
            int portId = Integer.parseInt(request.getParameter("portId"));
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            String location = request.getParameter("location");

            SellerEdit seller = new SellerEdit(portId, password, role, location);
            boolean success = sellerOps.updateSeller(seller);

            if (success) {
                response.getWriter().write("Seller updated successfully.");
            } else {
                response.getWriter().write("Failed to update seller.");
            }

        } else if ("delete".equals(action)) {
            int portId = Integer.parseInt(request.getParameter("portId"));
            boolean success = sellerOps.deleteSeller(portId);

            if (success) {
                response.getWriter().write("Seller deleted successfully.");
            } else {
                response.getWriter().write("Failed to delete seller.");
            }
        }
    }
}
