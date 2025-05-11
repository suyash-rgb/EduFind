package com.example.EduFind.service;

import com.example.EduFind.jwt.JwtAuthenticationResponse;
import com.example.EduFind.jwt.JwtUtils;
import com.example.EduFind.model.Admin;
import com.example.EduFind.model.Institute;
import com.example.EduFind.repository.AdminRepository;
import com.example.EduFind.repository.InstituteRepository;
import com.example.EduFind.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public JwtAuthenticationResponse authenticateAdmin(String username, String password) {
        Optional<Admin> adminOptional = adminRepository.findByAdminEmail(username);

        if (adminOptional.isEmpty()) {
            return new JwtAuthenticationResponse(null, null, null, "Admin not found");
        }

        Admin admin = adminOptional.get();

        if (!passwordEncoder.matches(password, admin.getAdminPassword())) {
            return new JwtAuthenticationResponse(null, null, null, "Invalid credentials");
        }

        // ✅ Fetch Admin role from `user_roles`
        String role = userRolesRepository.findRoleByAdminID(admin.getAdminID());

        // ✅ Generate JWT with Admin ID & Role
        String token = jwtUtils.generateToken(admin.getAdminID(), role);

        return new JwtAuthenticationResponse(token, admin.getAdminID(), role, "Login successful!");
    }


    public List<Institute> getPendingInstitutes() {
        return instituteRepository.findByApprovedByAdminIsNull(); //yet to create
    }

    public String approveInstitute(String instituteID, String adminID) {
        Institute institute = instituteRepository.findById(instituteID)
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        institute.setApprovedByAdmin(new Admin(adminID));
        instituteRepository.save(institute);

        return "Institute approved successfully.";
    }
}
