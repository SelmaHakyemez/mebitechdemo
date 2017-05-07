package com.example.model;

import javax.persistence.*;

/**
 * Created by Selma on 07.05.2017.
 */
@Entity
@Table(name = "MEETING_TABLE")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer meetingId;
    @Column
    private String name;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn
    private Department department;

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
