package com.robinlb99.pruebatecnica.feature.employee.controller;

import com.robinlb99.pruebatecnica.feature.employee.mapper.EmployeeMapper;
import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeRequestDTO;
import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeResponseDTO;
import com.robinlb99.pruebatecnica.feature.employee.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeMapper employeeMapper;
    private EmployeeServiceImpl employeeService;

    public EmployeeController(
        EmployeeServiceImpl employeeService,
        EmployeeMapper employeeMapper
    ) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("create")
    public ResponseEntity<EmployeeResponseDTO> createEmployee(
        @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO
    ) {
        EmployeeResponseDTO employee = employeeMapper.toResponseDTO(
            employeeService.createEmployee(employeeRequestDTO)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> getEmployee(
        @PathVariable Integer id
    ) {
        EmployeeResponseDTO employee = employeeMapper.toResponseDTO(
            employeeService.getEmployee(id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeResponseDTO> updateEmployee(
        @Valid @RequestBody EmployeeRequestDTO employeeRequestDTO,
        @PathVariable Integer id
    ) {
        EmployeeResponseDTO employee = employeeMapper.toResponseDTO(
            employeeService.updateEmployee(employeeRequestDTO, id)
        );
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/transferSalary")
    public ResponseEntity<Void> transferSalary(
        @RequestParam Integer employeeIDOne,
        @RequestParam Integer employeeIDTwo,
        @RequestParam Double value
    ) {
        employeeService.transferSalary(employeeIDOne, employeeIDTwo, value);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/aboveAverageSalary")
    public ResponseEntity<List<EmployeeResponseDTO>> getAboveAverageSalaryEmployees() {
        List<EmployeeResponseDTO> employees = 
        		employeeService.getAboveAverageSalaryEmployees()
        			.stream()
        					.map(employeeMapper::toResponseDTO)
        					.toList();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }
}
