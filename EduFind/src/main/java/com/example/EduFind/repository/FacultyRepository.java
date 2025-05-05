package com.example.EduFind.repository;

import com.example.EduFind.model.Faculty;
import com.example.EduFind.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    List<Faculty> findFacultiesByInstitute(Institute institute);
    List<Faculty> findFacultiesByCourseID(Integer courseID);



}
