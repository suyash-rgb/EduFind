package com.example.EduFind.controller;

import com.example.EduFind.DTOs.FacultyDTO;
import com.example.EduFind.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/register")
    public ResponseEntity<String> addFaculty(@RequestBody FacultyDTO facultyDTO) {
        facultyService.addFaculty(facultyDTO);
        return ResponseEntity.ok("Faculty added successfully!");
    }


}
