package com.example.EduFind.repository;

import com.example.EduFind.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
    List<UserRoles> findByStudent_UserID(String userID);
    List<UserRoles> findByInstitute_InstituteID(String instituteID);
    List<UserRoles> findByAdmin_AdminID(String adminID);

}
