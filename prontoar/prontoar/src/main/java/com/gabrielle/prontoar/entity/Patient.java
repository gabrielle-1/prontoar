package com.gabrielle.prontoar.entity;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@ToString
@Entity(name = "api_patient")
@AllArgsConstructor
public class Patient extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long cpf;

    @Column(nullable = false)
    private String socialName;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private double height;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(nullable = false)
    private LocalDate birthDate;

    public Patient() {
    }

    public Patient(String name, String email, String password, String phoneNumber, int age, String address, char gender,
            Long cpf,
            String socialName, double weight, double height, LocalDate birthDate) {
        super(name, email, password, phoneNumber, age, address, gender);
        this.cpf = cpf;
        this.socialName = socialName;
        this.weight = weight;
        this.height = height;
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
