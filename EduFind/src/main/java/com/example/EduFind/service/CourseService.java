package com.example.EduFind.service;

import com.example.EduFind.DTOs.CourseDTO;
import com.example.EduFind.model.Course;
import com.example.EduFind.model.Institute;
import com.example.EduFind.repository.CourseRepository;
import com.example.EduFind.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstituteRepository instituteRepository;

    public void registerCourse(CourseDTO courseDTO) {
        // Find the related institute
        Institute institute = instituteRepository.findById(courseDTO.getInstituteID())
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        // Create new course object
        Course course = new Course();
        course.setCourseName(courseDTO.getCourseName());
        course.setPrice(courseDTO.getPrice());
        course.setSeats(courseDTO.getSeats());
        course.setInstitute(institute);

        courseRepository.save(course);
    }

    public void uploadBrochure(Integer courseID, MultipartFile brochureFile) {
        Course course = courseRepository.findById(courseID)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        try {
            course.setBrochureData(brochureFile.getBytes());
            courseRepository.save(course);
        } catch (IOException e) {
            throw new RuntimeException("File upload failed");
        }
    }
}
