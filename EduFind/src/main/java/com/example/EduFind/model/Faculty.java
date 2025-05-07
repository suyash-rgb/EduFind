package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facultyID")
    private Integer facultyID;

    @Column(name = "facultyName")
    private String facultyName;

    @ManyToOne
    @JoinColumn(name = "instituteID", referencedColumnName = "instituteID", nullable = false)
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "courseID", referencedColumnName = "courseID", nullable = false)
    private Course course;

    public Faculty() {
    }

    public Faculty(Integer facultyID, String facultyName, Institute institute, Course course) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
        this.institute = institute;
        this.course = course;
    }

    public Integer getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
