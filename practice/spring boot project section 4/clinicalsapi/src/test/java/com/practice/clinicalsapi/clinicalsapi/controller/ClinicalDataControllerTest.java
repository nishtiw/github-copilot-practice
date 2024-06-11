package com.practice.clinicalsapi.clinicalsapi.controller;

import com.practice.clinicalsapi.clinicalsapi.models.ClinicalData;
import com.practice.clinicalsapi.clinicalsapi.models.Patient;
import com.practice.clinicalsapi.clinicalsapi.repos.ClinicalDataRepository;
import com.practice.clinicalsapi.clinicalsapi.repos.PatientRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * This class contains unit tests for the ClinicalDataController class.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ClinicalDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClinicalDataRepository clinicalDataRepository;

    @MockBean
    private PatientRepository patientRepository;

    /**
     * Test case for creating clinical data.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testCreateClinicalData() throws Exception {
        ClinicalData clinicalData = new ClinicalData();
        when(clinicalDataRepository.save(any(ClinicalData.class))).thenReturn(clinicalData);

        mockMvc.perform(post("/clinicaldata")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{}"));
    }

    /**
     * Test case for getting all clinical data.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testGetClinicalData() throws Exception {
        ClinicalData clinicalData = new ClinicalData();
        when(clinicalDataRepository.findAll()).thenReturn(Arrays.asList(clinicalData));

        mockMvc.perform(get("/clinicaldata"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}]"));
    }

    /**
     * Test case for getting clinical data by ID when it exists.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testGetClinicalDataExists() throws Exception {
        ClinicalData clinicalData = new ClinicalData();
        when(clinicalDataRepository.findById(1L)).thenReturn(Optional.of(clinicalData));

        mockMvc.perform(get("/clinicaldata/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    /**
     * Test case for getting clinical data by ID when it does not exist.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testGetClinicalDataNotExists() throws Exception {
        when(clinicalDataRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/clinicaldata/1"))
                .andExpect(status().isNotFound());
    }

    /**
     * Test case for updating clinical data.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testUpdateClinicalData() throws Exception {
        ClinicalData clinicalData = new ClinicalData();
        when(clinicalDataRepository.save(any(ClinicalData.class))).thenReturn(clinicalData);

        mockMvc.perform(put("/clinicaldata/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }

    /**
     * Test case for deleting clinical data.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testDeleteClinicalData() throws Exception {
        mockMvc.perform(delete("/clinicaldata/1"))
                .andExpect(status().isNoContent());

        verify(clinicalDataRepository, times(1)).deleteById(1L);
    }

    /**
     * Test case for saving clinical data for a specific patient.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void testSaveClinicalData() throws Exception {
        ClinicalData clinicalData = new ClinicalData();
        when(patientRepository.findById(1L)).thenReturn(Optional.of(new Patient()));
        when(clinicalDataRepository.save(any(ClinicalData.class))).thenReturn(clinicalData);

        mockMvc.perform(post("/clinicaldata/patient/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{}"));
    }
}