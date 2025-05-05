package com.example.EduFind.repository;

import com.example.EduFind.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findCourseByCourseName();
    List<Course> findCoursesByPriceLessThan(Integer price);
    // Search courses within a price range
    List<Course> findByPriceBetween(Integer minPrice, Integer maxPrice);

    // Find courses offered by a specific institute
    List<Course> findByInstituteID(String instituteID);

    List<Course> findCoursesByInstitute(String instituteName);
    List<Course> findCoursesBySeatsNotEmpty();

}
