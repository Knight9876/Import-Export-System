package controllers;

import operationImplementors.SellerOrderOperationsImpl;
import models.SellerOrder;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SellerOrdersController")
public class SellerOrdersController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        Integer sellerId = null;
        try {
            // Retrieve portId from session and convert it to Integer
            String portIdStr = (String) session.getAttribute("portId");
            if (portIdStr != null) {
                sellerId = Integer.parseInt(portIdStr);
                SellerOrderOperationsImpl orderOps = new SellerOrderOperationsImpl();
            	List<SellerOrder> sellerOrders = orderOps.getOrdersBySellerId(sellerId);
            	
            	request.setAttribute("sellerOrders", sellerOrders);
            	request.getRequestDispatcher("sellerOrders.jsp").forward(request, response);
            }
            else if(portIdStr == null) {
            	response.sendRedirect("login.jsp");
            }
        } catch (NumberFormatException e) {
            // Handle the case where portId is not a valid integer
            e.printStackTrace();
            return;
        }

        
      
    }
}
