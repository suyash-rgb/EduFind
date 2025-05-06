package com.example.EduFind.repository;

import com.example.EduFind.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByInstitute_InstituteID(String instituteID);

}
