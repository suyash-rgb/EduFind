package com.example.EduFind.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Entity
public class Student {

    @Id
    private String userID;
    private String emailID;
    private String studentName;
    private String qualification;
    private String studentPassword;
    private String number;
    //private String address;
    private String jwtRefreshToken;

    public Student(){

    }

    public Student(String userID, String emailID, String studentName, String qualification, String studentPassword, String number, String address, String jwtRefreshToken) {
        this.userID = userID;
        this.emailID = emailID;
        this.studentName = studentName;
        this.qualification = qualification;
        this.studentPassword = studentPassword;
        this.number = number;
        //this.address = address;
        this.jwtRefreshToken = jwtRefreshToken;
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

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getJwtRefreshToken() {
        return jwtRefreshToken;
    }

    public void setJwtRefreshToken(String jwtRefreshToken) {
        this.jwtRefreshToken = jwtRefreshToken;
    }
}
