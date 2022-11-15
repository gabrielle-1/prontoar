package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Patient;
import com.gabrielle.prontoar.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;
    private PasswordEncoder passwordEncoder;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Patient createPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    public List<Patient> list() {
        return this.patientRepository.findAll();
    }

    public ResponseEntity<Patient> findById(Long id) {
        return this.patientRepository.findById(id)
                .map(patient -> ResponseEntity.ok().body(patient))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Patient> findByCpf(String cpf) {
        return this.patientRepository.findByCpf(cpf)
                .map(patient -> ResponseEntity.ok().body(patient)).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Patient> updateById(Patient patient, Long id) {
        return this.patientRepository.findById(id)
                .map(patientToUpdate -> {
                    patientToUpdate.setName(patient.getName());
                    patientToUpdate.setWeight(patient.getWeight());
                    patientToUpdate.setHeight(patient.getHeight());
                    patientToUpdate.setAge(patient.getAge());
                    patientToUpdate.setPhoneNumber(patient.getPhoneNumber());

                    Patient patientUpdated = patientRepository.save(patientToUpdate);
                    return ResponseEntity.ok().body(patientUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteById(Long id) {
        return this.patientRepository.findById(id)
                .map(patientToDelete -> {
                    patientRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    public boolean validPassword(Patient patient) {
        String password = this.patientRepository.findById(patient.getId()).get().getPassword();
        Boolean valid = passwordEncoder.matches(patient.getPassword(), password);
        return valid;
    }
}
