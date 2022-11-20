package com.gabrielle.prontoar.repository;

import com.gabrielle.prontoar.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

   @Query(value = "select p from api_patient p where p.cpf like %?1%")
   List<Patient> findByCpf(String cpf);
}
