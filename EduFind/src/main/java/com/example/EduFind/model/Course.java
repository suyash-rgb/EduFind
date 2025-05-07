package com.example.EduFind.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseID")
    private Integer courseID;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "filledSeats")
    private Integer filledSeats;

    @Lob
    @Column(name = "brochureData")
    private byte[] brochureData;

    @ManyToOne
    @JoinColumn(name = "instituteID", nullable = false)

    private Institute institute;

    @OneToMany(mappedBy = "admissionRequestCourse", cascade = CascadeType.ALL)
    private List<Student> admissionRequests;

    public Course() {
    }

    public Course(Integer courseID, String courseName, Integer price, Integer seats, Integer filledSeats, byte[] brochureData, Institute institute, List<Student> admissionRequests) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.price = price;
        this.seats = seats;
        this.filledSeats = filledSeats;
        this.brochureData = brochureData;
        this.institute = institute;
        this.admissionRequests = admissionRequests;
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getFilledSeats() {
        return filledSeats;
    }

    public void setFilledSeats(Integer filledSeats) {
        this.filledSeats = filledSeats;
    }

    public byte[] getBrochureData() {
        return brochureData;
    }

    public void setBrochureData(byte[] brochureData) {
        this.brochureData = brochureData;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public List<Student> getAdmissionRequests() {
        return admissionRequests;
    }

    public void setAdmissionRequests(List<Student> admissionRequests) {
        this.admissionRequests = admissionRequests;
    }
}