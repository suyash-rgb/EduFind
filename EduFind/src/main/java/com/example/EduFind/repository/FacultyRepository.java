package com.example.EduFind.repository;

import com.example.EduFind.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    List<Faculty> findByInstitute_InstituteID(String instituteID);
}
