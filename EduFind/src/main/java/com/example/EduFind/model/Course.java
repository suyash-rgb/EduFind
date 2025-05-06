package com.example.EduFind.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;
    private String courseName;
    private Integer price;
    private Integer seats;
    private Integer filledSeats;

    @Lob
    private byte[] brochureData;

    @ManyToOne
    @JoinColumn(name = "instituteID", nullable = false)
    private Institute institute;

    @OneToMany(mappedBy = "admissionRequestCourse", cascade = CascadeType.ALL)
    private List<Student> admissionRequests;


}