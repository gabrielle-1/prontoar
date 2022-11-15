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

    // @GetMapping("/find/{cpf}")
    // public ResponseEntity<Patient> getPatientByCPF(@PathVariable(value = "cpf")
    // String cpf) {
    // return this.patientService.findByCpf(cpf);
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatientByID(@PathVariable(value = "id") Long id,
            @RequestBody Patient patient) {
        return this.patientService.updateById(patient, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatientByID(@PathVariable(value = "id") Long id) {
        return this.patientService.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<Patient> login(@RequestBody Patient patient) {
        Boolean validPassword = patientService.validPassword(patient);
        if (validPassword) {
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
