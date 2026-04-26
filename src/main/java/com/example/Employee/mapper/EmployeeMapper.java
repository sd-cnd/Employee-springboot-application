package com.example.Employee.mapper;

import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.entity.Employee;

import java.util.function.Function;

public class EmployeeMapper {

    public static final Function<Employee, EmployeeDTO> toDTO = emp ->
            new EmployeeDTO(
                    emp.getId(),
                    emp.getName(),
                    emp.getDepartment(),
                    emp.getCareerPoints(),
                    emp.getYearsOfExp()
            );

    public static final Function<EmployeeDTO, Employee> toEntity = dto ->
            new Employee(
                    dto.getId(),
                    dto.getName(),
                    dto.getDepartment(),
                    dto.getCareerPoints(),
                    dto.getYearsOfExp()
            );
}