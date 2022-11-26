package com.gabrielle.prontoar.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gabrielle.prontoar.entity.Patient;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {

    PatientService patientService;

    @Test
    public void patientTestServiceCreateReturningPatient() {
        String name = "Ana Maria";
        Long cpf = 99899828L;
        int age = 12;
        char gender = 'f';
        String phoneNumber = "827723283";
        String email = "anamaria@gmail.com";
        String nameCompanion = "Ana Claudia Santos";
        double weight = 74;
        double height = 1.74;
        String address = "Rua Boa Vista";
        LocalDate birthDate = LocalDate.parse("2001-11-10");
        String socialName = "";
        String password = "";

        Patient patient = new Patient(name, email, password, phoneNumber, age, address, gender, cpf, socialName, weight,
                height, birthDate);

        Mockito.verify(patientService.createPatient(patient));

        // var createPatient = this.patientService.createPatient(patient);
        // Assertions.assertEquals(patient, createPatient);

    }

}
