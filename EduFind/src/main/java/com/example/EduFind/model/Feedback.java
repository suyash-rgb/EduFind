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

}
