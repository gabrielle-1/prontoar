package com.gabrielle.prontoar.controller;

import com.gabrielle.prontoar.entity.Chart;
import com.gabrielle.prontoar.service.ChartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/charts")
@Slf4j
@AllArgsConstructor
public class ChartController {

    ChartService chartService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Chart> getAllCharts() {
        return this.chartService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chart createChart(@RequestBody Chart chart) {
        return this.chartService.createChart(chart);
    }

}
