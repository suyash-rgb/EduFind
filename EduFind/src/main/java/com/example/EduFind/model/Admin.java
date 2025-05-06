package com.example.EduFind.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    private String adminID;

    private String adminPassword;

    private Timestamp tokenExpiry;

    public Admin(){

    }

    public Admin(String adminID, String adminPassword, Timestamp tokenExpiry) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
        this.tokenExpiry = tokenExpiry;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Timestamp getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(Timestamp tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }
}
