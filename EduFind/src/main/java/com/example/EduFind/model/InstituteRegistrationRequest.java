package com.example.EduFind.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class InstituteRegistrationRequest {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer requestID;

        private String instituteName;
        private String instituteEmail;
        private String institutePassword; // This should be hashed before storing
        @Column
        private Boolean status; // NULL = Pending, TRUE = Approved, FALSE = Denied

        @Temporal(TemporalType.DATE)
        @Column(nullable = false)
        private Date requestDate;

        public InstituteRegistrationRequest(){}

        public InstituteRegistrationRequest(Integer requestID, String instituteName, String instituteEmail, String institutePassword, Boolean status, Date requestDate) {
                this.requestID = requestID;
                this.instituteName = instituteName;
                this.instituteEmail = instituteEmail;
                this.institutePassword = institutePassword;
                this.status = status;
                this.requestDate = requestDate;
        }

        public Integer getRequestID() {
                return requestID;
        }

        public void setRequestID(Integer requestID) {
                this.requestID = requestID;
        }

        public String getInstituteName() {
                return instituteName;
        }

        public void setInstituteName(String instituteName) {
                this.instituteName = instituteName;
        }

        public String getInstituteEmail() {
                return instituteEmail;
        }

        public void setInstituteEmail(String instituteEmail) {
                this.instituteEmail = instituteEmail;
        }

        public String getInstitutePassword() {
                return institutePassword;
        }

        public void setInstitutePassword(String institutePassword) {
                this.institutePassword = institutePassword;
        }

        public Boolean getStatus() {
                return status;
        }

        public void setStatus(Boolean status) {
                this.status = status;
        }

        public Date getRequestDate() {
                return requestDate;
        }

        public void setRequestDate(Date requestDate) {
                this.requestDate = requestDate;
        }
}

