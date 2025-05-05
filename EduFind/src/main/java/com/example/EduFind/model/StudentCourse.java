package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course course;

    public StudentCourse(){}

    public StudentCourse(Integer id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
