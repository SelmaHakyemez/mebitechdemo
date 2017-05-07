package com.example.dao.impl;

import com.example.dao.MeetingDao;
import com.example.model.Meeting;
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
public class MeetingDaoImp implements MeetingDao {

    private SessionFactory sessionFactory;

    @Autowired
    public MeetingDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Meeting> getAll() {
        Query query = getSession().createSQLQuery("SELECT * FROM MEETING_TABLE");
        List<Meeting> result = query.list();
        return result;
    }

    @Override
    public Meeting findById(Integer MeetingId) {
        return (Meeting) getSession().load(Meeting.class, MeetingId);
    }

    @Override
    public void create(Meeting Meeting) {
        getSession().saveOrUpdate(Meeting);
    }

    @Override
    public void update(Meeting Meeting) {
        getSession().saveOrUpdate(Meeting);
    }

    @Override
    public void delete(Meeting Meeting) {
        getSession().delete(Meeting);
    }
}
