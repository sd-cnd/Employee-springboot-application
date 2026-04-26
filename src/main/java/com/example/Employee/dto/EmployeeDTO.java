package com.example.Employee.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Department is required")
    private String department;

    @Min(value = 0, message = "Career points cannot be negative")
    private int careerPoints;

    @Min(value = 0, message = "Years of experience cannot be negative")
    private int yearsOfExp;
}