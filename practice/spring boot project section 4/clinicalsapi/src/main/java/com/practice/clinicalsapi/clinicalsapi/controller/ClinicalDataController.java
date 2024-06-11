package com.practice.clinicalsapi.clinicalsapi.controller;

import com.practice.clinicalsapi.clinicalsapi.models.ClinicalData;
import com.practice.clinicalsapi.clinicalsapi.repos.ClinicalDataRepository;
import com.practice.clinicalsapi.clinicalsapi.repos.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/clinicaldata")
public class ClinicalDataController {

    @Autowired
    private ClinicalDataRepository clinicalDataRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    public ResponseEntity<ClinicalData> createClinicalData(@RequestBody ClinicalData clinicalData) {
        ClinicalData savedClinicalData = clinicalDataRepository.save(clinicalData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClinicalData);
    }

    @GetMapping
    public ResponseEntity<List<ClinicalData>> getClinicalData() {
        List<ClinicalData> clinicalData = clinicalDataRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(clinicalData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalData> getClinicalData(@PathVariable Long id) {
        Optional<ClinicalData> clinicalData = clinicalDataRepository.findById(id);
        if(clinicalData.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clinicalData.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalData> updateClinicalData(@PathVariable Long id, @RequestBody ClinicalData clinicalData) {
        clinicalData.setId(id);
        ClinicalData updatedClinicalData = clinicalDataRepository.save(clinicalData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedClinicalData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinicalData(@PathVariable Long id) {
        clinicalDataRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Method that receives patient id, clinical data and saves it to the database
    @PostMapping("/patient/{id}")
    public ResponseEntity<ClinicalData> saveClinicalData(@PathVariable Long id, @RequestBody ClinicalData clinicalData) {
        clinicalData.setPatient(patientRepository.findById(id).get());
        ClinicalData savedClinicalData = clinicalDataRepository.save(clinicalData);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClinicalData);
    }
}