package com.example.EduFind.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDateTime;

@Entity
public class InstituteImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageID;

    @ManyToOne
    @JoinColumn(name = "instituteID", nullable = false)
    private Institute institute;

    @Lob
    @Column(nullable = false)
    private byte[] imageData;

    private LocalDateTime uploadDate;

    public InstituteImages(){}

    public InstituteImages(Integer imageID, Institute institute, byte[] imageData, LocalDateTime uploadDate) {
        this.imageID = imageID;
        this.institute = institute;
        this.imageData = imageData;
        this.uploadDate = uploadDate;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
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
