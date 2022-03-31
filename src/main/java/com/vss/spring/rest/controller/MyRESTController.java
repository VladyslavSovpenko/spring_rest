package com.vss.spring.rest.controller;

import com.vss.spring.rest.entity.Employee;
import com.vss.spring.rest.exceptionHandling.NoSuchEmployeeException;
import com.vss.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmp() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {

        Employee employee = employeeService.get(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("No such employee");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmp(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable Long id){

        Employee employee = employeeService.get(id);
        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with id="+id);
        }
        employeeService.delete(id);
        return "Employee with id= "+ id +" was deleted";

    }
}
