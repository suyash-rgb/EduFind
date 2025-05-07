package com.example.EduFind.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "institute")
public class Institute {

    @Id
    @Column(name = "instituteID")
    private String instituteID;

    @Column(name = "instituteName", unique = true, nullable = false)
    private String instituteEmail;

    @Column(name = "instituteEmail")
    private String instituteName;

    @Column(name = "institutePassword")
    private String institutePassword;

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "address")
    private String address;

    @Column(name = "jwtRefreshToken")
    private String jwtRefreshToken;

    @Column(name = "tokenExpiry")
    private LocalDate tokenExpiry;

    @Column(name = "isTrialActive")
    private Boolean isTrialActive = true;

    private Boolean isSubscribed = false; // Track subscription status

    @Lob
    @Column(name = "imageData")
    private byte[] imageData;

    @OneToMany(mappedBy = "institute", cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToMany(mappedBy = "admissionRequestInstitute", cascade = CascadeType.ALL)
    private List<Student> admissionRequests;

    @ManyToOne
    @JoinColumn(name = "approvedByAdminID", referencedColumnName = "adminID")
    private Admin approvedByAdmin;

    public Institute() {
    }

    public Institute(String instituteID, String instituteEmail, String instituteName, String institutePassword, LocalDate startDate, String address, String jwtRefreshToken, LocalDate tokenExpiry, Boolean isTrialActive, Boolean isSubscribed, byte[] imageData, List<Course> courses, List<Student> admissionRequests, Admin approvedByAdmin) {
        this.instituteID = instituteID;
        this.instituteEmail = instituteEmail;
        this.instituteName = instituteName;
        this.institutePassword = institutePassword;
        this.startDate = startDate;
        this.address = address;
        this.jwtRefreshToken = jwtRefreshToken;
        this.tokenExpiry = tokenExpiry;
        this.isTrialActive = isTrialActive;
        this.isSubscribed = isSubscribed;
        this.imageData = imageData;
        this.courses = courses;
        this.admissionRequests = admissionRequests;
        this.approvedByAdmin = approvedByAdmin;
    }

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
    }

    public String getInstituteEmail() {
        return instituteEmail;
    }

    public void setInstituteEmail(String instituteEmail) {
        this.instituteEmail = instituteEmail;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstitutePassword() {
        return institutePassword;
    }

    public void setInstitutePassword(String institutePassword) {
        this.institutePassword = institutePassword;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
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

    public LocalDate getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(LocalDate tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public Boolean getIsTrialActive() {
        return isTrialActive;
    }

    public void setIsTrialActive(Boolean trialActive) {
        isTrialActive = trialActive;
    }

    public Boolean getTrialActive() {
        return isTrialActive;
    }

    public void setTrialActive(Boolean trialActive) {
        isTrialActive = trialActive;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getAdmissionRequests() {
        return admissionRequests;
    }

    public void setAdmissionRequests(List<Student> admissionRequests) {
        this.admissionRequests = admissionRequests;
    }

    public Admin getApprovedByAdmin() {
        return approvedByAdmin;
    }

    public void setApprovedByAdmin(Admin approvedByAdmin) {
        this.approvedByAdmin = approvedByAdmin;
    }
}