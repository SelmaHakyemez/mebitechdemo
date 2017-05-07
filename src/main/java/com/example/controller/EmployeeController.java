package com.example.controller;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Selma on 07.05.2017.
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeDao.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Employee> addEmployee(Employee employee) {
        employeeDao.create(employee);
        return employeeDao.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Employee> updateEmployee(Employee employee) {
        employeeDao.update(employee);
        return employeeDao.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public List<Employee> deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
        return employeeDao.getAll();
    }

    @RequestMapping(value = "/createUpdate", method = RequestMethod.GET)
    public String getDepartment(@RequestParam(value = "uid", required = false) Integer uid, Map<String, Object> model) {
        Employee employee = new Employee();
        if (Objects.nonNull(uid))
            employee = employeeDao.findById(uid);
        model.put("employee", employee);
        return "employee/createUpdateEmployee";
    }

    @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
    public String createUpdateDepartment(Employee employee, Map<String, Object> model) {
        if (employee.getEmployeeId() != null)
            employeeDao.update(employee);
        else
            employeeDao.create(employee);
        return "redirect:/";
    }

}