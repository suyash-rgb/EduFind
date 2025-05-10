package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userID") // ✅ Store only ID instead of full Student object
    private String userID;

    @Column(name = "instituteID") // ✅ Store only ID instead of full Institute object
    private String instituteID;

    @Column(name = "adminID") // ✅ Store only ID instead of full Admin object
    private String adminID;

    @Column(name = "role", nullable = false)
    private String role;

    public UserRoles() {} // Default Constructor

    public UserRoles(Integer id, String userID, String instituteID, String adminID, String role) {
        this.id = id;
        this.userID = userID;
        this.instituteID = instituteID;
        this.adminID = adminID;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}