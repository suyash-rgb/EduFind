package com.example.EduFind.service;


import com.example.EduFind.DTOs.InstituteRegistrationDTO;
import com.example.EduFind.jwt.JwtAuthenticationResponse;
import com.example.EduFind.jwt.JwtUtils;
import com.example.EduFind.model.Admin;
import com.example.EduFind.model.Institute;
import com.example.EduFind.model.UserRoles;
import com.example.EduFind.repository.InstituteRepository;
import com.example.EduFind.repository.UserRolesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    public String registerInstitute(InstituteRegistrationDTO request) {
        Institute institute = new Institute();
        institute.setInstituteID(request.getInstituteID());
        institute.setInstituteName(request.getInstituteName());
        institute.setInstituteEmail(request.getInstituteEmail());
        institute.setInstitutePassword(passwordEncoder.encode(request.getInstitutePassword())); // Hashing while entering passwords
        institute.setAddress(request.getAddress());
        institute.setIsTrialActive(true);
        institute.setTokenExpiry(LocalDate.now().plusDays(30)); // Set 30-day
        institute.setIsSubscribed(false);
        institute.setApprovedByAdmin(null); // Not approved yet
        institute.setStartDate(request.getStartDate() != null ? request.getStartDate() : LocalDate.now());  // ✅ Fallback value

        instituteRepository.save(institute);

        // ✅ Assign Default Role in `user_roles`
        UserRoles userRole = new UserRoles();
        userRole.setInstituteID(institute.getInstituteID());
        userRole.setRole("INSTITUTE_ADMIN");  // Default role for new institutes
        userRolesRepository.save(userRole);
        return "Institute registration request submitted for approval.";
    }

    public JwtAuthenticationResponse authenticateInstitute(String username, String password) {
        // ✅ Validate Institute Credentials
        Institute institute = instituteRepository.findByInstituteName(username) //bug fix
                .orElseThrow(() -> new RuntimeException("Institute not found"));

        if (!passwordEncoder.matches(password, institute.getInstitutePassword())) {
            return new JwtAuthenticationResponse(null, null, null, "Invalid credentials");
        }

        // ✅ Fetch Role from `user_roles`
        String role = userRolesRepository.findRoleByInstituteID(institute.getInstituteID());

        // ✅ Generate JWT with Institute ID & Role
        String token = jwtUtils.generateToken(institute.getInstituteID(), role);

        return new JwtAuthenticationResponse(token, institute.getInstituteID(), role, "Login successful!");
    }


}
