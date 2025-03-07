package controllers;

import operationImplementors.ConsumerOperationsImpl;
import models.Consumer;
import models.UserLogin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ConsumerProfileController")
public class ConsumerProfileController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserLogin user = (UserLogin) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp"); // Redirect to login if user session is null
            return;
        }

        if ("consumer".equalsIgnoreCase(user.getRole())) {
            ConsumerOperationsImpl consumerOps = new ConsumerOperationsImpl();
            Consumer consumer = consumerOps.getConsumerByPortId(user.getPortId());

            if (consumer != null) {
                session.setAttribute("consumer", consumer); // Store consumer object in session
                request.setAttribute("consumer", consumer);
                request.getRequestDispatcher("ConsumerProfile.jsp").forward(request, response);
            } else {
                response.getWriter().write("Consumer details not found.");
            }
        } else {
            response.sendRedirect("login.jsp"); // Redirect to login if user is not found
        }
    }
}
