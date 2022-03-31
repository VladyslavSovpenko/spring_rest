package com.vss.spring.rest.service;

import com.vss.spring.rest.dao.EmployeeDaoImpl;
import com.vss.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoImpl employeeDao;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDao.getAll();
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.create(employee);
    }

    @Override
    @Transactional
    public Employee get(Long id) {
        return employeeDao.get(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        employeeDao.delete(id);
    }
}
