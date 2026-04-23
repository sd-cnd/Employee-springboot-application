package com.example.Employee.service;

import com.example.Employee.entity.Employee;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee create(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Employee update(Long id, Employee emp) {
        Employee existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(emp.getName());
            existing.setDepartment(emp.getDepartment());
            existing.setCareerPoints(emp.getCareerPoints());
            existing.setYearsOfExp(emp.getYearsOfExp());

            return repo.save(existing);
        }

        return null;
    }

    public boolean delete(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}