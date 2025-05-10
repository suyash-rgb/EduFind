package com.example.EduFind.controller;

import com.example.EduFind.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class  AdminController {


    @Autowired
    private AdminService adminService;

    @GetMapping("/pending-institutes")
    public ResponseEntity<List<?>> getPendingInstitutes() {
        return ResponseEntity.ok(adminService.getPendingInstitutes());
    }

    @PutMapping("/approve/{instituteID}/{adminID}")
    public ResponseEntity<String> approveInstitute(@PathVariable String instituteID, @PathVariable String adminID) {
        return ResponseEntity.ok(adminService.approveInstitute(instituteID, adminID));
    }
}
