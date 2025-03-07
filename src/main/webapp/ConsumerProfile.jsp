<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.Consumer" %>
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
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
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
    </style>
  </head>

  <body>
    <!-- Integrated Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-black p-3">
      <div class="container-fluid">
        <!-- Sidebar toggle button -->
        <button
          class="btn btn-outline-light me-3"
          data-bs-toggle="offcanvas"
          data-bs-target="#sidebar"
        >
        <i class="fa-solid fa-bars"></i>
        </button>

        <!-- Navigation Links (Left Side) -->
        <div class="collapse navbar-collapse" id="navbarNav">
          <a href="consumerDashboard.jsp" class="text-white text-decoration-none">Consumer Dashboard</a>
        </div>

        

        <!-- Dark Mode Button (Rightmost) -->
        <button class="btn btn-outline-light ms-auto" id="toggleDarkMode">
          <i class="fa-solid fa-sun"></i>
        </button>
      </div>
    </nav>

    <!-- Sidebar -->
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
<ul class="nav flex-column mt-4">
        <li class="nav-item">
              <a class="nav-link text-white" href="indexProductCon.jsp">Product</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white" href="indexOrderCon.jsp">Orders</a>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white" href="cart.html">Cart</a>
            </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="indexConProfile.jsp">Profile</a>
          </li>
        </ul>      </div>
    </div>

    <div class="card bg-dark">
  <div class="d-flex gap-3 justify-content-center align-items-center">
    <i class="mb-4 fa-solid fa-circle-user"></i>
    <h2 class="mb-4 text-center">Profile</h2>
  </div>
  <form>
    <%
    Consumer consumer = (Consumer) request.getAttribute("consumer");
    if (consumer != null) {
    %>
      <div class="mb-3">
        <label for="name" class="form-label">Port ID</label>
        <input type="text" class="form-control dark-input" id="name" value="<%= consumer.getPortId() %>" />
      </div>
      <div class="mb-4">
        <label for="address" class="form-label">Address</label>
        <textarea class="form-control dark-input" id="address" rows="3"><%= consumer.getLocation() %></textarea>
      </div>
      <a href="consumerProfileEdit.jsp" class="btn btn-primary w-100 mb-2">Edit Profile</a>
      <a href="register.jsp" class="btn btn-danger w-100 mb-2">Logout</a>
    <%
    } else {
    %>
      <p class="text-white text-center">Consumer data not found.</p>
    <%
    }
    %>
  </form>
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
        document.querySelector(".card").classList.toggle("bg-dark");
        document.querySelector(".card").classList.toggle("text-black");

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
    </script>
  </body>
</html>
