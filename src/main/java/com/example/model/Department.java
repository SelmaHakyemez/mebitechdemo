package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Selma on 07.05.2017.
 */
@Entity
@Table(name = "DEPARTMENT_TABLE")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false,name = "departmentId")
    private Integer departmentId;
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employees;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Meeting> meetings;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }
}
