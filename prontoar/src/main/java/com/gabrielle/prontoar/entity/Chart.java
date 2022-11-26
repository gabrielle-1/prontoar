package com.gabrielle.prontoar.entity;

import lombok.ToString;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@ToString
@Entity(name = "api_chart")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idPatient;

    @Column(nullable = false)
    private Long idDoctor;

    private int bloodPressure;

    private String plaint;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate date;

    private int temperature;

    private String prescription;

    private String occurrences;

    private String illnesses;

    private String generalState;

    private String ist;

    private String deficit;

    public Chart(Long idPatient, Long idDoctor, int bloodPressure, String plaint, LocalDate date, int temperature,
            String prescription, String occurrences, String illnesses, String generalState, String ist,
            String deficit) {
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
        this.bloodPressure = bloodPressure;
        this.plaint = plaint;
        this.date = date;
        this.temperature = temperature;
        this.prescription = prescription;
        this.occurrences = occurrences;
        this.illnesses = illnesses;
        this.generalState = generalState;
        this.ist = ist;
        this.deficit = deficit;
    }

    public Chart() {

    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getPlaint() {
        return plaint;
    }

    public void setPlaint(String plaint) {
        this.plaint = plaint;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(String occurrences) {
        this.occurrences = occurrences;
    }

    public String getIllnesses() {
        return illnesses;
    }

    public void setIllnesses(String illnesses) {
        this.illnesses = illnesses;
    }

    public String getGeneralState() {
        return generalState;
    }

    public void setGeneralState(String generalState) {
        this.generalState = generalState;
    }

    public String getIst() {
        return ist;
    }

    public void setIst(String ist) {
        this.ist = ist;
    }

    public String getDeficit() {
        return deficit;
    }

    public void setDeficit(String deficit) {
        this.deficit = deficit;
    }

    public Long getId() {
        return id;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }
}
