package com.practice.clinicalsapi.clinicalsapi.controller;

import java.util.logging.Logger;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practice.clinicalsapi.clinicalsapi.handler.PatientNotFoundException;
import com.practice.clinicalsapi.clinicalsapi.models.Patient;
import com.practice.clinicalsapi.clinicalsapi.repos.PatientRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    private static final Logger LOGGER = Logger.getLogger(PatientController.class.getName());

    /**
     * Create a new patient.
     *
     * @param patient The patient object to be created.
     * @return ResponseEntity containing the created patient object or an error message.
     */
    @PostMapping
    public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
        try {
            Patient createdPatient = patientRepository.save(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating patient: " + e.getMessage());
        }
    }

    /**
     * Get all patients.
     *
     * @return ResponseEntity containing a list of all patients or an error message.
     */
    @GetMapping
    public ResponseEntity<?> getPatients() {
        try {
            List<Patient> patients = patientRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(patients);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error getting patients: " + e.getMessage());
        }
    }

    /**
     * Get a specific patient by ID.
     *
     * @param id The ID of the patient to retrieve.
     * @return ResponseEntity containing the patient object or an error message.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Long id) {
        try {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new Exception("Patient not found"));
            return ResponseEntity.status(HttpStatus.OK).body(patient);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error getting patient: " + e.getMessage());
        }
    }

    /**
     * Update a specific patient by ID.
     *
     * @param id             The ID of the patient to update.
     * @param patientDetails The updated patient object.
     * @return ResponseEntity containing the updated patient object or an error message.
     * @throws PatientNotFoundException if the patient is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        try {
            Patient patient = patientRepository.findById(id)
                    .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
            patient.setFirstName(patientDetails.getFirstName());
            patient.setLastName(patientDetails.getLastName());
            patient.setAge(patientDetails.getAge());
            Patient updatedPatient = patientRepository.save(patient);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPatient);
        } catch (PatientNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Patient not found", e);
            throw e;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating patient: " + e.getMessage());
        }
    }

    /**
     * Delete a specific patient by ID.
     *
     * @param id The ID of the patient to delete.
     * @return ResponseEntity containing a success message or an error message.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        try {
            patientRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Patient deleted successfully");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting patient: " + e.getMessage());
        }
    }
}