package com.example.EduFind.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    private String adminID;

    @Column(unique = true, nullable = false)
    private String adminEmail;
    private String adminPassword;

    @Column(nullable = false)
    private String role = "SUPER_ADMIN";

    @OneToMany(mappedBy = "approvedByAdmin", cascade = CascadeType.ALL)
    private List<Institute> approvedInstitutes;

}
