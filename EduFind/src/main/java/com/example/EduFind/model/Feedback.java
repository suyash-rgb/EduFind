package com.example.EduFind.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer feedbackID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "instituteID")
    private Institute institute;

    private String description;
    private Date feedbackDate;

    public Feedback(){

    }

    public Feedback(Integer feedbackID, Student student, Institute institute, String description, Date feedbackDate) {
        this.feedbackID = feedbackID;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
