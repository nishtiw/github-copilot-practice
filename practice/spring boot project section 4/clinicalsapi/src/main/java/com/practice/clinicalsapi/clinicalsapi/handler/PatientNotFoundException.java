package com.practice.clinicalsapi.clinicalsapi.handler;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}