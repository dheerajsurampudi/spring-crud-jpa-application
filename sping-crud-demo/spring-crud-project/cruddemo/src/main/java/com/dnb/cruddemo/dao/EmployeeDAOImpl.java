package com.dnb.cruddemo.dao;

import com.dnb.cruddemo.entity.Employee;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
        //exec a query
        List<Employee> res= theQuery.getResultList();
        //return the res
        return res;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee= entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee theResEmployee = entityManager.merge(theEmployee);
        return theResEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(theEmployee);
    }
}
