package com.example.EduFind.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "institute")
public class Institute {

    @Id
    private String instituteID;
    private String instituteName;
    private String instituteEmail; // Added this field
    private String institutePassword;
    private Date startDate;
    private String address;
    private String jwtRefreshToken;
    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL)
    private List<InstituteImages> images;
    private Timestamp tokenExpiry;

    public Institute(){}

    public Institute(String instituteID, String instituteName, String instituteEmail, String institutePassword, Date startDate, String address, String jwtRefreshToken, List<InstituteImages> images, Timestamp tokenExpiry) {
        this.instituteID = instituteID;
        this.instituteName = instituteName;
        this.instituteEmail = instituteEmail;
        this.institutePassword = institutePassword;
        this.startDate = startDate;
        this.address = address;
        this.jwtRefreshToken = jwtRefreshToken;
        this.images = images;
        this.tokenExpiry = tokenExpiry;
    }

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteEmail() {
        return instituteEmail;
    }

    public void setInstituteEmail(String instituteEmail) {
        this.instituteEmail = instituteEmail;
    }

    public String getInstitutePassword() {
        return institutePassword;
    }

    public void setInstitutePassword(String institutePassword) {
        this.institutePassword = institutePassword;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJwtRefreshToken() {
        return jwtRefreshToken;
    }

    public void setJwtRefreshToken(String jwtRefreshToken) {
        this.jwtRefreshToken = jwtRefreshToken;
    }

    public List<InstituteImages> getImages() {
        return images;
    }

    public void setImages(List<InstituteImages> images) {
        this.images = images;
    }

    public Timestamp getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(Timestamp tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }
}
