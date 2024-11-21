package com.AvirantEnterprises.InfoCollector_AE.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    private String email;  // Add this field for the email

    // Additional fields for form data (optional)
    private String formType;
    private String formData;

    // Default constructor
    public User() {
    }

    // Constructor to initialize username, password, role, and email
    public User(String username, String password, String role, String email) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    // Getters and Setters for ID, username, password, role, and email
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;  // Get email
    }

    public void setEmail(String email) {
        this.email = email;  // Set email
    }

    // Getters and Setters for formType and formData (optional)
    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }
}
