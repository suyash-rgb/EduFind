package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facultyID;
    private String facultyName;

    @ManyToOne
    @JoinColumn(name = "instituteID", nullable = false)
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

}
