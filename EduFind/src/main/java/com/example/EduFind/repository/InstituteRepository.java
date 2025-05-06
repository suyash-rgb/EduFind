package com.example.EduFind.repository;

import com.example.EduFind.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute, String> {

    // Fetch all institutes with expired subscriptions
    List<Institute> findByTokenExpiryBefore(Date currentDate);

    // Remove inactive/expired institutes
    // (Handled by JPA's delete method, e.g., deleteById)
}
