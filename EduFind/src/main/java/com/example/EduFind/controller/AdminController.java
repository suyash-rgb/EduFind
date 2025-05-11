package com.example.EduFind.controller;

import com.example.EduFind.jwt.JwtAuthenticationRequest;
import com.example.EduFind.jwt.JwtAuthenticationResponse;
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

    @PostMapping("/public/login")
    public ResponseEntity<JwtAuthenticationResponse> loginAdmin(@RequestBody JwtAuthenticationRequest request){
        JwtAuthenticationResponse response = adminService.authenticateAdmin(request.getUsername(), request.getPassword());

        if(response.getToken()!=null){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.status(401).body(new JwtAuthenticationResponse(null, null, null, "Invalid Credentials"));
        }
    }

    @GetMapping("/protected/pending-institutes")
    public ResponseEntity<List<?>> getPendingInstitutes() {
        return ResponseEntity.ok(adminService.getPendingInstitutes());
    }

    @PutMapping("/protected/approve/{instituteID}/{adminID}")
    public ResponseEntity<String> approveInstitute(@PathVariable String instituteID, @PathVariable String adminID) {
        return ResponseEntity.ok(adminService.approveInstitute(instituteID, adminID));
    }
}
