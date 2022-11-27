package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Doctor;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
public class DoctorServiceTest {
    
    Doctor doctor;
    DoctorService doctorService;
    
    
    @BeforeEach
    public void setup(){
        this.doctor = new Doctor();
    }
    
            
    @Test
    public void doctorTestServiceReturningList(){
        var listDoctors = this.doctorService.listDoctors();
        Assertions.assertNotNull(listDoctors, "Lista encontrada");
    }
    
    @Test
    public void doctorTestServiceReturningListNotExist(){
        var listDoctors = this.doctorService.listDoctors();
        Assertions.assertNull(listDoctors, "Lista não encontrada");
    }
    
    @Test
    public void doctorTestServiceReturningDoctor(){
        var createDoctors = this.doctorService.createDoctor(doctor);
        Assertions.assertEquals(doctor, createDoctors);
    }
    
    @Test
    public void doctorTestServiceReturningDoctorNotExiste(){
        var createDoctor = this.doctorService.createDoctor(doctor);
        Assertions.assertNotEquals("Nada encontrado", createDoctor);
    }
    
     @Test
    public void doctorTestServiceReturningfindDoctorByIdNotExist(){
       var findDoctorById = this.doctorService.findDoctorById(this.doctor.getId());
       Assertions.assertNull(findDoctorById, "Id não encontrado");
    }
    
     @Test
     public void doctorTestServiceReturningfindDoctorById(){
       var findDoctorById =  this.doctorService.findDoctorById(this.doctor.getId());
       Assertions.assertNotNull(findDoctorById, "Id encontrado");
    }
     
        
    @Test
    public void doctorTestServiceReturningUpdateDoctorByIdNotExist(){
        var updateDoctorById = this.doctorService.updateDoctorById(doctor, this.doctor.getId());
        Assertions.assertNull(updateDoctorById, "Id não encontrado");
    }
    
    @Test
    public void doctorTestServiceReturningUpdateDoctorById(){
        var updateDoctorById = this.doctorService.updateDoctorById(doctor, this.doctor.getId());
        Assertions.assertNotNull(updateDoctorById, "Atualizado com sucesso!");
    }
    
    @Test
    public void doctorTestServiceReturningDeleteDoctorById(){
        var deleteDoctorById = this.doctorService.deleteDoctorById(this.doctor.getId());
        Assertions.assertNull(deleteDoctorById,  "Id não encontrado");
    }
    
    @Test
    public void doctorTestServiceReturningDeleteDoctorByIdNotExist(){
        var deleteDoctorById = this.doctorService.deleteDoctorById(this.doctor.getId());
        Assertions.assertNotNull(deleteDoctorById,  "Excluido com sucesso!");
    }
    
    @Test
    public void doctorTestServiceReturningValidate(){
        var validate = this.doctorService.validate(doctor);
        Assertions.assertTrue(validate, "validado com sucesso");
    }
    
    @Test
    public void doctorTestServiceReturningValidateNotExist(){
        var validate = this.doctorService.validate(doctor);
        Assertions.assertFalse(null, "Erro");
    }
          
}
