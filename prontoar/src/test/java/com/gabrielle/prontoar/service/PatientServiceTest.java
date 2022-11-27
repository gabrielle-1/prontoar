package com.gabrielle.prontoar.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gabrielle.prontoar.entity.Patient;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {

    Patient patient;

    @Mock
    PatientService patientService;

    @BeforeEach
    public void setup() {
        String name = "Ana Maria";
        Long cpf = 87688962657L;
        int age = 21;
        char gender = 'F';
        String phoneNumber = "827723283";
        String email = "anamaria@gmail.com";
        double weight = 74;
        double height = 1.74;
        String address = "Rua Boa Vista";
        LocalDate birthDate = LocalDate.parse("2001-11-10");
        String socialName = "";
        String password = "";

        this.patient = new Patient(name, email, password, phoneNumber, age, address, gender, cpf, socialName, weight,
                height, birthDate);
    }

    @Test
    public void patientServiceRunCreateMethodTest() {
        patientService.createPatient(patient);
        Mockito.verify(patientService).createPatient(patient);
    }

    @Test
    public void patientServiceFindPatientByCPFTest() {
        patientService.createPatient(patient);
        Mockito.when(patientService.findByCpf(99899828L)).thenReturn(patient);
        Assertions.assertEquals(patient, patientService.findByCpf(99899828L));
    }

}
