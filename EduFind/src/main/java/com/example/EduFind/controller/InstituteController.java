package com.example.EduFind.controller;

import com.example.EduFind.DTOs.InstituteRegistrationDTO;
import com.example.EduFind.service.InstituteService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PermitAll
    @PostMapping("/register")
    public ResponseEntity<String> registerInstitute(@RequestBody InstituteRegistrationDTO request) {
        return ResponseEntity.ok(instituteService.registerInstitute(request));
    }

    @GetMapping("/admin/pending-institutes")
    public ResponseEntity<List<?>> getPendingInstitutes() {
        return ResponseEntity.ok(instituteService.getPendingInstitutes());
    }

    @PutMapping("/admin/approve/{instituteID}/{adminID}")
    public ResponseEntity<String> approveInstitute(@PathVariable String instituteID, @PathVariable String adminID) {
        return ResponseEntity.ok(instituteService.approveInstitute(instituteID, adminID));
    }



}
