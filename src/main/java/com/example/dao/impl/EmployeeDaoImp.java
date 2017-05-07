package com.example.dao.impl;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Selma on 07.05.2017.
 */
@Component
@Transactional
public class EmployeeDaoImp implements EmployeeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){return sessionFactory.getCurrentSession();}

    @Override
    public List<Employee> getAll() {
        Query query=getSession().createSQLQuery("SELECT * FROM EMPLOYEE_TABLE");
        List<Employee> result = query.list();
        return result;
    }

    @Override
    public Employee findById(Integer EmployeeId) {
        return (Employee) getSession().load(Employee.class,EmployeeId);
    }


    @Override
    public void create(Employee Employee) {
        getSession().saveOrUpdate(Employee);
    }

    @Override
    public void update(Employee Employee) {
        getSession().saveOrUpdate(Employee);
    }

    @Override
    public void delete(Employee Employee) {
        getSession().delete(Employee);
    }
}
