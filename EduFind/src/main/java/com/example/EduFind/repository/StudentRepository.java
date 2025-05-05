package com.example.EduFind.repository;

import com.example.EduFind.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {

    // Fetch a student by email for login
    Optional<Student> findByEmailID(String emailID);

    // Check if a student with a given email exists
    boolean existsByEmailID(String emailID);
}
