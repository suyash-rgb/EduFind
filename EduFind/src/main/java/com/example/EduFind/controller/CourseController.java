package com.example.EduFind.controller;

import com.example.EduFind.DTOs.CourseDTO;
import com.example.EduFind.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCourse(@RequestBody CourseDTO courseDTO) {
        courseService.registerCourse(courseDTO);
        return ResponseEntity.ok("Course registered successfully!");
    }

    @PostMapping(value = "/uploadBrochure", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadBrochure(
            @RequestParam("courseID") Integer courseID,
            @RequestParam("brochureFile") MultipartFile brochureFile) {

        courseService.uploadBrochure(courseID, brochureFile);
        return ResponseEntity.ok("Brochure uploaded successfully!");
    }

    @PostMapping("/updateSeatsFilled")
    public ResponseEntity<String> updateSeatsFilled(
            @RequestParam("courseID") Integer courseID,
            @RequestParam("filledSeats") Integer filledSeats){

        courseService.updateSeatsFilled(courseID, filledSeats);
        return ResponseEntity.ok("Filled Seats Count updated successfully!");
    }

}
