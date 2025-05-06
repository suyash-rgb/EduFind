package com.example.EduFind.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private String userID;

    @Column(unique = true, nullable = false)
    private String emailID;
    private String studentName;
    private String qualification;
    private String studentPassword;
    private String number;
    private String jwtRefreshToken;
    private Timestamp tokenExpiry;

    @ManyToOne
    @JoinColumn(name = "admissionRequestCourseID")
    private Course admissionRequestCourse;

    @ManyToOne
    @JoinColumn(name = "admissionRequestInstituteID")
    private Institute admissionRequestInstitute;

    private Timestamp admissionRequestDate;
    private Boolean admissionRequestStatus = false;
    private Boolean admissionRequestRejected = false;

}