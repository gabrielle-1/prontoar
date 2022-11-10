package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Patient;
import com.gabrielle.prontoar.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

<<<<<<< HEAD
    public Patient createPatient(Patient patient){
        return this.patientRepository.save(patient);
    }

    public List<Patient> list(){
        return this.patientRepository.findAll();
    }

    public ResponseEntity<Patient> findById(Long id){
=======
    public Patient createPatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    public List<Patient> list() {
        return this.patientRepository.findAll();
    }

    public ResponseEntity<Patient> findById(Long id) {
>>>>>>> origin/other
        return this.patientRepository.findById(id)
                .map(patient -> ResponseEntity.ok().body(patient))
                .orElse(ResponseEntity.notFound().build());
    }

<<<<<<< HEAD
    public ResponseEntity<Patient> updateById(Patient patient, Long id){
        return this.patientRepository.findById(id)
                .map( patientToUpdate -> {
=======
    public ResponseEntity<Patient> updateById(Patient patient, Long id) {
        return this.patientRepository.findById(id)
                .map(patientToUpdate -> {
>>>>>>> origin/other
                    patientToUpdate.setName(patient.getName());
                    patientToUpdate.setWeight(patient.getWeight());
                    patientToUpdate.setHeight(patient.getHeight());
                    patientToUpdate.setAge(patient.getAge());
<<<<<<< HEAD
                    patientToUpdate.setEmail(patient.getEmail());
=======
>>>>>>> origin/other
                    patientToUpdate.setPhoneNumber(patient.getPhoneNumber());

                    Patient patientUpdated = patientRepository.save(patientToUpdate);
                    return ResponseEntity.ok().body(patientUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

<<<<<<< HEAD
    public ResponseEntity<Object> deleteById(Long id){
        return this.patientRepository.findById(id)
                .map( patientToDelete -> {
=======
    public ResponseEntity<Object> deleteById(Long id) {
        return this.patientRepository.findById(id)
                .map(patientToDelete -> {
>>>>>>> origin/other
                    patientRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
