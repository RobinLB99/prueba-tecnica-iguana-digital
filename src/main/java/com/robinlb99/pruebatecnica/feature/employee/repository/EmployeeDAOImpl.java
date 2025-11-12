package com.robinlb99.pruebatecnica.feature.employee.repository;

import com.robinlb99.pruebatecnica.feature.employee.repository.dao.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void transferSalary(
        Integer employeeIDOne,
        Integer employeeIDTwo,
        Double value
    ) {
        entityManager
            .createNativeQuery(
                "UPDATE EMPLOYEE SET salary = salary - :value WHERE id = :employeeIDOne"
            )
            .setParameter("value", value)
            .setParameter("employeeIDOne", employeeIDOne)
            .executeUpdate();

        entityManager
            .createNativeQuery(
                "UPDATE EMPLOYEE SET salary = salary + :value WHERE id = :employeeIDTwo"
            )
            .setParameter("value", value)
            .setParameter("employeeIDTwo", employeeIDTwo)
            .executeUpdate();
    }
}
