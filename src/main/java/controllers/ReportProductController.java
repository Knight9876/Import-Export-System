package controllers;

import operations.ReportOperations;
import operations.ReportedProductOperations;
import operationImplementors.ReportOperationsImpl;
import operationImplementors.ReportedProductOperationsImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/ReportProductController")
public class ReportProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReportedProductOperations operations;

    @Override
    public void init() {
        operations = new ReportedProductOperationsImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int consumerPortId = Integer.parseInt(request.getParameter("consumerPortId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        String issueType = request.getParameter("issueType");
        String solution = request.getParameter("solution");
        Date reportDate = new Date(); // Current date and time

        // Generate a random token
        String token = ((ReportedProductOperationsImpl) operations).generateToken();

        // Call the operation to add the report
        String generatedToken = operations.addReport(consumerPortId, productId, issueType, solution, reportDate, token);

        if (generatedToken != null) {
            request.setAttribute("message", "Report submitted successfully. Token: " + generatedToken);
        } else {
            request.setAttribute("message", "Failed to submit report.");
        }

        // Forward to a JSP page to display the result
        request.getRequestDispatcher("reportProduct.jsp").forward(request, response);
    }
}