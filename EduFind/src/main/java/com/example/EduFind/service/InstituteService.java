package com.example.EduFind.service;

import com.example.EduFind.DTOs.InstituteRegistrationDTO;
import com.example.EduFind.model.Institute;
import com.example.EduFind.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerInstitute(InstituteRegistrationDTO instituteRegistrationDTO) {
        Institute institute = new Institute();
        institute.setInstituteName(instituteRegistrationDTO.getInstituteName());
        institute.setInstituteEmail(instituteRegistrationDTO.getInstituteEmail());
        institute.setInstitutePassword(passwordEncoder.encode(instituteRegistrationDTO.getInstitutePassword())); // Hash Password

        // Enable free trial
        institute.setStartDate(LocalDate.now());
        institute.setTokenExpiry(LocalDate.now().plusDays(15)); // Free trial period
        institute.setIsTrialActive(true);

        instituteRepository.save(institute);
        return "Registration successful! Free trial activated for 15 days.";
    }

}
