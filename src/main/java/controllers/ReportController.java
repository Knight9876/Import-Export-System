package controllers;

import operationImplementors.ReportOperationsImpl;
import models.Report;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReportOperationsImpl reportOps = new ReportOperationsImpl();
        List<Report> reports = reportOps.viewReports();

        request.setAttribute("reports", reports);
        request.getRequestDispatcher("reports.jsp").forward(request, response);
    }
}
