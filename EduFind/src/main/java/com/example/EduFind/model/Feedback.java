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
    @JoinColumn(name = "instituteID", nullable = false)
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    private Student student;

    private int rating;
    private String comments;

    public Feedback() {
    }

    public Feedback(Integer feedbackID, Institute institute, Student student, int rating, String comments) {
        this.feedbackID = feedbackID;
        this.institute = institute;
        this.student = student;
        this.rating = rating;
        this.comments = comments;
    }

    public Integer getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(Integer feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
