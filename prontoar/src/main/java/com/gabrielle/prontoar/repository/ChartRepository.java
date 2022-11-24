package com.gabrielle.prontoar.repository;

import com.gabrielle.prontoar.entity.Chart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartRepository extends JpaRepository<Chart, Long> {
    Chart findPatientById(Long idPatient);
}
