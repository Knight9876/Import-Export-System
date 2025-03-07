<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, models.Report"%>
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

button {
	font-weight: bold !important;
	padding: 0.9rem !important;
	font-size: 1.1rem !important;
	letter-spacing: 0.1rem;
}

.dark-input {
	background-color: black !important;
	color: white !important;
	border-color: white !important;
}

.dark-input::placeholder {
	color: rgba(255, 255, 255, 0.6);
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
.table th, .table td {
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
	background-color: #0a0a0a;
	/* Dark Mode: Deep Black | Light Mode: Adjusted */
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

.dark-mode .table th, .dark-mode .table td {
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
<!-- Integrated Navigation Bar -->
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
  
      <!-- Sidebar -->
      <div class="offcanvas offcanvas-start bg-dark text-white" id="sidebar">
        <div class="offcanvas-header">
          <h5 class="offcanvas-title fw-bold">📦 Menu</h5>
          <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas"></button>
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
    <div class="container mt-5">
	<h2>Reported Products</h2>
      <div
        class="table-responsive rounded shadow-lg p-3 text-white"
        id="tableContainer"
      >
	<table class="table table-dark table-sm text-center" id="productTable">
		<thead>
			<tr>
				<th>Product ID</th>
				<th>Consumer ID</th>
				<th>Issue</th>
				<th>Solution</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<%
			List<Report> reports = (List<Report>) request.getAttribute("reports");
			if (reports != null && !reports.isEmpty()) {
				for (Report report : reports) {
			%>
			<tr>
				<td class="align-middle d-none"><%=report.getReportId()%></td>
				<td class="align-middle"><%=report.getProductId()%></td>
				<td class="align-middle"><%=report.getConsumerPortId()%></td>
				<td class="align-middle issue-type"><%=report.getIssueType()%></td>
				<td class="align-middle solution"><%=report.getSolution()%></td>
				<td class="align-middle"><%=report.getStatus()%></td>
				<td class="align-middle">
    <button class="btn btn-sm btn-warning resolve-btn" data-report-id="<%=report.getReportId()%>">Resolve</button>
</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="5" class="align-middle">No reports found.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	</div>
	</div>
	<script>
    // Function to generate solutions based on issue type
    function generateSolutions() {
        // Get all rows in the table body
        const rows = document.querySelectorAll("#productTable tbody tr");

        // Loop through each row
        rows.forEach(row => {
            // Get the issue type cell
            const issueTypeCell = row.querySelector(".issue-type");
            const issueType = issueTypeCell.textContent.trim().toLowerCase();

            // Get the solution cell
            const solutionCell = row.querySelector(".solution");

            // Determine the solution based on the issue type
            let solution = "";
            switch (issueType) {
                case "damage":
                    solution = "Replacement";
                    break;
                case "delayed":
                    solution = "Compensation";
                    break;
                case "not received":
                    solution = "Resend";
                    break;
                case "missing":
                    solution = "Resend";
                    break;
                case "wrong product":
                    solution = "Replacement";
                    break;
                default:
                    solution = "Investigation Required";
            }

            // Update the solution cell with the generated solution
            console.log(solutionCell.textContent)
            solutionCell.innerHTML = solution;
        });
    }

    // Run the script when the page loads
    window.onload = generateSolutions;
    
    document.addEventListener("DOMContentLoaded", function () {
        const resolveButtons = document.querySelectorAll(".resolve-btn");

        resolveButtons.forEach(button => {
            button.addEventListener("click", function () {
                const reportId = button.getAttribute("data-report-id");

                // Send an AJAX request to update the status
                updateStatus(reportId, button);
            });
        });
    });

    function updateStatus(reportId, button) {
        fetch("UpdateReportStatusController", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ reportId: reportId }),
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // Update the UI to reflect the new status
                const statusCell = button.closest("tr").querySelector(".status");
                statusCell.textContent = "Resolved";
                button.disabled = true; // Disable the button after resolving
                window.location.reload();
            } 
        })
        .catch(error => {
        	window.location.reload();
        });
    }
    
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
</script>
</body>
</html>
