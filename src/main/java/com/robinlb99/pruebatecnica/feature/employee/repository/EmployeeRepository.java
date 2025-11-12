package com.robinlb99.pruebatecnica.feature.employee.repository;

import com.robinlb99.pruebatecnica.feature.employee.model.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(
        "SELECT e "
        + "FROM Employee e "
        + "WHERE e.salary > (SELECT AVG(emp.salary) "
        					+ "FROM Employee emp) "
        + "ORDER BY e.salary DESC"
    )
    public List<Employee> getAboveAverageSalaryEmployees();
}
