package com.example.EduFind.repository;

import com.example.EduFind.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstituteRepository extends JpaRepository<Institute, String> {

    List<Institute> findByApprovedByAdminIsNull();

    Optional<Institute> findByInstituteEmail(String instituteEmail);

    Optional<Institute> findByInstituteName(String instituteName);
}
