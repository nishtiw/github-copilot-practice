package com.practice.clinicalsapi.clinicalsapi.repos;

import com.practice.clinicalsapi.clinicalsapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}