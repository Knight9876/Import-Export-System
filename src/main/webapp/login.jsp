<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Page</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Raleway:wght@300;400;600&display=swap"
      rel="stylesheet"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    />
    <style>
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
    <!-- Dark Mode Button (Rightmost) -->
    <button
      class="btn btn-outline-light ms-auto position-absolute top-0 end-0 m-3"
      id="toggleDarkMode"
    >
      <i class="fa-solid fa-sun"></i>
    </button>

    <div
      class="position-absolute top-50 start-50 translate-middle w-100"
      style="max-width: 500px"
    >
      <div class="card bg-dark p-4 shadow-lg">
        <h2 class="text-center mb-3">Let's Login!!!</h2>
        <form id="loginForm" action="LoginController" method="post">
          <div class="mb-3">
            <label for="username" class="form-label">Port Id</label>
            <input
              type="text"
              class="form-control dark-input"
              id="portId"
              name="portId"
              required
            />
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input
              type="password"
              class="form-control dark-input"
              id="password"
              name="password"
              required
            />
          </div>
          <div class="mb-3">
            <label for="role" class="form-label">Select Role</label>
            <select class="form-select dark-input" id="role" name="role" required>
              <option value="consumer">Consumer</option>
              <option value="seller">Seller</option>
            </select>
          </div>
          <div class="captcha-box align-items-center">
            <div class="d-flex flex-column">
              <label for="captchaInput" class="form-label">Enter Captcha</label>
              <input
                type="text"
                class="form-control dark-input w-100"
                id="captchaInput"
                placeholder=""
                required
              />
            </div>
            <div class="d-flex flex-column">
              <span class="opacity-0">hidden</span>
              <span id="captcha" class="dark-input"></span>
            </div>
          </div>
          <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>
        <div class="text-center mt-3">
        <p class="text-center mt-3">Don't have an account? <a href="register.jsp">Register here</a></p>
          <a href="#" id="forgotPassword">Forgot Password?</a>
        </div>
      </div>
    </div>

    <script>
      // Dark Mode Toggle
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

      function generateCaptcha() {
        const chars =
          "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        let captcha = "";
        for (let i = 0; i < 6; i++) {
          captcha += chars[Math.floor(Math.random() * chars.length)];
        }
        return captcha;
      }

      document.getElementById("captcha").textContent = generateCaptcha();


      document
        .getElementById("forgotPassword")
        .addEventListener("click", function (event) {
          event.preventDefault();
          alert("A password reset link has been sent to your email.");
        });
    </script>
  </body>
</html>
