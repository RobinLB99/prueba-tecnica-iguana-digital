package com.robinlb99.pruebatecnica.feature.employee.service;

import com.robinlb99.pruebatecnica.feature.employee.exception.EmployeeNotFoundException;
import com.robinlb99.pruebatecnica.feature.employee.mapper.EmployeeMapper;
import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeRequestDTO;
import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeResponseDTO;
import com.robinlb99.pruebatecnica.feature.employee.model.entity.Employee;
import com.robinlb99.pruebatecnica.feature.employee.repository.EmployeeDAOImpl;
import com.robinlb99.pruebatecnica.feature.employee.repository.EmployeeRepository;
import com.robinlb99.pruebatecnica.feature.employee.service.contract.EmployeeService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private EmployeeRepository employeeRepository;
    private EmployeeDAOImpl employeeDAO;

    public EmployeeServiceImpl(
        EmployeeRepository employeeRepository,
        EmployeeMapper employeeMapper,
        EmployeeDAOImpl employeeDAO
    ) {
        this.employeeRepository = employeeRepository;
        this.employeeDAO = employeeDAO;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional
    public EmployeeResponseDTO createEmployee(
        EmployeeRequestDTO employeeRequestDTO
    ) {
        Employee employee = employeeMapper.toEmployee(employeeRequestDTO);
        return employeeMapper.toResponseDTO(employeeRepository.save(employee));
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeResponseDTO getEmployee(Integer id) {
        return employeeMapper.toResponseDTO(
            employeeRepository
                .findById(id)
                .orElseThrow(() ->
                    new EmployeeNotFoundException(
                        "El empleado con ID '" + id + "' no ha sido encontrado."
                    )
                )
        );
    }

    @Override
    @Transactional
    public EmployeeResponseDTO updateEmployee(
        EmployeeRequestDTO employeeRequestDTO,
        Integer id
    ) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(
                "Empleado con ID '" +
                    id +
                    "' no existe. No se puede actualizar un Empleado inexistente."
            );
        }
        Employee employee = employeeMapper.toEmployee(employeeRequestDTO);
        employee.setId(id);
        return employeeMapper.toResponseDTO(employeeRepository.save(employee));
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(
                "El empleado a eliminar con id '" + id + "' no existe"
            );
        }
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void transferSalary(
        Integer employeeIDOne,
        Integer employeeIDTwo,
        Double value
    ) {
        if (!employeeRepository.existsById(employeeIDOne)) {
            throw new EmployeeNotFoundException(
                "El empleado con ID '" + employeeIDOne + "' no existe"
            );
        }
        if (!employeeRepository.existsById(employeeIDTwo)) {
            throw new EmployeeNotFoundException(
                "El empleado con ID '" + employeeIDTwo + "' no existe"
            );
        }
        employeeDAO.transferSalary(employeeIDOne, employeeIDTwo, value);
    }

    @Override
    @Transactional
    public List<EmployeeResponseDTO> getAboveAverageSalaryEmployees() {
        return employeeRepository
            .getAboveAverageSalaryEmployees()
            .stream()
            .map(employeeMapper::toResponseDTO)
            .toList();
    }
}
