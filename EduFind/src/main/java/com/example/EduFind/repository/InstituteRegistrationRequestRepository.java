package com.example.EduFind.repository;

import com.example.EduFind.model.InstituteRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstituteRegistrationRequestRepository extends JpaRepository<InstituteRegistrationRequest, Integer> {

    // Fetch all pending registration requests (status = null)
    List<InstituteRegistrationRequest> findByStatusIsNull();
}
