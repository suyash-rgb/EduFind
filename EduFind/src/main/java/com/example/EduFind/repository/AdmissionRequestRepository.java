package com.example.EduFind.repository;

import com.example.EduFind.model.AdmissionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdmissionRequestRepository extends JpaRepository<AdmissionRequest, Integer> {

    // Fetch all pending registration requests (status = null)
    List<AdmissionRequest> findByStatusIsNull();

    // Fetch all approved requests
    List<AdmissionRequest> findByStatusTrue();

    // Fetch all denied requests
    List<AdmissionRequest> findByStatusFalse();

    // Paginated method for all admission requests
    @Override
    Page<AdmissionRequest> findAll(Pageable pageable);
}
