package com.gabrielle.prontoar.service;

import com.gabrielle.prontoar.entity.Chart;
import com.gabrielle.prontoar.repository.ChartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChartService {

    private ChartRepository chartRepository;

    public List<Chart> list() {
        return this.chartRepository.findAll();
    }

    public Chart createChart(Chart chart) {
        return this.chartRepository.save(chart);
    }


}
