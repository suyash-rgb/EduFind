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
        institute.setAddress(instituteRegistrationDTO.getAddress());

        // Determine subscription status
        if (Boolean.TRUE.equals(instituteRegistrationDTO.getIsTrialActive()) || instituteRegistrationDTO.getIsTrialActive() == null) {
            institute.setIsTrialActive(true);
            institute.setTokenExpiry(LocalDate.now().plusDays(15)); // Free trial
        } else {
            institute.setIsTrialActive(false);
            institute.setTokenExpiry(LocalDate.now().plusYears(1)); // Paid subscription
        }

        instituteRepository.save(institute);
        return "Registration successful! " +
                (institute.getIsTrialActive() ? "Free trial activated for 15 days." : "Subscription activated for 1 year.");
    }

}
