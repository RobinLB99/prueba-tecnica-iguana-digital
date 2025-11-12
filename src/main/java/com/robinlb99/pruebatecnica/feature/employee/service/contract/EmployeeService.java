package com.robinlb99.pruebatecnica.feature.employee.service.contract;

import com.robinlb99.pruebatecnica.feature.employee.model.dto.EmployeeRequestDTO;
import com.robinlb99.pruebatecnica.feature.employee.model.entity.Employee;
import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(EmployeeRequestDTO employee);

    public Employee getEmployee(Integer id);

    public Employee updateEmployee(EmployeeRequestDTO employee, Integer id);

    public void deleteEmployee(Integer id);

    public void transferSalary(
        Integer employeeIDOne,
        Integer employeeIDTwo,
        Double value
    );

    public List<Employee> getAboveAverageSalaryEmployees();
}
