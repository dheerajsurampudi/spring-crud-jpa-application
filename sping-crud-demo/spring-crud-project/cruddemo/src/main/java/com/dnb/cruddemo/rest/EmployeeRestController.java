package com.dnb.cruddemo.rest;

import com.dnb.cruddemo.dao.EmployeeDAO;
import com.dnb.cruddemo.entity.Employee;
import com.dnb.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   private EmployeeService employeeService;

   @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeById(@PathVariable int employeeId) {
            Employee theEmployee =  employeeService.findById(employeeId);
            if(theEmployee == null) {
                throw new RuntimeException("Employee id not found - " + employeeId);
            }
            return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theNewEmployee) {
    theNewEmployee.setId(1);
    Employee dbEmployee = employeeService.save(theNewEmployee);
    return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theNewEmployee) {
       Employee dbEmployee = employeeService.save(theNewEmployee);
       return dbEmployee;
    }


}
