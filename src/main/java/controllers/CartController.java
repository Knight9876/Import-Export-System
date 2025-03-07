package controllers;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.GetConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer consumerId = (Integer) session.getAttribute("port_id");

		if (consumerId == null) {
			response.sendRedirect("login.jsp");
			return;
		}

		String action = request.getParameter("action");
		int productId = Integer.parseInt(request.getParameter("product_id"));

		try (Connection conn = GetConnection.getConnection()) {
			if ("add".equals(action)) {
				addToCart(conn, consumerId, productId, 1);
			} else if ("remove".equals(action)) {
				removeFromCart(conn, consumerId, productId);
			} else if ("increase".equals(action)) {
				updateQuantity(conn, consumerId, productId, 1);
			} else if ("decrease".equals(action)) {
				updateQuantity(conn, consumerId, productId, -1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("cart.jsp");
	}

	private void addToCart(Connection conn, int consumerId, int productId, int quantity) throws SQLException {
		try (CallableStatement stmt = conn.prepareCall("{CALL AddToCart(?, ?, ?)}")) {
			stmt.setInt(1, consumerId);
			stmt.setInt(2, productId);
			stmt.setInt(3, quantity);
			stmt.execute();
		}
	}

	private void removeFromCart(Connection conn, int consumerId, int productId) throws SQLException {
		try (CallableStatement stmt = conn.prepareCall("{CALL RemoveFromCart(?, ?)}")) {
			stmt.setInt(1, consumerId);
			stmt.setInt(2, productId);
			stmt.execute();
		}
	}

	private void updateQuantity(Connection conn, int consumerId, int productId, int change) throws SQLException {
		try (CallableStatement stmt = conn.prepareCall("{CALL ViewCartItems(?)}")) {
			stmt.setInt(1, consumerId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int cartProductId = rs.getInt("product_id");
				int currentQuantity = rs.getInt("quantity");

				if (cartProductId == productId) {
					if (currentQuantity + change > 0) {
						addToCart(conn, consumerId, productId, change);
					} else {
						removeFromCart(conn, consumerId, productId);
					}
					break;
				}
			}
		}
	}
}