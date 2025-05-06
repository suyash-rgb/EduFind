package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "instituteID")
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "adminID")
    private Admin admin;

    @Column(nullable = false)
    private String role;

    // Getters and Setters
}