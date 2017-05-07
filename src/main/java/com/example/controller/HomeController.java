package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.dao.MeetingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Selma on 07.05.2017.
 */
@Controller
public class HomeController {

    private MeetingDao meetingDao;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;

    @Autowired
    public HomeController(DepartmentDao departmentDao,EmployeeDao employeeDao, MeetingDao meetingDao) {
        this.employeeDao = employeeDao;
        this.meetingDao = meetingDao;
        this.departmentDao=departmentDao;
    }

    @RequestMapping("/")
    public String index(Map<String, Object> model) throws Exception {
        model.put("departments",departmentDao.getAll());
        return "index";
    }

    @RequestMapping("/employees")
    public String employees(Map<String, Object> model) throws Exception {
        model.put("employees",employeeDao.getAll());
        return "employee/employee";
    }

    @RequestMapping("/meetings")
    public String meetings(Map<String, Object> model) throws Exception {
        model.put("meetings",meetingDao.getAll());
        return "meeting/meeting";
    }
}
