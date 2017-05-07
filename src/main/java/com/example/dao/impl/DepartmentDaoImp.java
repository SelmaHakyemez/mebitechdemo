package com.example.dao.impl;

import com.example.dao.DepartmentDao;
import com.example.model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Selma on 07.05.2017.
 */
@Repository
@Transactional
public class DepartmentDaoImp implements DepartmentDao {

    private SessionFactory sessionFactory;

    @Autowired
    public DepartmentDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){return sessionFactory.getCurrentSession();}

    @Override
    public List<Department> getAll() {
        Query query=getSession().createSQLQuery("SELECT * FROM DEPARTMENT_TABLE");
        List<Department> result = query.list();
        return result;
    }

    @Override
    public Department findById(Integer departmentId) {
        return (Department) getSession().load(Department.class, departmentId);
    }

    @Override
    public void create(Department department) {
        getSession().saveOrUpdate(department);
    }

    @Override
    public void update(Department department) {
        getSession().saveOrUpdate(department);
    }

    @Override
    public void delete(Department department) {
        getSession().delete(department);
    }
}
