package com.example.EduFind.jwt;
public class JwtAuthenticationResponse {
    private String token;
    private String entityID; // ✅ Stores userID, instituteID, or adminID
    private String role; // ✅ Stores role (STUDENT, INSTITUTE_ADMIN, etc.)
    private String message;

    public JwtAuthenticationResponse(String token, String entityID, String role, String message) {
        this.token = token;
        this.entityID = entityID;
        this.role = role;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message)  {
        this.message = message;
    }
}