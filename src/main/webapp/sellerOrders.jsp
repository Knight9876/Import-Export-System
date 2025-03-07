<%@ page import="java.util.List" %>
<%@ page import="models.SellerOrder" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Profile</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Raleway:wght@300;400;600&display=swap"
      rel="stylesheet"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      defer
    ></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />

    <style>
      body {
        background: radial-gradient(circle, gray, #232323, black);
        font-family: "Raleway", sans-serif;
        color: white;
        min-height: 100vh;
        letter-spacing: 0.1rem;
      }

      body {
        transition: background 0.4s, color 0.4s;
      }

      .navbar {
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      }

      .card-hover:hover {
        transform: scale(1.02);
        transition: 0.3s;
      }

      .list-group-item {
        display: flex;
        justify-content: space-between;
      }

      /* Dark Mode Styles */
      .dark-mode {
        background-color: #121212 !important;
        color: #f8f9fa !important;
      }

      .dark-mode .navbar {
        background-color: #1c1c1c !important;
      }

      .dark-mode .offcanvas {
        background-color: #222 !important;
      }

      .dark-mode .offcanvas-body a {
        color: #ddd !important;
      }

      .dark-mode .offcanvas-body a:hover {
        background: rgba(255, 255, 255, 0.1);
      }

      .dark-mode .summary-card {
        background-color: #1e1e1e !important;
        color: #f8f9fa !important;
        border: 1px solid #444;
      }

      .dark-mode .list-group-item {
        background-color: #282828 !important;
        color: #f8f9fa !important;
      }

      .dark-mode .text-muted {
        color: #b0b0b0 !important;
        /* Ensure text-muted color changes */
      }

      /* Fade-in animation */
      @keyframes fadeIn {
        from {
          opacity: 0;
          transform: translateY(20px);
        }

        to {
          opacity: 1;
          transform: translateY(0);
        }
      }

      .card {
        opacity: 0;
        /* Initially hidden */
        animation: fadeIn 0.6s ease-in-out forwards;
      }

      .tick {
        color: lime !important;
      }

      .cross {
        color: red !important;
      }

      .default-bg {
        background: radial-gradient(circle, gray, #232323, black);
      }

      .light-bg {
        background: radial-gradient(circle, cyan, #140078, #000028);
      }

      h2, .fa-circle-user {
        font-weight: 1000;
      }

      .fa-circle-user {
        font-size: 3rem;
      }

      /* Dark Mode Toggle */
      #darkModeToggle {
        transition: all 0.3s ease-in-out;
      }
      #darkModeToggle:hover {
        transform: scale(1.1);
      }

      input.form-control,
      select.form-select,
      button, textarea, a {
        font-weight: bold !important;
        padding: 0.9rem !important;
        font-size: 1.1rem !important;
        letter-spacing: 0.1rem;
      }

      label {
        font-weight: bold;
      }

      .dark-input {
        background-color: black !important;
        color: white !important;
        border-color: white !important;
      }
      .dark-input::placeholder {
        color: rgba(255, 255, 255, 0.6);
      }

      /* Centered Card with Glassmorphism Effect */
      .card {
        background: rgba(255, 255, 255, 0.4);
        backdrop-filter: blur(10px);
        color:white;
        border-radius: 15px;
        padding: 2rem;
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
        width: 100%;
        max-width: 500px;
       
      }

      /* Floating Effect */
      @keyframes floatEffect {
        0% {
          transform: translateY(0px);
        }
        33% {
          transform: translateY(-5px);
        }
        66% {
          transform: translateY(5px);
        }
        100% {
          transform: translateY(0px);
        }
      }

      /* Buttons */
      .btn-primary {
        border-radius: 8px;
        transition: all 0.3s ease-in-out;
      }
      .btn-primary:hover {
        transform: scale(1.05);
      }

      /* Form Inputs */
      .form-control {
        border-radius: 8px;
        border: 1px solid #ced4da;
        transition: all 0.3s ease-in-out;
      }
      .form-control:focus {
        border-color: #007bff;
        box-shadow: 0 0 10px rgba(0, 123, 255, 0.25);
      }

      /* Custom Dropdown */
      .form-select {
        border-radius: 8px;
        transition: all 0.3s ease-in-out;
      }
      .form-select:focus {
        border-color: #007bff;
        box-shadow: 0 0 10px rgba(0, 123, 255, 0.25);
      }

      .btn-danger {
        background: linear-gradient(135deg, #ff416c, #ff4b2b);
        border: none;
      }

      .btn-danger:hover {
        background: linear-gradient(135deg, #d4145a, #ff6a00);
      }

      .navbar {
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
      }

      .sidebar {
        height: 100vh;
        background-color: #f8f9fa;
        transition: transform 0.3s ease-in-out;
      }

      .sidebar.collapsed {
        transform: translateX(-100%);
      }

      .main-content {
        padding: 20px;
        transition: margin-left 0.3s ease-in-out;
      }

      .main-content.expanded {
        margin-left: 0;
      }

      .navbar .form-control {
        width: 300px;
      }

       /* --- Base Table Styling for Both Modes --- */
       .table {
        background: rgba(255, 255, 255); /* Semi-transparent for glass effect */
        color: #f8f9fa;
        border-radius: 12px;
        overflow: hidden;
        backdrop-filter: blur(10px);
        border: 3px solid rgb(0, 0, 0);
        transition: all 0.3s ease-in-out;
      }

      /* --- Add Padding to Table Header and Rows --- */
      .table th,
      .table td {
        padding: 12px 8px; /* Increased vertical padding */
        text-align: center; /* Center align for better readability */
      }

      /* --- Header Styling --- */
      .table thead {
        background: linear-gradient(135deg, #222, #444);
        color: #0ff; /* Neon Cyan */
        font-weight: bold;
        text-transform: uppercase;
        padding: 12px 8px; /* Increased vertical padding */
      }

      /* --- Row Colors (Adaptive) --- */
      .table-striped tbody tr:nth-of-type(odd) {
        background-color: #0a0a0a; /* Dark Mode: Deep Black | Light Mode: Adjusted */
        color: #fff;
      }

      .table-striped tbody tr:nth-of-type(even) {
        background-color: #1e1e1e;
        color: #fff;
      }

      /* --- Glow Borders & Hover Effects --- */
      .table tbody tr {
        border-left: 4px solid transparent;
        transition: all 0.3s ease-in-out;
      }

      /* --- Light Mode Adjustments --- */
      body:not(.dark-mode) .table {
        background: white;
        color: white;
        border: 2px solid white;
      }

      body:not(.dark-mode) .table thead {
        /* background: linear-gradient(135deg, #ddd, #bbb); */
        color: white;
      }

      body:not(.dark-mode) .table-striped tbody tr:nth-of-type(odd) {
        background-color: #f9f9f9;
        color: white;
      }

      body:not(.dark-mode) .table-striped tbody tr:nth-of-type(even) {
        background-color: #e9e9e9;
        color: white;
      }

      .dark-mode .table {
        color: black !important;
      }

      .dark-mode .table th,
      .dark-mode .table td {
        background-color: white !important;
        color: black !important;
        border-color: #444 !important;
      }

      .dark-mode .table thead {
        background-color: #333 !important;
      }

      .dark-mode .table-striped tbody tr:nth-of-type(odd) {
        background-color: #292929 !important;
      }

      .dark-mode .table-striped tbody tr:nth-of-type(even) {
        background-color: #1e1e1e !important;
      }

      /* Default (Dark Mode) */
.table-hover tbody tr:hover {
  background-color: #333 !important; /* Dark grey hover for dark mode */
  color: white !important;
}

/* Light Mode */
.light-mode .table-hover tbody tr:hover {
  background-color: blue !important; /* Light grey hover for light mode */
  color: black !important;
}
    </style>
  </head>

  <body>
      <nav class="navbar navbar-expand-lg navbar-dark bg-black p-3">
        <div class="container-fluid">
          <button class="btn btn-outline-light me-3" data-bs-toggle="offcanvas" data-bs-target="#sidebar">
            <i class="fa-solid fa-bars"></i>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <a href="sellerDashboard.jsp" class="text-decoration-none text-white">Seller Dashboard</a>
          </div>
         
          <button class="btn btn-outline-light ms-auto" id="toggleDarkMode">
            <i class="fa-solid fa-sun"></i>
          </button>
        </div>
      </nav>

    <div class="offcanvas offcanvas-start bg-dark text-white" id="sidebar">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title fw-bold">📦 Menu</h5>
        <button
          type="button"
          class="btn-close btn-close-white"
          data-bs-dismiss="offcanvas"
        ></button>
      </div>
      <div class="offcanvas-body">
        <a
          href="./manage_products.jsp"
          class="d-block text-white p-2 text-decoration-none"
          >Manage Products</a
        >
        <a
          href="./indexOrderSeller.jsp"
          class="d-block text-white p-2 text-decoration-none"
          >Order Data</a
        >
        <a href="./indexReportSeller.jsp" class="d-block text-white p-2 text-decoration-none"
          >Reports</a
        >
        <a href="./indexSellerProfile.jsp" class="d-block text-white p-2 text-decoration-none"
          >Profile</a
        >
      </div>
    </div>
  
      <div class="container mt-4">
        <h2 class="text-center mb-4">Your Orders</h2>
        <div class="row">
            <%
                List<SellerOrder> sellerOrders = (List<SellerOrder>) request.getAttribute("sellerOrders");
                if (sellerOrders != null && !sellerOrders.isEmpty()) {
                    for (SellerOrder order : sellerOrders) {
            %>
                <div class="col-md-4 mb-3">
                    <div class="card mb-3 bg-dark">
                        <div class="card-body">
                            <h5 class="card-title"><%= order.getProductName() %></h5>
                            <p class="card-text"><strong>Order ID:</strong> <%= order.getOrderId() %></p>
                            <p class="card-text"><strong>Consumer ID:</strong> <%= order.getConsumerPortId() %></p>
                            <p class="card-text"><strong>Quantity:</strong> <%= order.getProductQuantity() %></p>
                            <p class="card-text"><strong>Order Date:</strong> <%= order.getOrderDate() %></p>
                            <p class="card-text"><strong>Status:</strong> 
                                <%= order.isDelivered() ? "Delivered" :
                                   order.isOutForDelivery() ? "Out for Delivery" :
                                   order.isShipped() ? "Shipped" :
                                   order.isOrderPlaced() ? "Order Placed" : "Pending" %>
                            </p>
                        </div>
                    <a class="btn btn-success w-100" href="sellerOrderUpdate.jsp">Change Order Status</a>
                    </div>
                </div>
            <% 
                    } 
                } else { 
            %>
                <p class="text-center">No orders found.</p>
            <% } %>
        </div>
  
    <script>
      document
        .getElementById("toggleDarkMode")
        .addEventListener("click", function () {
          document.body.classList.toggle("dark-mode");
        });

        const darkModeToggle = document.getElementById("toggleDarkMode");
      darkModeToggle.addEventListener("click", function () {
        document.body.classList.toggle("light-bg");
        document.body.classList.toggle("text-black");
        document.querySelectorAll(".card").classList.toggle("bg-dark");
        document.querySelectorAll(".card").classList.toggle("text-black");

        const inputs = document.querySelectorAll(".form-control, .form-select");
        inputs.forEach((input) => {
          input.classList.toggle("dark-input");
        });
        // document.querySelector(".card").style.color = "black";

        const icon = darkModeToggle.querySelector("i");

        if (icon.classList.contains("fa-sun")) {
          icon.classList.replace("fa-sun", "fa-moon");
        } else {
          icon.classList.replace("fa-moon", "fa-sun");
        }
      });

      // JavaScript to toggle the sidebar and main content
      document.getElementById('toggleDashboard').addEventListener('click', function () {
        const sidebar = document.getElementById('sidebar');
        const mainContent = document.getElementById('mainContent');
        sidebar.classList.toggle('collapsed');
        mainContent.classList.toggle('expanded');
      });

      document.getElementById("darkModeToggle").addEventListener("click", function () {
  document.body.classList.toggle("light-mode");
});
    </script>
  </body>
</html>
