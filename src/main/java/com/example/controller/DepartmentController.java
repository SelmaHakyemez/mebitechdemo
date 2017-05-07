package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Selma on 07.05.2017.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentController(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Department> getDepartments() {
        return (List<Department>) departmentDao.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<Department> addDepartment(Department department) {
        departmentDao.create(department);
        return (List<Department>) departmentDao.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public List<Department> updateDepartment(Department department) {
        departmentDao.update(department);
        return (List<Department>) departmentDao.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public List<Department> deleteDepartment(Department department) {
        departmentDao.delete(department);
        return (List<Department>) departmentDao.getAll();
    }

    @RequestMapping(value = "/createUpdate", method = RequestMethod.GET)
    public String getDepartment(@RequestParam(value = "uid", required = false) Integer uid, Map<String, Object> model) {
        Department department = new Department();
        if (Objects.nonNull(uid))
            department = departmentDao.findById(uid);
        model.put("department", department);
        return "createUpdateDepartment";
    }

    @RequestMapping(value = "/createUpdate", method = RequestMethod.POST)
    public String createUpdateDepartment(Department department, Map<String, Object> model) {
        departmentDao.update(department);
        return "redirect:/";
    }

}


