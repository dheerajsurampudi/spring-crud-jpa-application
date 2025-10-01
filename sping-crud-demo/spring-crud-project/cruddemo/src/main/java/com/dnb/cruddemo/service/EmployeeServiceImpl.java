package com.dnb.cruddemo.service;

import com.dnb.cruddemo.dao.EmployeeDAO;
import com.dnb.cruddemo.dao.EmployeeRepository;
import com.dnb.cruddemo.entity.Employee;

import java.util.List;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public Employee findById(int theId) {
        return employeeRepository.getById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {

    }
}
