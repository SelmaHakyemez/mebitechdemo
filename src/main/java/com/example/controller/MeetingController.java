package com.example.controller;

import com.example.dao.MeetingDao;
import com.example.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Selma on 07.05.2017.
 */
@Controller
@RequestMapping("/meeting")
public class MeetingController {

    private MeetingDao meetingDao;

    @Autowired
    public MeetingController(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Meeting> getMeetings() {
        return meetingDao.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<Meeting> addMeeting(Meeting meeting) {
        meetingDao.create(meeting);
        return meetingDao.getAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Meeting> updateMeeting(Meeting meeting) {
        meetingDao.update(meeting);
        return meetingDao.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public List<Meeting> deleteMeeting(Meeting meeting) {
        meetingDao.delete(meeting);
        return meetingDao.getAll();
    }

}
