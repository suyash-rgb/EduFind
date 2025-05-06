package com.example.EduFind.DTOs;

import java.time.LocalDate;

public class InstituteRegistrationDTO {
    private String instituteName;
    private String instituteEmail;
    private String institutePassword;
    private String address;
    private Boolean isTrialActive; // Optional flag
    private LocalDate tokenExpiry; // Optional expiry date

    // Getters & Setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsTrialActive() {
        return isTrialActive;
    }

    public void setIsTrialActive(Boolean trialActive) {
        isTrialActive = trialActive;
    }

    public LocalDate getTokenExpiry() {
        return tokenExpiry;
    }

    public void setTokenExpiry(LocalDate tokenExpiry) {
        this.tokenExpiry = tokenExpiry;
    }
}
