package com.example.EduFind.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class InstituteRegistrationDTO {

    private String instituteID;
    private String instituteName;
    private String instituteEmail;
    private String institutePassword;
    private String address;
    private Boolean isTrialActive;
    private Boolean isSubscribed;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    public String getInstituteID() {
        return instituteID;
    }

    public void setInstituteID(String instituteID) {
        this.instituteID = instituteID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getTrialActive() {
        return isTrialActive;
    }

    public void setTrialActive(Boolean trialActive) {
        isTrialActive = trialActive;
    }

    public Boolean getSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        isSubscribed = subscribed;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
