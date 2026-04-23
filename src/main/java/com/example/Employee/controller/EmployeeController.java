package com.example.Employee.controller;

import com.example.Employee.entity.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Employee emp) {

        if (emp.getName() == null || emp.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Name is required")
            );
        }

        if (emp.getDepartment() == null || emp.getDepartment().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Department is required")
            );
        }

        if (emp.getCareerPoints() < 0) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Career points cannot be negative")
            );
        }

        if (emp.getYearsOfExp() < 0) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Years of experience cannot be negative")
            );
        }

        Employee saved = service.create(emp);

        return ResponseEntity.status(201).body(
                Map.of(
                        "status", 201,
                        "message", "Employee created successfully",
                        "data", saved
                )
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Employee> list = service.getAll();

        return ResponseEntity.ok(
                Map.of(
                        "status", 200,
                        "data", list
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Employee emp = service.getById(id);

        if (emp != null) {
            return ResponseEntity.ok(
                    Map.of(
                            "status", 200,
                            "data", emp
                    )
            );
        }

        return ResponseEntity.status(404).body(
                Map.of(
                        "status", 404,
                        "message", "Employee not found with id: " + id
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee emp) {

        if (emp.getName() == null || emp.getName().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Name is required")
            );
        }

        if (emp.getDepartment() == null || emp.getDepartment().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Department is required")
            );
        }

        if (emp.getCareerPoints() < 0) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Career points cannot be negative")
            );
        }

        if (emp.getYearsOfExp() < 0) {
            return ResponseEntity.badRequest().body(
                    Map.of("status", 400, "message", "Years of experience cannot be negative")
            );
        }

        Employee updated = service.update(id, emp);

        if (updated != null) {
            return ResponseEntity.ok(
                    Map.of(
                            "status", 200,
                            "message", "Employee updated successfully",
                            "data", updated
                    )
            );
        }

        return ResponseEntity.status(404).body(
                Map.of(
                        "status", 404,
                        "message", "Employee not found with id: " + id
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        boolean deleted = service.delete(id);

        if (deleted) {
            return ResponseEntity.ok(
                    Map.of(
                            "status", 200,
                            "message", "Employee deleted successfully"
                    )
            );
        }

        return ResponseEntity.status(404).body(
                Map.of(
                        "status", 404,
                        "message", "Employee not found with id: " + id
                )
        );
    }
}