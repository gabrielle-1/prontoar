package com.gabrielle.prontoar.controller;

import com.gabrielle.prontoar.entity.Patient;
import com.gabrielle.prontoar.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/patients")
@Slf4j
@AllArgsConstructor
public class PatientController {

    PatientService patientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return this.patientService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient) {
        return this.patientService.createPatient(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientByID(@PathVariable(value = "id") Long id) {
        return this.patientService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatientByID(@PathVariable(value = "id") Long id,
            @RequestBody Patient patient) {
        return this.patientService.updateById(patient, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatientByID(@PathVariable(value = "id") Long id) {
        return this.patientService.deleteById(id);
    }
}
