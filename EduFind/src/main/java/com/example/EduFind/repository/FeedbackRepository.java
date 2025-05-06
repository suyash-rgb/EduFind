package com.example.EduFind.repository;

import com.example.EduFind.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByInstitute_InstituteID(String instituteID);
}
