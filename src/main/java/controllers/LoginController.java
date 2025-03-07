package controllers;

import operationImplementors.UserOperationsImplLogin;
import operationImplementors.UserOperationsImplRegister;
import models.UserLogin;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String portId = request.getParameter("portId");
        String password = request.getParameter("password");
        String role = request.getParameter("role"); // Added role verification

        UserOperationsImplLogin userOps = new UserOperationsImplLogin();
        UserLogin user = userOps.loginUser(portId, password, role);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // Store the full user object
            session.setAttribute("portId", user.getPortId());
            session.setAttribute("role", user.getRole());

            // If user is a seller, store sellerId in session
            if ("seller".equalsIgnoreCase(user.getRole())) {
                session.setAttribute("sellerId", Integer.parseInt(user.getPortId())); // Assuming portId is sellerId
            }

            if ("consumer".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("consumerDashboard.jsp");
            } else if ("seller".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("sellerDashboard.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
