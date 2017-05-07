package com.example.dao;

import com.example.model.Employee;

import java.util.List;

/**
 * Created by Selma on 07.05.2017.
 */
public interface EmployeeDao {

    List<Employee> getAll();
    Employee findById(Integer EmployeeId);
    void create(Employee Employee);
    void update(Employee Employee);
    void delete(Employee Employee);
}
