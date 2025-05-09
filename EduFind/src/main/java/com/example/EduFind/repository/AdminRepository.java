package com.example.EduFind.repository;

import com.example.EduFind.model.Admin;
import com.example.EduFind.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String> {


}
