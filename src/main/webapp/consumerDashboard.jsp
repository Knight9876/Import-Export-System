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
        transition: background 0.4s, color 0.4s;
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

      h2.fw-bold, p.text-muted {
    color: #ffffff !important;
      }


      .card {
        opacity: 0;
        /* Initially hidden */
        animation: fadeIn 0.6s ease-in-out forwards;
      }
      
        header {
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            color: white;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .about-us, .features {
            margin: 20px auto;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            color: black !important;
        }
        
          .features ul {
            list-style-type: none;
            padding: 0;
        }
        .features ul li {
            background: #2575fc;
            color: white;
            padding: 10px;
            margin: 5px 0;
            border-radius: 5px;
        }
    </style>

     
   
  </head>
  <body class="bg-light text-dark">
    <nav class="navbar navbar-dark bg-black p-3">
      <div class="container-fluid d-flex align-items-center">
        <button
          class="btn btn-outline-light me-3"
          data-bs-toggle="offcanvas"
          data-bs-target="#sidebar"
        >
          <i class="fa-solid fa-bars"></i>
        </button>
        <a href="consumerDashboard.jsp" class="text-white text-decoration-none"><b>Consumer Dashboard</b></a>
        <button class="btn btn-outline-light ms-auto" id="toggleDarkMode"><i class="fa-solid fa-sun"></i></button>
        
      </div>
    </nav>

    <div class="offcanvas offcanvas-start bg-dark text-white" id="sidebar">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title fw-bold">Menu</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"></button>
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
        </ul>
      </div>
    </div>

    <div class="container mt-4">
       <header>
        <h1>Welcome, Consumer!!!</h1>
        <p>Your one-stop destination for seamless order tracking and management.</p>
    </header>
    
    <section class="about-us">
        <h2>About Us</h2>
        <p>We are dedicated to providing a streamlined and efficient way for consumers to track their orders, manage their purchases, and stay updated with real-time tracking information.</p>
        <p>Our platform ensures transparency, security, and a user-friendly experience.</p>
    </section>
    
    <section class="features">
        <h2>Why Choose Us?</h2>
        <ul>
            <li>Real-time order tracking</li>
            <li>User-friendly dashboard</li>
            <li>Secure and reliable transactions</li>
            <li>24/7 customer support</li>
        </ul>
    </section>
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