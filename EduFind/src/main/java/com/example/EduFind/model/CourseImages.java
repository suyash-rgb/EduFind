package com.example.EduFind.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CourseImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageID;

    @ManyToOne
    @JoinColumn(name = "courseID", nullable = false)
    private Course course;

    @Lob
    @Column(nullable = false)
    private byte[] imageData;

    private LocalDateTime uploadDate;

    public CourseImages(){}
    public CourseImages(Integer imageID, Course course, byte[] imageData, LocalDateTime uploadDate) {
        this.imageID = imageID;
        this.course = course;
        this.imageData = imageData;
        this.uploadDate = uploadDate;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }
}
