package com.gabrielle.prontoar.unitary.service;

import com.gabrielle.prontoar.entity.Patient;
import com.gabrielle.prontoar.service.PatientService;
//import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PatientServiceTest {
    
    Patient patient;
    PatientService patientService;
    
    
    @BeforeEach
    public void setup(){
    this.patient = new Patient();
}
   
    
    @Test
    public void patientTestServiceCreateReturningPatient(){
        var createPatient = this.patientService.createPatient(patient);
        Assertions.assertEquals(patient, createPatient);
    }
    
     @Test
    public void patientTestServiceCreateReturningNotPatient(){        
        var createPatient = this.patientService.createPatient(patient);
        Assertions.assertNotEquals("Não foi encontrado paciente", createPatient);
    }
    
    @Test
    public void patientTestServiceReturningNullList(){
        var listPatient = this.patientService.list();
        Assertions.assertNull(listPatient, "Lista não econtrada");
    }
    
    @Test
    public void patienteTestServiceReturningList(){
        var listPatient = this.patientService.list();
        Assertions.assertNotNull(listPatient, "Lista encontrada");
    }
    
    @Test
    public void patientTestServiceReturningFindByIdNotExist(){
       var findId = this.patientService.findById(this.patient.getId());
       Assertions.assertNull(findId, "Id não encontrado");
    }
    
     @Test
     public void patientTestServiceReturningFindById(){
       var findId = this.patientService.findById(this.patient.getId());
       Assertions.assertNotNull(findId, "Id encontrado");
    }
     
     @Test
     public void patientTestServiceReturningFindByCpf(){
         var findCpf =  this.patientService.findByCpf(this.patient.getCpf());
         Assertions.assertNotNull(findCpf, "CPF encontrado");
     }
    
    @Test
    public void patientTestServiceReturningFindByCpfNotExist(){
        var findCpf = this.patientService.findByCpf(this.patient.getCpf());
        Assertions.assertNull(findCpf, "CPF não encontrado");
    }
    
    @Test
    public void patientTestServiceReturningUpdateByIdNotExist(){
        var updateId = this.patientService.updateById(patient, this.patient.getId());
        Assertions.assertNull(updateId, "Id não encontrado");
    }
    
    @Test
    public void patientTestServiceReturningUpdateById(){
        var updateId = this.patientService.updateById(patient, this.patient.getId());
        Assertions.assertNotNull(updateId, "Atualizado com sucesso!");
    }
    
    @Test
    public void patientTestServiceReturningDeleteById(){
        var deleteId = this.patientService.deleteById(this.patient.getId());
        Assertions.assertNull(deleteId,  "Id não encontrado");
    }
    
    @Test
    public void patientTestServiceReturningDeleteByIdNotExist(){
        var deleteId = this.patientService.deleteById(this.patient.getId());
        Assertions.assertNotNull(deleteId,  "Excluido com sucesso!");
    }
}