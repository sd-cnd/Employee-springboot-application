package com.example.Employee.controller;

import com.example.Employee.dto.ApiResponse;
import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeDTO>> create(@Valid @RequestBody EmployeeDTO dto) {
        EmployeeDTO saved = service.create(dto);
        return ResponseEntity.status(201)
                .body(new ApiResponse<>(201, "Employee created successfully", saved));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeDTO>>> getAll() {
        return ResponseEntity.ok(
                new ApiResponse<>(200, "Success", service.getAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeDTO>> getById(@PathVariable Long id) {
        EmployeeDTO emp = service.getById(id);

        if (emp != null) {
            return ResponseEntity.ok(
                    new ApiResponse<>(200, "Success", emp)
            );
        }

        return ResponseEntity.status(404).body(
                new ApiResponse<>(404, "Employee not found with id: " + id, null)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeDTO>> update(@PathVariable Long id,
                                                           @Valid @RequestBody EmployeeDTO dto) {
        EmployeeDTO updated = service.update(id, dto);

        if (updated != null) {
            return ResponseEntity.ok(
                    new ApiResponse<>(200, "Employee updated successfully", updated)
            );
        }

        return ResponseEntity.status(404).body(
                new ApiResponse<>(404, "Employee not found with id: " + id, null)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);

        if (deleted) {
            return ResponseEntity.ok(
                    new ApiResponse<>(200, "Employee deleted successfully", null)
            );
        }

        return ResponseEntity.status(404).body(
                new ApiResponse<>(404, "Employee not found with id: " + id, null)
        );
    }
}