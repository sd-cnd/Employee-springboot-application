package com.example.Employee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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