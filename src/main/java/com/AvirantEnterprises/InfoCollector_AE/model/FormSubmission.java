package com.AvirantEnterprises.InfoCollector_AE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FormSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formType; // To distinguish between forms like registration, subscription, etc.
    private String submittedBy; // User who submitted the form
    private String data; // Serialized or structured form data

    public FormSubmission() {
    }

    public FormSubmission(String formType, String submittedBy, String data) {
        this.formType = formType;
        this.submittedBy = submittedBy;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

