package com.gabrielle.prontoar.entity;

import lombok.ToString;

import javax.persistence.*;

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

    private double bloodPressure;

    private double clinicalSigns;

    private String prescriptions;

    private String allergy;

    private String diabetes;

    private String medication;

    private String diseaseProgresses;

    private String diseaseGifts;

    private String previousSurgeries;

    // public Chart(Long id, Long idPatient, Long idDoctor) {
    // this.id = id;
    // this.idPatient = idPatient;
    // this.idDoctor = idDoctor;
    // }

    public Chart() {
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