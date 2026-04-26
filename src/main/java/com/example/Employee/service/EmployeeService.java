package com.example.Employee.service;

import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.entity.Employee;
import com.example.Employee.mapper.EmployeeMapper;
import com.example.Employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public EmployeeDTO create(EmployeeDTO dto) {
        Employee emp = EmployeeMapper.toEntity.apply(dto);
        return EmployeeMapper.toDTO.apply(repo.save(emp));
    }

    public List<EmployeeDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(EmployeeMapper.toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getById(Long id) {
        return repo.findById(id)
                .map(EmployeeMapper.toDTO)
                .orElse(null);
    }

    public EmployeeDTO update(Long id, EmployeeDTO dto) {
        Employee existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(dto.getName());
            existing.setDepartment(dto.getDepartment());
            existing.setCareerPoints(dto.getCareerPoints());
            existing.setYearsOfExp(dto.getYearsOfExp());

            return EmployeeMapper.toDTO.apply(repo.save(existing));
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