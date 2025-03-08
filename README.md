# Import-Export Management System for Netherlands Port

A web-based application designed to manage import-export operations at the Netherlands port. Customers can order products, track orders, update profiles, and report faulty products. Sellers can manage inventory, process orders, update order status, and resolve reported issues.

---

## Technologies Used

- **Frontend**: JSP, Bootstrap, JavaScript
- **Backend**: Java, Servlets
- **Database**: MySQL
- **Web Server**: Apache Tomcat
- **Build Tool**: Maven/Gradle

---

## Features

### Customer Features
- Register and log in.
- Browse and order products.
- Track order status.
- Update profile information.
- Report faulty products.

### Seller Features
- Manage inventory (add, update, delete products).
- Process and update order status.
- View and resolve reported issues.

---

## Setup Instructions

### Prerequisites
1. **Java Development Kit (JDK)**: Version 8 or higher.
2. **Apache Tomcat**: Version 9 or higher.
3. **MySQL**: Version 5.7 or higher.
4. **Eclispe**: For dependency management.
5. **Git**: To clone the repository.

### Steps to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/import-export-management-system.git
   cd import-export-management-system
   ```
   
2. Set Up the Database:
- Create a MySQL database named port_management.
- Run the SQL scripts located in the database/ folder to create tables and populate sample data.
- 
3.Configure Database Connection:
- Update the DB_URL, DB_USERNAME, and DB_PASSWORD in src/main/java/db/GetConnection.java with your MySQL credentials.

4. Build the Project:
- Use Maven to build the project:
  ```bash
  mvn clean install
  ```

5. Deploy on Apache Tomcat:
- Copy the generated .war file from the target/ directory to the webapps/ directory of your Tomcat server.
- Start the Tomcat server:
  ```bash
  ./catalina.sh run
  ```
  
6. Access the Application:
- Open your browser and navigate to:
    http://localhost:8080/import-export-management-system
  
---
  
## Project Structure
import-export-management-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/example/
│   │   │   │   ├── controller/          # Servlets for handling requests
│   │   │   │   ├── dao/                 # Data Access Objects (DAOs)
│   │   │   │   ├── model/               # Java Beans (e.g., User, Product, Order)
│   │   │   │   ├── util/                # Utility classes (e.g., DatabaseUtil)
│   │   ├── webapp/
│   │   │   ├── files.jsp                # JSP pages
│   │   │   ├── register.html            # Homepage
│   ├── test/                            # Unit tests
db.sql
