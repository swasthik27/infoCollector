package com.AvirantEnterprises.InfoCollector_AE.repository;



import com.AvirantEnterprises.InfoCollector_AE.model.FormSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<FormSubmission, Long> {
    // JpaRepository already provides methods like save, findAll, findById, delete, etc.
}
