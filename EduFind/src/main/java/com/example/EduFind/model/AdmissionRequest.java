package com.example.EduFind.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class AdmissionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer requestID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instituteID")
    private Institute institute;
    private Date requestDate;
    private Boolean status;
    private Boolean rejected;

    public AdmissionRequest(){

    }

    public AdmissionRequest(Integer requestID, Student student, Course course, Institute institute, Date requestDate, Boolean status, Boolean rejected) {
        this.requestID = requestID;
        this.student = student;
        this.course = course;
        this.institute = institute;
        this.requestDate = requestDate;
        this.status = status;
        this.rejected = rejected;
    }

    public Integer getRequestID() {
        return requestID;
    }

    public void setRequestID(Integer requestID) {
        this.requestID = requestID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }
}
