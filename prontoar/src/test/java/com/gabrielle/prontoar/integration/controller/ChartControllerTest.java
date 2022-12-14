package com.gabrielle.prontoar.integration.controller;

import com.gabrielle.prontoar.controller.ChartController;
import com.gabrielle.prontoar.entity.Chart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
public class ChartControllerTest {

    Chart chart;
    @Mock
    ChartController charController = new ChartController();

    @BeforeEach
    public void setup() {
        Long idPatient = 1L;
        Long idDoctor = 1L;
        int bloodPressure = 12;
        String plaint = "Não.";
        LocalDate date = LocalDate.parse("2001-11-10");
        int temperature = 19;
        String prescription = "Nada.";
        String occurrences = "Nada.";
        String illnesses = "Nada.";
        String generalState = "Nada.";
        String ist = "Nada.";
        String deficit = "Nada.";

        this.chart = new Chart(idPatient, idDoctor, bloodPressure, plaint, date, temperature, prescription,
                occurrences, illnesses, generalState, ist, deficit);
    }

    @Test
    public void saveChart() {
        charController.createChart(chart);
        Mockito.when(charController.createChart(chart)).thenReturn(chart);
    }
}
