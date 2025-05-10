package com.example.EduFind.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @Column(name = "adminID")
    private String adminID;

    @Column(unique = true, nullable = false)
    private String adminEmail;

    @Column(name = "adminPassword", nullable = false)
    private String adminPassword;

    @Column(nullable = false)
    private String role = "SUPER_ADMIN";

    @OneToMany(mappedBy = "approvedByAdmin", cascade = CascadeType.ALL)
    private List<Institute> approvedInstitutes;

    public Admin() {
    }

    public Admin(String adminID) {
        this.adminID = adminID;
    }

    public Admin(String adminID, String adminEmail, String adminPassword, String role, List<Institute> approvedInstitutes) {
        this.adminID = adminID;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.role = role;
        this.approvedInstitutes = approvedInstitutes;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Institute> getApprovedInstitutes() {
        return approvedInstitutes;
    }

    public void setApprovedInstitutes(List<Institute> approvedInstitutes) {
        this.approvedInstitutes = approvedInstitutes;
    }
}
