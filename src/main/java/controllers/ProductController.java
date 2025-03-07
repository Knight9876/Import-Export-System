package controllers;

import operationImplementors.ProductOperationsImpl;
import models.Product;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        ProductOperationsImpl productOps = new ProductOperationsImpl();
        List<Product> products = productOps.getAllProducts();

        request.setAttribute("products", products);
        request.getRequestDispatcher("displayProducts.jsp").forward(request, response);
    }
}
