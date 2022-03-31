package com.vss.spring.rest.dao;

import com.vss.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> getAll();

    public Employee get(Long id);

    public void create(Employee employee);

    public void delete(Long id);
}
