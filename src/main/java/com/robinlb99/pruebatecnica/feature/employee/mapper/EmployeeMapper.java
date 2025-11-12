package com.robinlb99.pruebatecnica.feature.employee.mapper;

import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeRequestDTO;
import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeResponseDTO;
import com.robinlb99.pruebatecnica.feature.employee.model.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee toEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.name());
        employee.setPosition(employeeRequestDTO.position());
        employee.setSalary(employeeRequestDTO.salary());
        return employee;
    }

    public EmployeeResponseDTO toResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
            employee.getId(),
            employee.getName(),
            employee.getPosition(),
            employee.getSalary()
        );
    }
}
