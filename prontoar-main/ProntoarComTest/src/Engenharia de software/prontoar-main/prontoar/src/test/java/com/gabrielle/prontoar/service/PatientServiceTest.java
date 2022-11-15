package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Patient;
import com.gabrielle.prontoar.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {

    PatientService patientService;

    @Test
    public void patientTestServiceCreateReturningPatient(){
        /* LocalDate birthDate = LocalDate.parse("2001-11-10");

        Patient patient = new Patient("Gabrielle", "11263628273", 21, , 'F',
                "81987980601", "email@gmail.com", 65.0, 1.71, "1234");
        var createPatient = this.patientService.createPatient(patient);
        Assertions.assertEquals(patient, createPatient);

         */
    }

}
