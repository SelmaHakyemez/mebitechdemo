package com.example.dao;

import com.example.model.Department;

import java.util.List;

/**
 * Created by Selma on 07.05.2017.
 */
public interface DepartmentDao {

    List<Department> getAll();
    Department findById(Integer departmentId);
    void create(Department department);
    void update(Department department);
    void delete(Department department);
}
