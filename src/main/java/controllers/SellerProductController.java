package controllers;

import operationImplementors.SellerProductOperationsImpl;
import models.SellerProduct;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SellerProductController")
public class SellerProductController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int sellerId = (int) session.getAttribute("sellerId");

        SellerProductOperationsImpl productOps = new SellerProductOperationsImpl();
        List<SellerProduct> products = productOps.getSellerProducts(sellerId);

        request.setAttribute("products", products);
        request.getRequestDispatcher("manage_products.jsp").forward(request, response);
    }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        SellerProductOperationsImpl productOps = new SellerProductOperationsImpl();

        if ("add".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("product_id"));
            String name = request.getParameter("product_name");
            double price = Double.parseDouble(request.getParameter("product_price"));
            int quantity = Integer.parseInt(request.getParameter("product_quantity"));
            int sellerId = Integer.parseInt(request.getParameter("seller_id"));

            SellerProduct product = new SellerProduct(productId, name, price, quantity, sellerId);
            productOps.addProduct(product);
        } 
        else if ("update".equals(action)) {
            // Similar logic for updating a product
        } 
        else if ("delete".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("product_id"));
            int sellerId = Integer.parseInt(request.getParameter("seller_id"));
            productOps.deleteProduct(productId, sellerId);
        }

        response.sendRedirect("manage_products.jsp"); 
    }
}
