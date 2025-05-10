package com.example.EduFind.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "userID")
    private String userID;

    @Column(name = "emailID", unique = true, nullable = false)
    private String emailID;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "studentPassword")
    private String studentPassword;

    @Column(name = "number")
    private String number;

    @Column(name = "role", nullable = false)
    private String role = "STUDENT";

    @Column(name = "jwtRefreshToken")
    private String jwtRefreshToken;

    @Column(name = "tokenExpiry")
    private LocalDate tokenExpiry;  // Changed from Timestamp to LocalDate

    @ManyToOne
    @JoinColumn(name = "admissionRequestCourseID", referencedColumnName = "courseID")
    private Course admissionRequestCourse;

    @ManyToOne
    @JoinColumn(name = "admissionRequestInstituteID", referencedColumnName = "instituteID")
    private Institute admissionRequestInstitute;

    @Column(name = "admissionRequestDate")
    private LocalDate admissionRequestDate;

    @Column(name = "admissionRequestStatus", nullable = false)
    private Boolean admissionRequestStatus = false;

    @Column(name = "admissionRequestRejected", nullable = false)
    private Boolean admissionRequestRejected = false;


    public Student() {
    }

    public Student(String userID, String emailID, String studentName, String qualification, String studentPassword, String number, String jwtRefreshToken, LocalDate tokenExpiry, Course admissionRequestCourse, Institute admissionRequestInstitute, LocalDate admissionRequestDate, Boolean admissionRequestStatus, Boolean admissionRequestRejected) {
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

    public LocalDate getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(LocalDate tokenExpiry) {
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