package com.example.EduFind.controller;

import com.example.EduFind.DTOs.InstituteRegistrationDTO;
import com.example.EduFind.jwt.JwtAuthenticationRequest;
import com.example.EduFind.jwt.JwtAuthenticationResponse;
import com.example.EduFind.model.Institute;
import com.example.EduFind.service.InstituteService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PostMapping("/public/register")
    public ResponseEntity<String> registerInstitute(@RequestBody InstituteRegistrationDTO request) {
        System.out.println("Received startDate: " + request.getStartDate());
        return ResponseEntity.ok(instituteService.registerInstitute(request));
    }

    @PostMapping("/public/login")
    public ResponseEntity<JwtAuthenticationResponse> loginInstitute(@RequestBody JwtAuthenticationRequest request) {
        JwtAuthenticationResponse response = instituteService.authenticateInstitute(request.getUsername(), request.getPassword());

        if (response.getToken() != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(new JwtAuthenticationResponse(null, null, null, "Invalid credentials"));
        }
    }




}
