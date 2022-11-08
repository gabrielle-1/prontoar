package com.gabrielle.prontoar.controller;

import com.gabrielle.prontoar.entity.Doctor;
import com.gabrielle.prontoar.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/doctors")
@Slf4j
@AllArgsConstructor
public class DoctorController {

    DoctorService doctorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getAllDoctors() {
        return this.doctorService.listDoctors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return this.doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorByID(@PathVariable(value = "id") Long id) {
        return this.doctorService.findDoctorById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctorByID(@PathVariable(value = "id") Long id, @RequestBody Doctor doctor) {
        return this.doctorService.updateDoctorById(doctor, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDoctorByID(@PathVariable(value = "id") Long id) {
        return this.doctorService.deleteDoctorById(id);
    }

}
