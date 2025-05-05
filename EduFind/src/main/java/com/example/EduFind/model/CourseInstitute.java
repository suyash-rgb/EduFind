package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
public class CourseInstitute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "instituteID")
    private Institute institute;

    public CourseInstitute(){}

    public CourseInstitute(Integer id, Course course, Institute institute) {
        this.id = id;
        this.course = course;
        this.institute = institute;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }
}
