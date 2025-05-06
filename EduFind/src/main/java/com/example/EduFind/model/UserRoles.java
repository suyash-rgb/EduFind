package com.example.EduFind.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "instituteID")
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "adminID")
    private Admin admin;

    @Column(nullable = false)
    private String role;

    public UserRoles() {
    }

    public UserRoles(Integer id, Student student, Institute institute, Admin admin, String role) {
        this.id = id;
        this.student = student;
        this.institute = institute;
        this.admin = admin;
        this.role = role;
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

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}