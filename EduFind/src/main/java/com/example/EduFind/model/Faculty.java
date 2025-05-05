package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facultyID;

    private String facultyName;

    @ManyToOne
    @JoinColumn(name = "instituteID")
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;

    @Lob
    @Column
    private byte[] faculty_image;

    public Faculty(){}

    public Faculty(Integer facultyID, String facultyName, Institute institute, Course course, byte[] faculty_image) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
        this.institute = institute;
        this.course = course;
        this.faculty_image = faculty_image;
    }
}
