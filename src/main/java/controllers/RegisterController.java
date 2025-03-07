package controllers;

import operationImplementors.UserOperationsImplRegister;
import models.UserRegister;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String portId = request.getParameter("portId");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        String role = request.getParameter("role");
        String location = request.getParameter("location");
        
     // Check if password and confirm password match
        if (!password.equals(confirmPassword)) {
            // Passwords do not match, redirect to register.jsp with an error message
            request.setAttribute("errorMessage", "Passwords do not match. Please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return; // Stop further execution
        }

        UserRegister user = new UserRegister(portId, password, role, location);
        UserOperationsImplRegister userOps = new UserOperationsImplRegister();
        
        boolean success = userOps.registerUser(user);
        
        if (success) {
            response.sendRedirect("login.jsp");
        } else {
        	response.sendRedirect("register.jsp");
        }
    }
}
