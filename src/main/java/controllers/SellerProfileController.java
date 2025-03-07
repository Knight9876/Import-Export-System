package controllers;

import operationImplementors.SellerOperationsImpl;
import models.Seller;
import models.UserLogin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SellerProfileController")
public class SellerProfileController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserLogin user = (UserLogin) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if user session is null
            return;
        }

        if ("seller".equalsIgnoreCase(user.getRole())) {
            SellerOperationsImpl sellerOps = new SellerOperationsImpl();
            Seller seller = sellerOps.getSellerByPortId(user.getPortId());

            if (seller != null) {
                session.setAttribute("seller", seller); // Store seller object in session
                request.setAttribute("seller", seller);
                request.getRequestDispatcher("sellerProfile.jsp").forward(request, response);
            } else {
                response.getWriter().write("Seller details not found.");
            }
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if user is not a seller
        }
    }
}
