package com.robinlb99.pruebatecnica.feature.employee.repository.dao;


public interface EmployeeDAO {
	public void transferSalary(Integer employeeIDOne, Integer employeeIDTwo, Double value);
}
