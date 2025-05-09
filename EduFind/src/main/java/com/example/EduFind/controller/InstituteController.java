package com.example.EduFind.controller;

import com.example.EduFind.DTOs.InstituteRegistrationDTO;
import com.example.EduFind.service.InstituteService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PreAuthorize("permitAll()")
    @PostMapping("/public/register")
    public ResponseEntity<String> registerInstitute(@RequestBody InstituteRegistrationDTO request) {
        System.out.println("Received startDate: " + request.getStartDate());
        return ResponseEntity.ok(instituteService.registerInstitute(request));
    }







}
