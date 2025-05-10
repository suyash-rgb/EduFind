package com.example.EduFind.repository;

import com.example.EduFind.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRoles, Integer> {
    //List<UserRoles> findByStudent_UserID(String userID);
    //List<UserRoles> findByInstitute_InstituteID(String instituteID);
    //List<UserRoles> findByAdmin_AdminID(String adminID);

    List<UserRoles> findByInstituteID(String instituteID);

    @Query("SELECT ur.role FROM UserRoles ur WHERE ur.instituteID = :instituteID")
    String findRoleByInstituteID(@Param("instituteID") String instituteID);
}
