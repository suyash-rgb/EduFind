package com.example.EduFind.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "institute")
public class Institute {

    @Id
    private String instituteID;

    @Column(unique = true, nullable = false)
    private String instituteEmail;

    private String instituteName;
    private String institutePassword;
    private LocalDate startDate;
    private String address;
    private String jwtRefreshToken;
    private LocalDate tokenExpiry;
    private Boolean isTrialActive = true;

    @Lob
    private byte[] imageData;

    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToMany(mappedBy = "admissionRequestInstitute", cascade = CascadeType.ALL)
    private List<Student> admissionRequests;

    @ManyToOne
    @JoinColumn(name = "approvedByAdminID")
    private Admin approvedByAdmin;

}