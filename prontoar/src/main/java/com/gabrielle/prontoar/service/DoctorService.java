package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Doctor;
import com.gabrielle.prontoar.repository.DoctorRepository;
import com.gabrielle.prontoar.security.Token;
import com.gabrielle.prontoar.security.TokenUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;
    private PasswordEncoder passwordEncoder;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Doctor> listDoctors() {
        return this.doctorRepository.findAll();
    }

    public Doctor createDoctor(Doctor doctor) {
        String encoder = this.passwordEncoder.encode(doctor.getPassword());
        doctor.setPassword(encoder);
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

    public boolean validPassword(Doctor doctor) {
        String password = this.doctorRepository.findById(doctor.getId()).get().getPassword();
        Boolean valid = passwordEncoder.matches(doctor.getPassword(), password);
        return valid;
    }

    public Token generateToken(Doctor doctor) {
        Doctor doctorFind = doctorRepository.findByEmail(doctor.getEmail());
        if(doctorFind != null){
            Boolean valid = passwordEncoder.matches(doctor.getPassword(), doctorFind.getPassword());
            if(valid){
                return new Token(TokenUtil.createToken(doctor));
            }
        }
        return null;
    }

}
