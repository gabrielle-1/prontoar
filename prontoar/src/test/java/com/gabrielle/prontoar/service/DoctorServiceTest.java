package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class DoctorServiceTest {

    Doctor doctor;
    @Mock
    DoctorService doctorService = new DoctorService();

    @BeforeEach
    public void setup(){
        String name = "João Carlos";
        String email = "joaocarlos@gmail.com";
        String phoneNumber = "827723283";
        int age = 45;
        String address = "Rua Boa Vista";
        char gender = 'f';
        String crm = "3342";
        String password = crm;

        this.doctor = new Doctor(name, email, password, phoneNumber, age, address, gender, crm);
    }

    @Test
    public void doctorServiceRunCreateMethodTest() {
        doctorService.createDoctor(doctor);
        Mockito.verify(doctorService).createDoctor(doctor);
    }


}
