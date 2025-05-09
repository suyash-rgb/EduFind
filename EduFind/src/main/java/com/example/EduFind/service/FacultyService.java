package com.example.EduFind.service;

import com.example.EduFind.DTOs.FacultyDTO;
import com.example.EduFind.model.Course;
import com.example.EduFind.model.Faculty;
import com.example.EduFind.model.Institute;
import com.example.EduFind.repository.CourseRepository;
import com.example.EduFind.repository.FacultyRepository;
import com.example.EduFind.repository.InstituteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void addFaculty(FacultyDTO facultyDTO) {
        // Find the related institute
        Institute institute = instituteRepository.findById(facultyDTO.getInstituteID())
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        // Find the related course
        Course course = courseRepository.findById(facultyDTO.getCourseID())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Create new faculty object
        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyDTO.getFacultyName());
        faculty.setInstitute(institute);
        faculty.setCourse(course);

        facultyRepository.save(faculty);
    }

}
