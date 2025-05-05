package com.example.EduFind.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Student Student;

    @ManyToOne
    @JoinColumn(name = "instituteID")
    private Institute institute;

    private String description;
    private Date feedbackDate;

    public Feedback(){

    }

    public Feedback(Integer feedbackID, com.example.EduFind.model.Student student, Institute institute, String description, Date feedbackDate) {
        this.feedbackID = feedbackID;
        Student = student;
        this.institute = institute;
        this.description = description;
        this.feedbackDate = feedbackDate;
    }

    public Integer getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public com.example.EduFind.model.Student getStudent() {
        return Student;
    }

    public void setStudent(com.example.EduFind.model.Student student) {
        Student = student;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
