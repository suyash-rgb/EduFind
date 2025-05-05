package com.example.EduFind.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseID;
    private String courseName;
    private Integer price;
    private Integer seats;
    private Integer filledSeats;
    @Lob
    @Column
    private byte[] brochureData;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseImages> images;

    public Course(){}

    public Course(Integer courseID, String courseName, Integer price, Integer seats, Integer filledSeats, byte[] brochureData, List<CourseImages> images) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.price = price;
        this.seats = seats;
        this.filledSeats = filledSeats;
        this.brochureData = brochureData;
        this.images = images;
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

    public List<CourseImages> getImages() {
        return images;
    }

    public void setImages(List<CourseImages> images) {
        this.images = images;
    }
}
