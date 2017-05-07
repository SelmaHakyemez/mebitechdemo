package com.example.dao;

import com.example.model.Meeting;

import java.util.List;

/**
 * Created by Selma on 07.05.2017.
 */
public interface MeetingDao {

    List<Meeting> getAll();
    Meeting findById(Integer MeetingId);
    void create(Meeting Meeting);
    void update(Meeting Meeting);
    void delete(Meeting Meeting);
}
