<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
    <style>
      body {
        font-family: "Raleway", sans-serif;
        background: radial-gradient(circle, gray, #232323, black);
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
      }
      .card {
        backdrop-filter: blur(10px);
        background: rgba(255, 255, 255, 0.4);
        color: white;
        border-radius: 12px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
      }
      .btn-primary:hover {
        transform: scale(1.05);
      }
      .dark-input {
        background-color: black !important;
        color: white !important;
      }
      body {
        font-family: "Raleway", sans-serif;
        transition: all 0.4s ease-in-out;
        /* background: linear-gradient(135deg, darkblue, cyan, blue, cyan, darkblue); */
        background: radial-gradient(circle, gray, #232323, black);
        /* background: linear-gradient(135deg, #000028, #140078, cyan); */
        /* background: radial-gradient(circle, cyan, #140078, #000028); */
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        letter-spacing: 0.1rem;
      }

      .login-container {
        max-width: 400px;
        margin: 100px auto;
        padding: 20px;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      .captcha-box {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 15px;
      }

      .captcha-box input {
        width: 60%;
      }

      .captcha-box span {
        font-size: 20px;
        font-weight: bold;
        background: #e9ecef;
        padding: 5px 10px;
        border-radius: 4px;
      }

      .default-bg {
        background: radial-gradient(circle, gray, #232323, black);
      }

      .light-bg {
        background: radial-gradient(circle, cyan, #140078, #000028);
      }

      h2 {
        font-weight: 1000;
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
      button,
      #captcha {
        font-weight: bold !important;
        padding: 0.9rem !important;
        font-size: 1.1rem !important;
        letter-spacing: 0.1rem;
      }

      #captcha {
        border: 1px solid black;
        border-radius: 0.5rem;
        width: max-content;
      }

      #captchaInput,
      #captcha {
        letter-spacing: 0.2rem;
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
        backdrop-filter: blur(10px);
        background: rgba(255, 255, 255, 0.4);
        color: white;
        border-radius: 12px;
        box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        animation: floatEffect 4s infinite ease-in-out;
      }

      .card:hover {
        transform: scale(1.02);
        box-shadow: 0 6px 25px rgba(0, 0, 0, 0.15);
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
      
    </style>
</head>
<body>
    <button class="btn btn-outline-light ms-auto position-absolute top-0 end-0 m-3" id="toggleDarkMode">
        <i class="fa-solid fa-sun"></i>
    </button>
    <div class="position-absolute top-50 start-50 translate-middle w-100" style="max-width: 500px">
        <div class="card bg-dark p-4 shadow-lg">
            <h2 class="text-center mb-4">User Registration</h2>
            <form action="RegisterController" method="post" id="registerForm">
                <div class="mb-3">
                    <label for="portId" class="form-label">Port ID</label>
                    <input type="text" class="form-control dark-input" name="portId" required />
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control dark-input" name="password" required />
                </div>
                 <div class="mb-3">
                    <label for="password" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control dark-input" name="confirm-password" required />
                </div>
                <div class="mb-3">
                    <label for="role" class="form-label">Role</label>
                    <select class="form-select dark-input" name="role" required>
                        <option value="consumer">Consumer</option>
                        <option value="seller">Seller</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="location" class="form-label">Location</label>
                    <input type="text" class="form-control dark-input" name="location" required />
                </div>
                <button type="submit" class="btn btn-primary w-100">Register</button>
            </form>
            <p class="text-center mt-3">Already have an account? <a href="login.jsp">Login here</a></p>
            <p class="text-center mt-3" id="message"></p>
        </div>
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