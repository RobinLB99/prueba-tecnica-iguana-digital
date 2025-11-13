package com.robinlb99.pruebatecnica.feature.employee.dao.contract;

public interface EmployeeDAO {
    public void transferSalary(
        Integer employeeIDOne,
        Integer employeeIDTwo,
        Double value
    );
}
