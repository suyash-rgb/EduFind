package com.example.EduFind.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
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

    private LocalDate admissionRequestDate;
    private Boolean admissionRequestStatus = false;
    private Boolean admissionRequestRejected = false;

    public Student() {
    }

    public Student(String userID, String emailID, String studentName, String qualification, String studentPassword, String number, String jwtRefreshToken, Timestamp tokenExpiry, Course admissionRequestCourse, Institute admissionRequestInstitute, LocalDate admissionRequestDate, Boolean admissionRequestStatus, Boolean admissionRequestRejected) {
        this.userID = userID;
        this.emailID = emailID;
        this.studentName = studentName;
        this.qualification = qualification;
        this.studentPassword = studentPassword;
        this.number = number;
        this.jwtRefreshToken = jwtRefreshToken;
        this.tokenExpiry = tokenExpiry;
        this.admissionRequestCourse = admissionRequestCourse;
        this.admissionRequestInstitute = admissionRequestInstitute;
        this.admissionRequestDate = admissionRequestDate;
        this.admissionRequestStatus = admissionRequestStatus;
        this.admissionRequestRejected = admissionRequestRejected;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getJwtRefreshToken() {
        return jwtRefreshToken;
    }

    public void setJwtRefreshToken(String jwtRefreshToken) {
        this.jwtRefreshToken = jwtRefreshToken;
    }

    public Timestamp getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(Timestamp tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }

    public Course getAdmissionRequestCourse() {
        return admissionRequestCourse;
    }

    public void setAdmissionRequestCourse(Course admissionRequestCourse) {
        this.admissionRequestCourse = admissionRequestCourse;
    }

    public Institute getAdmissionRequestInstitute() {
        return admissionRequestInstitute;
    }

    public void setAdmissionRequestInstitute(Institute admissionRequestInstitute) {
        this.admissionRequestInstitute = admissionRequestInstitute;
    }

    public LocalDate getAdmissionRequestDate() {
        return admissionRequestDate;
    }

    public void setAdmissionRequestDate(LocalDate admissionRequestDate) {
        this.admissionRequestDate = admissionRequestDate;
    }

    public Boolean getAdmissionRequestStatus() {
        return admissionRequestStatus;
    }

    public void setAdmissionRequestStatus(Boolean admissionRequestStatus) {
        this.admissionRequestStatus = admissionRequestStatus;
    }

    public Boolean getAdmissionRequestRejected() {
        return admissionRequestRejected;
    }

    public void setAdmissionRequestRejected(Boolean admissionRequestRejected) {
        this.admissionRequestRejected = admissionRequestRejected;
    }
}