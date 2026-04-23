# Employee Management System (Spring Boot CRUD API)

## Overview

This is a simple backend **Employee Management System** built using Spring Boot.  
The application demonstrates CRUD (Create, Read, Update, Delete) operations using a RESTful API architecture. It uses an in-memory **H2 database** for data storage and is tested using Postman.

The project follows the **MVC (Model–View–Controller) architecture** to maintain clean separation of concerns.

---

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (In-Memory)
- Maven
- Postman (for API testing)

---

## Features

- Create a new employee
- Fetch all employees
- Fetch employee by ID
- Update employee details
- Delete employee
- Proper HTTP status code handling
- In-memory database (H2 Console available)

---

## Employee Entity Structure

The application manages an `Employee` entity with the following fields:

- `id` (Auto-generated Primary Key)
- `name`
- `department`
- `careerPoints`
- `yearsOfExp`

This data is stored in the `EMPLOYEE` table in the H2 database.

---

## API Endpoints

| Method | Endpoint              | Description              |
|--------|----------------------|--------------------------|
| POST   | /employees           | Create new employee      |
| GET    | /employees           | Get all employees        |
| GET    | /employees/{id}      | Get employee by ID       |
| PUT    | /employees/{id}      | Update employee details  |
| DELETE | /employees/{id}      | Delete employee          |

---

## How the Application Works

1. Client sends HTTP request using Postman.
2. Controller receives the request and routes it to the Service layer.
3. Service layer contains business logic and interacts with the Repository.
4. Repository communicates with the H2 database using Spring Data JPA.
5. Response is returned back to the client with appropriate HTTP status codes.

---

## MVC Architecture Used

### Model
Represents the data structure of the application.

- In this project, the `Employee` class is the Model.
- It maps directly to the `EMPLOYEE` table in the database.

### View
Since this is a backend-only project, there is no UI layer.
- Postman acts as the client to view responses.

### Controller
Handles incoming HTTP requests.

- `EmployeeController` processes all API requests.
- It returns appropriate HTTP responses.

### Service
Contains business logic.

- `EmployeeService` handles all operations like create, update, delete, and fetch.

### Repository
Handles database operations.

- `EmployeeRepository` extends `JpaRepository`.
- It provides built-in CRUD operations.

---

## Database (H2)

- In-memory database used for development and testing.
- No external setup required.
- Data resets every time the application restarts.


---

## Postman Testing (Screenshots)

### Below are the API test results :-

### 1. Create Employee (POST)
![Create Employee](https://i.ibb.co/j9WRyTF9/Create-employee.png)

### 2. Get All Employees (GET)
![Get All Employees](https://i.ibb.co/dsJKwKkC/Get-all-employees.png)

### 3. Get Employee by ID (GET)
![Get Employee By ID](https://i.ibb.co/LDpXG3JM/Get-employee-By-Id.png)

### 4. Update Employee (PUT)
![Update Employee](https://i.ibb.co/jZksW5Vq/update-employee-data.png)

### 5. Delete Employee (DELETE)
![Delete Employee](https://i.ibb.co/jv0DhZcw/delete-employee.png)

### API test results where error handling has been done :-

### 6. Create Employee with missing fields (POST)
![Create Employee](https://i.ibb.co/yT8v8xV/Creating-employees-with-incorrect-fields.png)

### 7. Create Employee with incorrect fields (POST)
![Create Employee](https://i.ibb.co/fVWcYvxc/Creating-employees-with-incorrect-field-values.png)

### 8. Get Employee by incorrect ID (GET)
![Get Employee By ID](https://i.ibb.co/7JmjRCYZ/Get-employee-by-id-doesn-t-exist.png)

### 9. Update Employee with non-existent Id (PUT)
![Update Employee](https://i.ibb.co/hFgzF8tN/update-employee-data-emp-doesn-t-exist.png)

### 10. Update Employee with incorrect field value (PUT)
![Update Employee](https://i.ibb.co/LzYxY6yh/updating-with-incorrect-field-value.png)

### 11. Delete Employee with non-existent Id (DELETE)
![Delete Employee](https://i.ibb.co/zVWnT5VD/delete-employee-doesn-t-exist.png)

---

## Link of repository in Editor style : [IDE style Visualization of code](https://github.com/username/repository-name)

---