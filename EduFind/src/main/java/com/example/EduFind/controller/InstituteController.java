package com.example.EduFind.controller;

import com.example.EduFind.DTOs.InstituteRegistrationDTO;
import com.example.EduFind.model.Institute;
import com.example.EduFind.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PostMapping("/register")
    public ResponseEntity<String> registerInstitute(@RequestBody InstituteRegistrationDTO instituteRegistrationDTO) {
        String response = instituteService.registerInstitute(instituteRegistrationDTO);
        return ResponseEntity.ok(response);
    }


}
