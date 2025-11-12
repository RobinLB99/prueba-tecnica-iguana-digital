package com.robinlb99.pruebatecnica.feature.employee.service.contract;

import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeRequestDTO;
import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeResponseDTO;
import java.util.List;

public interface EmployeeService {
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employee);

    public EmployeeResponseDTO getEmployee(Integer id);

    public EmployeeResponseDTO updateEmployee(
        EmployeeRequestDTO employee,
        Integer id
    );

    public void deleteEmployee(Integer id);

    public void transferSalary(
        Integer employeeIDOne,
        Integer employeeIDTwo,
        Double value
    );

    public List<EmployeeResponseDTO> getAboveAverageSalaryEmployees();
}
