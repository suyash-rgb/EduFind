package com.example.EduFind.service;

import com.example.EduFind.model.Admin;
import com.example.EduFind.model.Institute;
import com.example.EduFind.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private InstituteRepository instituteRepository;

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
