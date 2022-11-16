package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Doctor;
import com.gabrielle.prontoar.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorService {

    private DoctorRepository doctorRepository;

    public List<Doctor> listDoctors() {
        return this.doctorRepository.findAll();
    }

    public Doctor createDoctor(Doctor doctor) {
        return this.doctorRepository.save(doctor);
    }

    public ResponseEntity<Doctor> findDoctorById(Long id) {
        return this.doctorRepository.findById(id)
                .map(doctor -> ResponseEntity.ok().body(doctor))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Doctor> updateDoctorById(Doctor doctor, Long id) {
        return this.doctorRepository.findById(id)
                .map(patientToUpdate -> {
                    patientToUpdate.setName(doctor.getName());
                    patientToUpdate.setAge(doctor.getAge());
                    patientToUpdate.setPhoneNumber(doctor.getPhoneNumber());

                    Doctor patientUpdated = doctorRepository.save(patientToUpdate);
                    return ResponseEntity.ok().body(patientUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteDoctorById(Long id) {
        return this.doctorRepository.findById(id)
                .map(patientToDelete -> {
                    doctorRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
