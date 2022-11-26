package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Chart;
import com.gabrielle.prontoar.repository.ChartRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartService {

    private ChartRepository chartRepository;

    public List<Chart> list() {
        return this.chartRepository.findAll();
    }

    public Chart createChart(Chart chart) {
        return this.chartRepository.save(chart);
    }

    public ResponseEntity<Chart> updateById(Chart chart, Long id) {
        return this.chartRepository.findById(id)
                .map(chartToUpdate -> {
                    chartToUpdate.setBloodPressure(chart.getBloodPressure());
                    chartToUpdate.setDate(chart.getDate());
                    chartToUpdate.setDeficit(chart.getDeficit());
                    chartToUpdate.setGeneralState(chart.getGeneralState());
                    chartToUpdate.setIllnesses(chart.getIllnesses());
                    chartToUpdate.setIst(chart.getIst());
                    chartToUpdate.setOccurrences(chart.getOccurrences());
                    chartToUpdate.setPlaint(chart.getPlaint());
                    chartToUpdate.setPrescription(chart.getPrescription());
                    chartToUpdate.setTemperature(chart.getTemperature());
                    Chart chartUpdated = chartRepository.save(chartToUpdate);
                    return ResponseEntity.ok().body(chartUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public Chart findPatientById(Long idPatient) {
        return this.chartRepository.findPatientById(idPatient);
    }

    public ResponseEntity<Chart> findChartById(Long id) {
        return this.chartRepository.findById(id)
                .map(chart -> ResponseEntity.ok().body(chart))
                .orElse(ResponseEntity.notFound().build());
    }

}
