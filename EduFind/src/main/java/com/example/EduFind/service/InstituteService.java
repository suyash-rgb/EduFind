package com.example.EduFind.service;


import com.example.EduFind.DTOs.InstituteRegistrationDTO;
import com.example.EduFind.model.Admin;
import com.example.EduFind.model.Institute;
import com.example.EduFind.repository.InstituteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    public String registerInstitute(InstituteRegistrationDTO request) {
        Institute institute = new Institute();
        institute.setInstituteID(request.getInstituteID());
        institute.setInstituteName(request.getInstituteName());
        institute.setInstituteEmail(request.getInstituteEmail());
        institute.setInstitutePassword(request.getInstitutePassword()); // Hash password in real system
        institute.setAddress(request.getAddress());
        institute.setIsTrialActive(true);
        institute.setTokenExpiry(LocalDate.now().plusDays(30)); // Set 30-day
        institute.setIsSubscribed(false);
        institute.setApprovedByAdmin(null); // Not approved yet
        institute.setStartDate(request.getStartDate() != null ? request.getStartDate() : LocalDate.now());  // ✅ Fallback value

        instituteRepository.save(institute);
        return "Institute registration request submitted for approval.";
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
