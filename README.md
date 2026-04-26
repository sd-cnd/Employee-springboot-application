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

# Enhancements & Refactoring

The project was further improved by incorporating better design practices, cleaner architecture, and modern Java features. Below are the key updates along with their rationale.

---

## 1. Introduction of DTO Layer

### Change
- Added `EmployeeDTO` to represent data transferred between layers.
- Replaced direct exposure of the `Employee` entity in API responses.

### Why
- Prevents exposing internal database structure.
- Improves security and flexibility.
- Allows independent evolution of API and database schema.

---

## 2. Mapper Layer for Entity–DTO Conversion

### Change
- Introduced `EmployeeMapper` to handle conversions:
    - `Employee → EmployeeDTO`
    - `EmployeeDTO → Employee`

### Why
- Centralizes transformation logic.
- Avoids duplication across service and controller layers.
- Improves maintainability and readability.

---

## 3. Use of Functional Interface (Function) for Mapping

### Change

Implemented mapping using:

Function<Employee, EmployeeDTO> toDTO = emp -> new EmployeeDTO(...);

### Why
- Demonstrates modern Java functional programming concepts.
- Enables seamless integration with Stream API (`.map()`).
- Encourages reusable and composable transformation logic.

---

## 4. Stream API for Data Transformation

### Change

Replaced traditional loops with Java Streams:

repo.findAll()
.stream()
.map(EmployeeMapper.toDTO)
.toList();

### Why
- Improves code readability and conciseness.
- Enables functional-style data processing.
- Reduces boilerplate code.

---

## 5. Standardized API Response Structure

### Change

Introduced a generic response wrapper:

public class ApiResponse<T> {
private int status;
private String message;
private T data;
}

### Why
- Provides consistent API response format.
- Makes it easier for clients to parse responses.
- Supports flexible data types using generics.

---

## 6. Use of Generics (<T>) for Flexibility

### Change
- Implemented generic type `T` in `ApiResponse`.

### Why
- Allows reuse of the same response structure for:
    - Single object (`EmployeeDTO`)
    - Collections (`List<EmployeeDTO>`)
    - Messages (`String`)
- Ensures type safety without casting.

---

## 7. Improved Update Logic in Service Layer

### Change

Updated entity fields explicitly before saving:

existing.setName(dto.getName());
existing.setDepartment(dto.getDepartment());
existing.setCareerPoints(dto.getCareerPoints());
existing.setYearsOfExp(dto.getYearsOfExp());

### Why
- Ensures only intended fields are modified.
- Prevents accidental overwriting of data.
- Keeps business logic explicit and controlled.

---

## 8. Functional Mapping Usage in Service Layer

### Change

Used:

EmployeeMapper.toDTO.apply(repo.save(existing));

### Why
- Demonstrates execution of functional interface via `.apply()`.
- Maintains consistency with functional programming approach.

---

## 9. Adoption of Modern Java (.toList())

### Change

Replaced:

.collect(Collectors.toList());

with:

.toList();

### Why
- Cleaner and more concise syntax (Java 16+).
- Reduces verbosity.

---

## 10. Clean Separation of Concerns

### Change
Strengthened layer responsibilities:
- Controller → request/response handling
- Service → business logic
- Repository → data access
- Mapper → data transformation

### Why
- Improves scalability and maintainability.
- Aligns with industry-standard architecture.
- Makes testing and debugging easier.

---

## Summary

These enhancements transition the project from a basic CRUD implementation to a more production-aligned backend structure by:

- Introducing DTO abstraction
- Applying functional programming concepts
- Standardizing API responses
- Improving code readability and maintainability

The project now reflects modern Spring Boot development practices and is better suited for real-world applications and technical evaluations.

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

## Link of repository in Editor style : [IDE Style Visualization Of Code](https://github1s.com/sd-cnd/Employee-springboot-application/)

---